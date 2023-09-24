package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.controller;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos.AccountDao;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet(name = "ControlServlet", value ="/control-servlet" )
public class ControllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getAction  = req.getServletContext().getAttribute("action").toString();
        if(getAction.equalsIgnoreCase("login")) {
            AccountDao accountDao = new AccountDao();
            Optional<Account> optional = accountDao.layTheoMa(req.getParameter("accountID"),req.getParameter("password"));
            Account account = null;
            try {
                account = optional.get();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            if (account == null){
                req.getServletContext().setAttribute("loginStatus","false");
                req.getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
            }else {
                req.getServletContext().setAttribute("loginStatus",null);
                req.getServletContext().setAttribute("AccountData",optional.get());
                req.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req,resp);
            }
        }
    }
}
