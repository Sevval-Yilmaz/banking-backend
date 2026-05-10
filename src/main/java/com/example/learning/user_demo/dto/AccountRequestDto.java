package com.example.learning.user_demo.dto;

import com.example.learning.user_demo.entity.AccountType;

import java.math.BigDecimal;

public class AccountRequestDto {

    private Long userId;
    private String iban;
    private BigDecimal balance;
    private AccountType accountType;

    public Long getUserId() {
        return userId;
    }

    public String getIban() {
        return iban;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
