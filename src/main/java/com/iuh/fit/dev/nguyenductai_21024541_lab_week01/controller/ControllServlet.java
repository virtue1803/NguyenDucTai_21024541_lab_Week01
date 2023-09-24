package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.controller;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos.AccountDao;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ControlServlet", value ="/control-servlet" )
public class ControllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getAction  = req.getServletContext().getAttribute("action").toString();
        if(getAction.equalsIgnoreCase("login")) {
            AccountDao accountDao = new AccountDao();
            try {
                Optional<Account> optional = accountDao.layTheoMa((req.getParameter("accountID")),req.getParameter("password"));
                Account account = optional.get();
                if(account == null){
                    resp.getWriter().println("rỗng");
                } else {
                    req.getServletContext().setAttribute("AccountData", account);
                    req.getServletContext().getRequestDispatcher("/user-infor.jsp").forward(req,resp);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
}
