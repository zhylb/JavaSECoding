package com.lihd.dao;

import com.lihd.pojo.Account;

import java.util.List;

public interface AccountDAO {
    // 1 创建账户

    /**
     *
     * id是自动生成的， 无论如何都可以创建成功
     *
     * @Author lihd
     * @Description //TODO LiHaoda
     * @Date 0:05 2021/12/2
     * @Param [account]
     * @return void
     **/
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
     * 我连我的性别都可以改， 但是我改不了我余额
     * @param id
     * @param account
     * @return
     */
    boolean changeInfoById(long id,Account account);

    // 8 查询所有信息
    List<Account> getAll();

    // 9 登录
    boolean logIn(long id,String password);

    // 10 根据id查找
    Account getAccountById(long id);
}
