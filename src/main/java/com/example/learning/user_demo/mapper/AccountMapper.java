package com.example.learning.user_demo.mapper;

import com.example.learning.user_demo.dto.AccountRequestDto;
import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Entity → Response DTO
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    AccountResponseDto toDto(Account account);

    // Request DTO → Entity
    @Mapping(target = "user", ignore = true) // user will be set in service
    Account toEntity(AccountRequestDto dto);
}
