package com.lihd.service;

import com.lihd.pojo.Account;

import java.util.List;

public interface AccountService{

    //service 封装 DAO 层


    void create(Account account);

    // 2 删除账户


    boolean deleteById(long id);

    // 3 显示余额
    double getBalanceById(long id);

    // 4 取钱
    boolean getMoneyById(long id,double money);

    // 5 存钱
    boolean saveMoneyById(long id,double money);

    // 6 转账
    boolean transferMoneyById(long f,long t,double money);

    /**
     * 我连我的性别都可以改， 可以我改不了我余额
     * @param id
     * @param account
     * @return
     */
    boolean changeInfoById(long id,Account account);

    // 8 查询所有信息
    List<Account> getAll();

    // 9 登录
    boolean logIn(long id,String password);

    Account getAccountById(long id);
}
