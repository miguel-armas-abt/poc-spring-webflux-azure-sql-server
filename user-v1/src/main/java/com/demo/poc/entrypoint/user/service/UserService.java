package com.demo.poc.entrypoint.user.service;

import com.demo.poc.entrypoint.user.dto.response.UserResponseDto;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface UserService {

  Mono<UserResponseDto> findUserById(Map<String, String> headers, long userId);
}
