package com.lihd.web;

import com.lihd.pojo.Account;
import com.lihd.service.AccountService;
import com.lihd.service.impl.AccountServiceImpl;
import com.lihd.utils.OtherUtils;
import com.lihd.utils.SQLUtils.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2021/12/4 14:49
 */
public class ChangeInfoServlet extends HttpServlet {
    private final AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");


        resp.setContentType("text/html;charset=utf-8");

        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String sex = req.getParameter("sex");
        String password = req.getParameter("password");
        String number = req.getParameter("number");
        String birth = req.getParameter("birth");
        String admin = req.getParameter("admin");

        String save = req.getParameter("save");
        String pay = req.getParameter("pay");
        String payId = req.getParameter("pay_id");
        String payMoney = req.getParameter("pay_money");

        Account account = new Account(name,password,Long.parseLong(number),sex,birth);



        long lid = Long.parseLong(id);
        accountService.changeInfoById(lid,account);
        if(admin.equals("false")){
            System.out.println(lid);
            System.out.println(OtherUtils.getDouble(save));

            accountService.saveMoneyById(lid, OtherUtils.getDouble(save));
            accountService.getMoneyById(lid,OtherUtils.getDouble(pay));
            if(!payId.equals("0")){
                accountService.transferMoneyById(lid,Long.parseLong(payId),OtherUtils.getDouble(payMoney));
            }
        }






        Account accountById = accountService.getAccountById(lid);
        req.setAttribute("account",accountById);
        System.out.println(admin);
        if(admin.equals("true")){
            req.getRequestDispatcher("pages/manager/manager.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }




    }
}
