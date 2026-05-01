package com.example.learning.user_demo.mapper;

import com.example.learning.user_demo.dto.UserRequestDto;
import com.example.learning.user_demo.dto.UserResponseDto;
import com.example.learning.user_demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entity → Response DTO
    UserResponseDto toDto(User user);

    // Request DTO → Entity
    User toEntity(UserRequestDto dto);
}
