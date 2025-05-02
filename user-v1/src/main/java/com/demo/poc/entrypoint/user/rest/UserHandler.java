package com.demo.poc.entrypoint.user.rest;

import com.demo.poc.commons.core.restserver.utils.RestServerUtils;
import com.demo.poc.commons.core.validations.headers.DefaultHeaders;
import com.demo.poc.commons.core.validations.ParamValidator;

import java.util.Map;

import com.demo.poc.entrypoint.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

  private final ParamValidator paramValidator;
  private final UserService userService;

  public Mono<ServerResponse> findUserById(ServerRequest serverRequest) {
    Map<String, String> headers = RestServerUtils.extractHeadersAsMap(serverRequest);
    long userId = Long.parseLong(serverRequest.pathVariable("userId"));

    return paramValidator.validateAndGet(headers, DefaultHeaders.class)
        .flatMap(defaultHeaders -> userService.findUserById(headers, userId))
        .flatMap(response -> ServerResponse.ok()
            .headers(httpHeaders -> RestServerUtils.buildResponseHeaders(serverRequest.headers()).accept(httpHeaders))
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(response)));
  }
}
