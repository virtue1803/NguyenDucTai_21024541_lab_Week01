package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos.AccountDao;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;

public class AccountService {
    private AccountDao accountDao;
    public  AccountService(){
        accountDao = new AccountDao();
    }
    public Account layAccount (String userName, String password) throws Exception {
         return accountDao.layTheoMa(userName,password).get();
    }
}
