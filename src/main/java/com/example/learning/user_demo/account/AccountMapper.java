package com.example.learning.user_demo.account;

import com.example.learning.user_demo.account.dto.AccountResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Entity → Response DTO
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    AccountResponseDto toDto(Account account);
}
