package com.lihd.pojo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/1 18:35
 */
public class Account {


    //银行内用户Id：10位数字组成
    private long id;
    //用户名：填姓名（10个汉字长度）
    private String name;
    //密码：不少于4位
    private String password;
    //身份ID：填学号（12位数字）
    private long stuid;
    //手机号：正常手机号
    private long number;
    //性别：用一位字符（M:男，F:女）
    private String  sex;
    //出生日期：YYYY-MM-DD
    private Date birth;
    //账户余额：双精度范围即可
    private double balance = 2000;//默认初始化为 2000

    public Account() {
    }

    public Account(String name, String password, long stuid, long number, String sex, Date birth) {
        this.name = name;
        this.password = password;
        this.stuid = stuid;
        this.number = number;
        this.sex = sex;
        this.birth = birth;

    }

    public Account(String name, String password, long number, String sex, String  birth) {
        this.name = name;
        this.password = password;
        this.number = number;
        this.sex = sex;
        this.birth = Date.valueOf(birth);

    }

    public Account(String name, String password, long stuid, long number, String sex, String birth) {
        this.name = name;
        this.password = password;
        this.stuid = stuid;
        this.number = number;
        this.sex = sex;
        SimpleDateFormat sdf = new SimpleDateFormat();
        this.birth = Date.valueOf(birth);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getStuid() {
        return stuid;
    }

    public void setStuid(long stuid) {
        this.stuid = stuid;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", stuid=" + stuid +
                ", number=" + number +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", balance=" + balance +
                '}';
    }
}
