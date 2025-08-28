package com.demo.service.entrypoint.user.service;

import java.util.Map;

import com.demo.service.entrypoint.user.dto.response.UserResponseDto;
import com.demo.service.entrypoint.user.repository.user.UserRepositoryHelper;
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
