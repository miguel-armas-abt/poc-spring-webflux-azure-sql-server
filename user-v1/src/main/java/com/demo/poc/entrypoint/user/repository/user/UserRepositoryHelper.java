package com.demo.poc.entrypoint.user.repository.user;

import com.demo.poc.commons.custom.exceptions.NoSuchUserException;
import com.demo.poc.entrypoint.user.dto.response.UserResponseDto;
import com.demo.poc.entrypoint.user.mapper.UserResponseMapper;
import com.demo.poc.entrypoint.user.repository.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryHelper {

  private final UserRepository repository;
  private final JdbcTemplate jdbcTemplate;
  private final UserResponseMapper responseMapper;

  public Mono<UserResponseDto> findByUserId(long userId) {
    Mono<UserEntity> base = repository.findByUserId(userId)
        .switchIfEmpty(Mono.error(new NoSuchUserException(userId)));

    Mono<String> decryptedDocumentNumber = Mono
        .fromCallable(() -> {
          String sql = "SELECT identity_document_number FROM [user] WHERE user_id = ?";
          return jdbcTemplate.queryForObject(sql, String.class, userId);
        })
        .subscribeOn(Schedulers.boundedElastic());

    return Mono.zip(base, decryptedDocumentNumber)
        .map(tuple -> {
          UserEntity entity = tuple.getT1();
          String docNumber = tuple.getT2();

          entity.setDocumentNumber(docNumber);
          return responseMapper.toDto(entity);
        });
  }
}
