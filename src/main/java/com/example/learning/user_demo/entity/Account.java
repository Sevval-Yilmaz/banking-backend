package com.example.learning.user_demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class Account extends BaseEntity {

    @Column(nullable = false, unique = true, updatable = false)
    private String iban;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {}

    public Account(String iban, AccountType accountType) {
        this.iban = iban;
        this.balance = BigDecimal.ZERO;
        this.accountType = accountType;
    }

    public static Account open(String iban, AccountType type) {
        return new Account(iban, type);
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        validateAmount(amount);

        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balance = this.balance.subtract(amount);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }
    }

    void setUser(User user) {
        this.user = user;
    }

    // Getters
    public String getIban() {
        return iban;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public AccountType getAccountType() {
        return accountType;
    }
}
