package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.connectDB.ConnectDB;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.repository.IRepository;
import jakarta.enterprise.context.Initialized;
import jakarta.inject.Inject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountDao implements IRepository<Account> {

    private ConnectDB connectDB;
    public AccountDao(){
        connectDB = new ConnectDB();
    }
    @Override
    public boolean them(Account account) {
        return false;
    }

    @Override
    public boolean xoa(Account account) {
        return false;
    }

    @Override
    public boolean capNhat(Account account) {
        return false;
    }

    @Override
    public List<Account> layDs() {
        return null;
    }

    @Override
    public Optional<Account> layTheoMa(Object... objects) throws Exception {
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement("select * from account where  account_id = ? and password = ?");
            String userName  = objects[0].toString();
            String password  = objects[1].toString();
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Account account = new Account(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
                return Optional.of(account);
            } else {
                throw  new Exception("không tìm thấy đữ liệu");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }
}
