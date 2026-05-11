package com.example.learning.user_demo.user;

import com.example.learning.user_demo.account.Account;
import com.example.learning.user_demo.account.AccountType;
import com.example.learning.user_demo.shared.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User extends BaseEntity {

    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public Account openAccount(String iban, AccountType type) {
        Account account = Account.open(iban, type, this);
        accounts.add(account);
        return account;
    }

    public void changeName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void changeEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }
}
