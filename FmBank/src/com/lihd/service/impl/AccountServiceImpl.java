package com.lihd.service.impl;

import com.lihd.dao.AccountDAO;
import com.lihd.dao.impl.AccountDAOImpl;
import com.lihd.pojo.Account;
import com.lihd.service.AccountService;

import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/2 8:38
 */
public class AccountServiceImpl implements AccountService {
    // DAO层的对象
    private final AccountDAO accountDAO = new AccountDAOImpl();
    @Override
    public void create(Account account) {
        accountDAO.create(account);
    }

    @Override
    public boolean deleteById(long id) {
        return accountDAO.deleteById(id);
    }

    @Override
    public double getBalanceById(long id) {
        return accountDAO.getBalanceById(id);
    }

    @Override
    public boolean getMoneyById(long id, double money) {
        return accountDAO.getMoneyById(id,money);
    }

    @Override
    public boolean saveMoneyById(long id, double money) {
        return accountDAO.saveMoneyById(id,money);
    }

    @Override
    public boolean transferMoneyById(long f, long t, double money) {
        return accountDAO.transferMoneyById(f, t, money);
    }

    @Override
    public boolean changeInfoById(long id, Account account) {
        return accountDAO.changeInfoById(id, account);
    }

    @Override
    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    @Override
    public boolean logIn(long id, String password) {
        return accountDAO.logIn(id, password);
    }

    @Override
    public Account getAccountById(long id) {
        return accountDAO.getAccountById(id);
    }
}
