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

    public AccountResponseDto createAccount(AccountRequestDto requestDto) {

        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = Account.open(
                requestDto.getIban(),
                requestDto.getAccountType()
        );
        user.addAccount(account); // sync account and user

        Account saved = accountRepository.save(account); // save in DB

        AccountResponseDto dto = new AccountResponseDto();
        dto.setId(saved.getId());
        dto.setIban(saved.getIban());
        dto.setBalance(saved.getBalance());
        dto.setAccountType(saved.getAccountType().name());

        dto.setUserId(user.getId());
        dto.setUserName(user.getName());

        return dto;
    }
}
