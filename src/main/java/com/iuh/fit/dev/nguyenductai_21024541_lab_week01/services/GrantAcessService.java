package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos.GrantAccessDao;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.GrantAccess;

import java.util.List;

public class GrantAcessService {
    private GrantAccessDao grantAccessDao;
    public GrantAcessService(){
        grantAccessDao = new GrantAccessDao();
    }
    public List<GrantAccess> layDanhSachGrantAccess(){
        return grantAccessDao.layDs();
    }
}
