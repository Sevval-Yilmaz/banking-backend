package com.example.learning.user_demo.mapper;

import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Entity → Response DTO
    AccountResponseDto toDto(Account account);
}
