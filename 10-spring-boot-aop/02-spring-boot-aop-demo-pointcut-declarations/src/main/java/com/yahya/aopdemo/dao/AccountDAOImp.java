package com.yahya.aopdemo.dao;

import com.yahya.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImp implements AccountDAO{

    String name;
    String level;

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " is doing its  work");
    }

    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + " in getLevel()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + " in setLevel()");
        this.level = level;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account("ahmed" , "silver");
        Account account2 = new Account("omar" , "gold");
        Account account3 = new Account("mohamed" , "bronze");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }
}
