package com.sofka.albertus.application.handlers;


import com.sofka.albertus.business.usecases.CreateBlockChainUseCase;

import com.sofka.albertus.business.usecases.CreateBlockUseCase;
import com.sofka.albertus.domain.commands.CreateBlock;
import com.sofka.albertus.domain.commands.CreateBlockChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CommandHandle {


  @Bean
  public RouterFunction<ServerResponse> createBlockChain(CreateBlockChainUseCase usecase) {
    return RouterFunctions.route(
        RequestPredicates.POST("/create/blockChain")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
        request -> usecase.apply(request.bodyToMono(CreateBlockChain.class))
            .then(ServerResponse.ok().build())

    );
  }

  @Bean
  public RouterFunction<ServerResponse> createBlock(CreateBlockUseCase usecase) {
    return RouterFunctions.route(
        RequestPredicates.POST("/create/block")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
        request -> usecase.apply(request.bodyToMono(CreateBlock.class))
            .then(ServerResponse.ok().build())

    );
  }


}
