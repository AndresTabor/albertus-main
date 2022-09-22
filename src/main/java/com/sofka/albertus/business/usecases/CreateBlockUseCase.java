package com.sofka.albertus.business.usecases;


import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.domain.BlockChain;
import com.sofka.albertus.domain.commands.CreateBlock;
import com.sofka.albertus.domain.values.BlockChainId;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.logging.Level;

import static io.netty.util.CharsetUtil.UTF_8;


@Component
@Slf4j
public class CreateBlockUseCase {

    private final DomainEventRepository repository;

    private final EventBus bus;

    public CreateBlockUseCase(DomainEventRepository repository, EventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public Flux<DomainEvent> apply(Mono<CreateBlock> createBlockCommand){

        //TODO Validar que el Application ID si exista en la base de datos, PUEDE SER con el


        return createBlockCommand.flatMapMany(command -> repository.findById(command.getBlockChainID())
                .collectList()
                .flatMapIterable(eventsFromRepository -> {
                    BlockChain blockChain = BlockChain.from(BlockChainId.of(command.getBlockChainID()),eventsFromRepository);
                    //TODO Pendiente la validación de que haya 5 bloques creados en el día
                    //TODO para marcar el bloque con hasOverCharge=true, por el momento es false
                    String previousHash = blockChain.getBlocks().get(blockChain.getBlocks().size()-1).value().previousHash();
                    String nonce = String.valueOf((int) (Math.random() * 10000));
                    String data = command.getData();
                    Instant instant = Instant.now();
                    String timeStamp = String.valueOf(instant);
                    //TODO Para calcular averiguar como sacar el día al instant, recorrer los bloques
                    //TODO contando los que sean del mismo día del instant y si es mayor a 5
                    //TODO se pone como true el overCharge
                    Boolean hasOverCharge = false;
                    String hasOverChargeString = hasOverCharge.toString();
                    String dataToHash = timeStamp + nonce + data + previousHash + hasOverChargeString;
                    MessageDigest digest = null;
                    byte[] bytes = null;
                    try {
                        digest = MessageDigest.getInstance("MD5");
                        bytes = digest.digest(dataToHash.getBytes(UTF_8));
                    } catch (NoSuchAlgorithmException ex) {
                        log.info((Marker) Level.SEVERE, ex.getMessage());
                    }

                    StringBuffer buffer = new StringBuffer();
                    for (byte b : bytes) {
                        buffer.append(String.format("%02x", b));
                    }
                    String hash = buffer.toString();

                    blockChain.CreateBlock(data, command.getApplicationID(),
                            hash,
                            instant,
                            Integer.valueOf(nonce),
                            hasOverCharge,
                            previousHash );

                    return blockChain.getUncommittedChanges();
                }).flatMap(event -> repository.saveEvent(event).thenReturn(event)).doOnNext(bus::publish)
                .doOnError(error -> log.error(String.valueOf(error))));
    }


}


