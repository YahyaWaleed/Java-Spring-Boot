package com.yahya.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImp implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + " is doing its  work");
    }

    @Override
    public String  addMember() {
        return (  "this class is adding members");
    }
}
