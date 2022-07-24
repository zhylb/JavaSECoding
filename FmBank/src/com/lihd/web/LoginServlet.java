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
 * @date ：2021/12/2 16:13
 */
public class LoginServlet extends HttpServlet {
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        long idl = Long.parseLong(id);
        boolean b = accountService.logIn(idl,password);
        if(b){
            Account accountById = accountService.getAccountById(idl);
            req.setAttribute("account",accountById);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }else {
            req.setAttribute("login","false");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }




    }
}
