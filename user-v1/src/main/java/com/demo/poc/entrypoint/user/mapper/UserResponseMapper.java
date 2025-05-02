package com.demo.poc.entrypoint.user.mapper;

import com.demo.poc.entrypoint.user.dto.response.UserResponseDto;
import com.demo.poc.entrypoint.user.repository.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

  @Mapping(target = "active", source = "status")
  UserResponseDto toDto(UserEntity user);
}
