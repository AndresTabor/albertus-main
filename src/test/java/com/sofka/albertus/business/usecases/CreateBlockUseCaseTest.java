package com.sofka.albertus.business.usecases;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.application.helpers.BlockHashResponse;
import com.sofka.albertus.business.usecases.gateways.DomainEventRepository;
import com.sofka.albertus.business.usecases.gateways.EventBus;
import com.sofka.albertus.domain.commands.CreateBlock;
import com.sofka.albertus.domain.events.ApplicationRegistered;
import com.sofka.albertus.domain.events.BlockChainCreated;
import com.sofka.albertus.domain.events.BlockCreated;
import com.sofka.albertus.domain.events.GenesisBlockCreated;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Instant;

@ExtendWith(MockitoExtension.class)
class CreateBlockUseCaseTest {

    @Mock
    private EventBus eventBusMock;

    @Mock
    private DomainEventRepository repositoryMock;

    @InjectMocks
    private CreateBlockUseCase usecase;

    @Test
    @DisplayName("createBlockUseCaseTest. Should save both events and publish to Rabbit")
    void createBlockUseCaseTest(){
        var data = new HashMap<String,String>();
        data.put("prueba","hola");
        data.put("nombre","Lu");
        //arrange
        CreateBlock createBlockCommand = new CreateBlock("aplicatioID",data);

        String hash = "ajdkjandaksjdnakj";
        Instant timeStamp = Instant.now();
        Integer nonce = 1;
        Boolean hasOverCharge = false;
        String previousHash = "HashGenesis";

        BlockCreated blockCreatedEvent = new BlockCreated(
                createBlockCommand.getApplicationID(),
                createBlockCommand.getData(),
                hash,
                timeStamp,
                nonce,
                hasOverCharge,
                previousHash
        );

        ApplicationRegistered applicationRegistered = new ApplicationRegistered(
                blockCreatedEvent.getApplicationID(), "Prueba","soy una prueba",true,"101",Instant.now(),Instant.now()
        );

        GenesisBlockCreated genesisBlockCreatedEvent = new GenesisBlockCreated(
                "Genesis Block"
        );


        BDDMockito
                .when(this.repositoryMock.findById(ArgumentMatchers.anyString()))
                .thenReturn(Flux.just(new BlockChainCreated(
                        "098098098",
                        "Santiago Sierra"
                ),genesisBlockCreatedEvent, applicationRegistered));


        BDDMockito
                .when(this.repositoryMock.saveEvent(ArgumentMatchers.any(DomainEvent.class)))
                .thenReturn(Mono.just(blockCreatedEvent));

        //Act
        Mono<BlockHashResponse> savedEvents = this.usecase.apply(Mono.just(createBlockCommand));


        //Assert
        StepVerifier.create(savedEvents)
                .expectNextMatches(events ->
                        "ajdkjandaksjdnakj".equals(events.getHash()) )
                .verifyComplete();

        BDDMockito.verify(this.eventBusMock, BDDMockito.times(1))
                .publish(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .saveEvent(ArgumentMatchers.any(DomainEvent.class));

        BDDMockito.verify(this.repositoryMock, BDDMockito.times(1))
                .findById(ArgumentMatchers.anyString());
    }



}