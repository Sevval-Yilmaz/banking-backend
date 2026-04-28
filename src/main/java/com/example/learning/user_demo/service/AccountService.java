package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.AccountRequestDto;
import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.entity.Account;
import com.example.learning.user_demo.entity.User;
import com.example.learning.user_demo.repository.AccountRepository;
import com.example.learning.user_demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    // Constructor Injection
    public AccountService(
            AccountRepository accountRepository,
            UserRepository userRepository
    ) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(account -> {
                    AccountResponseDto dto = new AccountResponseDto();
                    dto.setId(account.getId());
                    dto.setIban(account.getIban());
                    dto.setAccountType(account.getAccountType());

                    dto.setUserId(account.getUser().getId());
                    dto.setUserName(account.getUser().getName());
                    return dto;
                })
                .toList();
    }

    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {

        User user = userRepository.findById(accountRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        // für die Datenbank (Entity)
        account.setIban(accountRequestDto.getIban());
        account.setBalance(accountRequestDto.getBalance());
        account.setAccountType(accountRequestDto.getAccountType());
        account.setUser(user); // Verknüpfung des Accounts zum User

        // in Datenbank speichern
        Account saveAccount = accountRepository.save(account);

        // API Response
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setId(saveAccount.getId());
        responseDto.setIban(saveAccount.getIban());
        responseDto.setBalance(saveAccount.getBalance());
        responseDto.setAccountType(saveAccount.getAccountType());

        responseDto.setUserId(user.getId());
        responseDto.setUserName(user.getName());

        return responseDto;
    }
}
