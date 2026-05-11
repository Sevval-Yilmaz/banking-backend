package com.example.learning.user_demo.transaction;

import com.example.learning.user_demo.transaction.dto.TransactionRequestDto;
import com.example.learning.user_demo.account.Account;
import com.example.learning.user_demo.account.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if (dto.getFromAccountId().equals(dto.getToAccountId())) {
            throw new RuntimeException("Cannot transfer to same account!");
        }

        Account fromUser = accountRepository.findById(dto.getFromAccountId())
                .orElseThrow(() -> new RuntimeException("From User not found!"));

        Account toUser = accountRepository.findById(dto.getToAccountId())
                .orElseThrow(() -> new RuntimeException("To User not found!"));

        fromUser.withdraw(dto.getAmount());
        toUser.deposit(dto.getAmount());

        accountRepository.save(fromUser);
        accountRepository.save(toUser);

        Transaction transaction = new Transaction(
                dto.getAmount(),
                fromUser,
                toUser
        );

        transactionRepository.save(transaction);
    }

}
