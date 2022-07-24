package com.lihd.web;

import com.lihd.pojo.Account;
import com.lihd.service.AccountService;
import com.lihd.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/2 20:22
 */
public class GetAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountServiceImpl();
        List<Account> all = accountService.getAll();

        req.setAttribute("all",all);
        req.getRequestDispatcher("pages/oneInfo.jsp").forward(req,resp);
    }
}
