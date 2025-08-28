package com.demo.service.entrypoint.user.mapper;

import com.demo.service.entrypoint.user.dto.response.UserResponseDto;
import com.demo.service.entrypoint.user.repository.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

  @Mapping(target = "active", source = "status")
  UserResponseDto toDto(UserEntity user);
}
