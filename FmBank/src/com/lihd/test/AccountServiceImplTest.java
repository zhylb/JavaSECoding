package com.lihd.test;

import com.lihd.pojo.Account;
import com.lihd.service.AccountService;
import com.lihd.service.impl.AccountServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceImplTest {
    AccountService accountService = new AccountServiceImpl();

    @Test
    public void create() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void getBalanceById() {
    }

    @Test
    public void getMoneyById() {
    }

    @Test
    public void saveMoneyById() {
    }

    @Test
    public void transferMoneyById() {
        accountService.transferMoneyById(1000000001L,1000000002L,1000);
    }

    @Test
    public void changeInfoById() {
    }

    @Test
    public void getAll() {
        List<Account> all = accountService.getAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }

    @Test
    public void logIn() {
        boolean b = accountService.logIn(1L, "");
        System.out.println(b);
    }
}