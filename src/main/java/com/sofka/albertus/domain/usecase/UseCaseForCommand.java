package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class UseCaseForCommand<T extends Command> implements Function<Mono<T>, Flux<DomainEvent>> {

}
