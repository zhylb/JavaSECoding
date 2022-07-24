package com.lihd.web;

import com.lihd.pojo.Account;
import com.lihd.service.AccountService;
import com.lihd.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/29 22:52
 */
public class RegistServlet extends HttpServlet {
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println(111);
        String id = req.getParameter("id");
        String stuId = req.getParameter("stuId");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        String number = req.getParameter("number");
        String birth = req.getParameter("birth");

        Account a = new Account(name,password,Long.parseLong(stuId),Long.parseLong(number),sex,birth);


        accountService.create(a);
        req.getRequestDispatcher("index.jsp").forward(req,resp);


    }
}
