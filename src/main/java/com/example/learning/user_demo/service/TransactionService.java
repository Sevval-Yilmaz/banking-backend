package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.TransactionRequestDto;
import com.example.learning.user_demo.entity.Account;
import com.example.learning.user_demo.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(TransactionRequestDto dto) {

        Account fromUser = accountRepository.findById(dto.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("From User not found!"));

        Account toUser = accountRepository.findById(dto.getToAccountId())
                .orElseThrow(() -> new RuntimeException("To User not found!"));

        if (fromUser.getBalance().compareTo(dto.getAmount()) < 0) {
            throw new RuntimeException("Not enough money!");
        }

        fromUser.setBalance(fromUser.getBalance().subtract(dto.getAmount()));
        toUser.setBalance(toUser.getBalance().add(dto.getAmount()));

        accountRepository.save(fromUser);
        accountRepository.save(toUser);
    }

}
