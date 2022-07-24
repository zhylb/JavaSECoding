package com.lihd.test;

import com.lihd.dao.AccountDAO;
import com.lihd.dao.impl.AccountDAOImpl;
import com.lihd.pojo.Account;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountDAOImplTest {

    AccountDAO accountDAO = new AccountDAOImpl();

    @Test
    public void create() {
        Account account = new Account("钟离","zl123",320190941821L,1507777888L,"M","2000-12-15");
        System.out.println(account);
        accountDAO.create(account);
        getAll();
    }

    @Test
    public void deleteById() {
        getAll();
        System.out.println("---------------------------");
        accountDAO.deleteById(1000000007L);
        getAll();
    }

    @Test
    public void getBalanceById() {
        double balanceById = accountDAO.getBalanceById(1100000001);
        System.out.println(balanceById);
    }

    @Test
    public void getMoneyById() {
        accountDAO.getMoneyById(1000000001,500);
        getAll();
    }

    @Test
    public void saveMoneyById() {
        accountDAO.saveMoneyById(1000000001,5000);
        getAll();
    }

    @Test
    public void transferMoneyById() {
        accountDAO.transferMoneyById(1000000001,1000000002,5000);
        getAll();
    }

    @Test
    public void changeInfoById() {
        getAll();
        Account account = new Account("钟离","zl123",320190941821L,1507777888L,"M","2000-12-15");
        System.out.println("---------");
        accountDAO.changeInfoById(1000000001,account);
        getAll();
    }

    @Test
    public void getAll() {
        "".getBytes();

        List<Account> all = accountDAO.getAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }


    @Test
    public void logIn(){
        getAll();

        boolean re = accountDAO.logIn(1000000001L,"zl1234");
        System.out.println(re);
    }
}