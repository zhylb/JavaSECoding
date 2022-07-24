package com.lihd.dao.impl;

import com.lihd.dao.AccountDAO;
import com.lihd.pojo.Account;
import com.lihd.utils.SQLUtils;


import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/1 21:39
 */
public class AccountDAOImpl implements AccountDAO {

    private String path = "jdbc.properties";
    @Override
    public void create(Account account) {
        String sql = "INSERT INTO account ( `id`, `name`,`password`,`stuid`,`number`,`sex`,`birth`,`balance`) \n" +
                "\t\tVALUES ( NULL,?,?,?,?,?,?,?);";
        SQLUtils.update(path,sql,
                account.getName(),account.getPassword(),account.getStuid(),
                account.getNumber(),account.getSex(),account.getBirth(),account.getBalance());


    }

    @Override
    public boolean deleteById(long id) {
        String sql = "delete from account where id = ?";
        int re = SQLUtils.update(path,sql,id);
        return re!=0;//
    }

    @Override
    public double getBalanceById(long id) {
        String sql = "select * from account where id = ?";
        List<Account> accounts = SQLUtils.queryForAll(Account.class, sql, id);
        if(accounts.size()==1){
            return accounts.get(0).getBalance();
        }else {
            return -1;
        }
    }

    @Override
    public boolean getMoneyById(long id,double money) {

        double balance = getBalanceById(id);

        if(balance < money){
            return false;
        }

        String sql = "update account set balance = ? where id = ?";

        SQLUtils.update(path,sql,balance - money,id);

        return true;
    }

    @Override
    public boolean saveMoneyById(long id,double money) {

        double balance = getBalanceById(id);
        String sql = "update account set balance = ? where id = ?";
        int re = SQLUtils.update(path,sql,balance + money,id);
        return re==1;
    }

    @Override
    public boolean transferMoneyById(long f, long t,double money) {
        if(t == money) return true;//自我转账
        double balanceF = getBalanceById(f);
        double balanceT = getBalanceById(t);
        //f的余额不小于money 并且 t存在(balance一定不会小0)
        if(balanceF < money||balanceT<0) return false;

        String sql = "update account set balance = ? where id = ?";
        SQLUtils.update(path,sql,balanceF - money,f);
        SQLUtils.update(path,sql,balanceT + money,t);
        //转账成功
        return true;
    }

    @Override
    public boolean changeInfoById(long id, Account account) {
        String sql = "update account set  name = ? , password = ?," +
                "number = ?,sex = ?,birth = ? where id = ?";
        int re = SQLUtils.update(path,sql,account.getName(),account.getPassword(),
                account.getNumber(),account.getSex(),account.getBirth(),id);

        return re!=0;

    }



    @Override
    public List<Account> getAll() {
        String sql = "select * from account";
        return SQLUtils.queryForAll(Account.class, sql);
    }


    @Override
    public boolean logIn(long id,String password) {
        String sql = "select * from account where id = ? and password = ?";
        List<Account> accounts = SQLUtils.queryForAll(Account.class, sql, id, password);
        if(accounts == null) {
            System.out.println("结果是null");
            return false;
        }
        return accounts.size() != 0;
    }

    @Override
    public Account getAccountById(long id) {
        String sql = "select * from account where id = ?";
        List<Account> accounts = SQLUtils.queryForAll(Account.class, sql, id);
        if(accounts.size() !=0){
            return  accounts.get(0);
        }

        return null;
    }
}
