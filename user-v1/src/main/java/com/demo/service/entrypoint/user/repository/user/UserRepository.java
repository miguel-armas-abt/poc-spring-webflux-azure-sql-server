package com.demo.service.entrypoint.user.repository.user;

import com.demo.service.entrypoint.user.repository.user.entity.UserEntity;
import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {

  //Don't include encrypted columns
  @Query("""
    SELECT
      user_id,
      identity_document_type,
      CAST(process_traceId AS VARCHAR(36)) AS process_traceId,
      status
    FROM [user]
    WHERE user_id = :userId
    """)
  Mono<UserEntity> findByUserId(@Param("userId") Long userId);

}
