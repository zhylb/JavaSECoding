package com.lihd.test;

import com.lihd.pojo.Account;
import com.lihd.service.AccountService;
import com.lihd.service.impl.AccountServiceImpl;
import com.lihd.utils.ExcelUtil;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/29 20:22
 */
public class A {
    public static void main(String... args)throws Exception {
        AccountService as = new AccountServiceImpl();
        List<Account> all = as.getAll();
        LinkedHashMap<String,String > filedMap = new LinkedHashMap<>();
        filedMap.put("id","id");
        filedMap.put("name","name");
        filedMap.put("password","password");
        filedMap.put("stuid","stuid");
        filedMap.put("number","number");
        filedMap.put("sex","sex");
        filedMap.put("birth","birth");
        filedMap.put("balance","balance");
        OutputStream os = new BufferedOutputStream(new FileOutputStream("D://hello.xls"));
        ExcelUtil.listToExcel(all,filedMap,"account",os);
    }
}
