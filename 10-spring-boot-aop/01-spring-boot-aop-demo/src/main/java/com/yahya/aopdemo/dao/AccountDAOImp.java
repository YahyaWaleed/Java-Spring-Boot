package com.yahya.aopdemo.dao;

import com.yahya.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImp implements AccountDAO{
    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + " is doing its  work");
    }
}
