package com.demo.service.entrypoint.user.rest;

import com.demo.service.commons.constants.RestConstants;

import static org.springframework.http.MediaType.APPLICATION_NDJSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRestService {

  @Bean("users")
  public RouterFunction<ServerResponse> build(UserHandler userHandler) {
    return nest(
        path(RestConstants.BASE_URI),
        route()
            .GET("/users/{userId}", accept(APPLICATION_NDJSON), userHandler::findUserById)
            .build()
    );
  }
}