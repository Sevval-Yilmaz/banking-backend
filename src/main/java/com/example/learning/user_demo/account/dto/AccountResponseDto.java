package com.example.learning.user_demo.account.dto;

import java.math.BigDecimal;

public class AccountResponseDto {

    private Long id;
    private String iban;
    private BigDecimal balance;
    private String accountType;
    private Long userId;
    private String userName;

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
