package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.connectDB.ConnectDB;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.GrantAccess;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Role;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.repository.IRepository;
import jakarta.inject.Inject;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GrantAccessDao implements IRepository<GrantAccess> {
    @Inject
    private ConnectDB connectDB;
    @Override
    public boolean them(GrantAccess grantAccess) {
        return false;
    }

    @Override
    public boolean xoa(GrantAccess grantAccess) {
        return false;
    }

    @Override
    public boolean capNhat(GrantAccess grantAccess) {
        return false;
    }

    @Override
    public List<GrantAccess> layDs() {
        try {
            List<GrantAccess> grantAccesses = new ArrayList<>();
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet =  statement.executeQuery("select * from role");
            while (true){
                Account account = new AccountDao().layTheoMa(resultSet.getString(1)).get();
                Role role = new RoleDao().layTheoMa(resultSet.getString(2)).get();
                GrantAccess grantAccess = new GrantAccess( account,role,resultSet.getInt(3) == 1 ? true :false,resultSet.getString(4) == null ? "": resultSet.getString(4));
                return grantAccesses;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<GrantAccess> layTheoMa(Object... objects) throws Exception {
        return Optional.empty();
    }
}
