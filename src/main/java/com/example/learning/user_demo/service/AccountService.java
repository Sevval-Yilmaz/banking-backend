package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.AccountRequestDto;
import com.example.learning.user_demo.dto.AccountResponseDto;
import com.example.learning.user_demo.entity.Account;
import com.example.learning.user_demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    // Constructor Injection
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        // für die Datenbank (Entity)
        account.setIban(accountRequestDto.getIban());
        account.setBalance(accountRequestDto.getBalance());
        account.setAccountType(accountRequestDto.getAccountType());

        // in Datenbank speichern
        Account saveAccount = accountRepository.save(account);

        // API Response
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setId(saveAccount.getId());
        responseDto.setIban(saveAccount.getIban());
        responseDto.setBalance(saveAccount.getBalance());
        responseDto.setAccountType(saveAccount.getAccountType());
        return responseDto;
    }
}
