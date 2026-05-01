package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.AccountRequestDto;
import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.entity.Account;
import com.example.learning.user_demo.entity.User;
import com.example.learning.user_demo.mapper.AccountMapper;
import com.example.learning.user_demo.repository.AccountRepository;
import com.example.learning.user_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;

    // Constructor Injection
    public AccountService(
            AccountRepository accountRepository,
            UserRepository userRepository,
            AccountMapper accountMapper
    ) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto) // Longform: account -> accountMapper.toDto(account)
                .toList();
    }

    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {

        User user = userRepository.findById(accountRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // RequestDto -> Entity (DB)
        Account account = accountMapper.toEntity(accountRequestDto);
        account.setUser(user); // Verknüpfung des Accounts zum User

        Account saveAccount = accountRepository.save(account); // save in DB

        return accountMapper.toDto(saveAccount); // MapStruct makes Entity -> ResponseDto, no manual code needed
    }
}
