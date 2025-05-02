package com.demo.poc.entrypoint.user.service;

import java.util.Map;

import com.demo.poc.entrypoint.user.dto.response.UserResponseDto;
import com.demo.poc.entrypoint.user.repository.user.UserRepositoryHelper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepositoryHelper repositoryHelper;

  @Override
  public Mono<UserResponseDto> findUserById(Map<String, String> headers, long userId) {
    return repositoryHelper.findByUserId(userId);
  }
}
