package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos.RoleDao;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Role;

import java.util.List;

public class RoleService {
    private RoleDao roleDao;
    public RoleService(){
        roleDao = new RoleDao();
    }
    public List<Role> layDanhSachRole(){
        return roleDao.layDs();
    }
}
