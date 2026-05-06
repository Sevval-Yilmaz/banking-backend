package com.example.learning.user_demo.service;

import com.example.learning.user_demo.dto.TransactionRequestDto;
import com.example.learning.user_demo.entity.Account;
import com.example.learning.user_demo.entity.Transaction;
import com.example.learning.user_demo.repository.AccountRepository;
import com.example.learning.user_demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository
    ) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void transfer(TransactionRequestDto dto) {

        if (dto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }

        if (dto.getFromAccountId().equals(dto.getToAccountId())) {
            throw new RuntimeException("Cannot transfer to same account!");
        }

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

        Transaction transaction = new Transaction();
        transaction.setAmount(dto.getAmount());
        transaction.setFromAccountId(dto.getFromAccountId());
        transaction.setToAccountId(dto.getToAccountId());

        transactionRepository.save(transaction);
    }

}
