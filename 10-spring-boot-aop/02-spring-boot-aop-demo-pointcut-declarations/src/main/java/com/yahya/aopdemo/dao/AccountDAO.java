package com.yahya.aopdemo.dao;

import com.yahya.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account);

    public String getName();

    public void setName(String name);

    public String getLevel();

    public void setLevel(String level);

    List<Account> findAccounts();

}
