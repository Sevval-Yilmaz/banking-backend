package com.example.learning.user_demo.user;

import com.example.learning.user_demo.user.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entity → Response DTO
    UserResponseDto toDto(User user);
}
