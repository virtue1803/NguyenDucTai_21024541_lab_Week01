package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.connectDB.ConnectDB;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Role;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.repository.IRepository;
import jakarta.enterprise.context.Initialized;
import jakarta.inject.Inject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDao implements IRepository<Account> {
    @Inject
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
        try {
            List<Account> list = new ArrayList<Account>();
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from account");
            while (resultSet.next()){
                Account account = new Account(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
                list.add(account);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Optional<Account> layTheoMa(Object... objects) {

        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement("select * from account where account_id = ? ");
            preparedStatement.setString(1, objects.clone()[0].toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
                return Optional.of(account);
            } else {
                throw new Exception("ko tìm thấy dữ liệu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    public Optional<Account> kiemTraDangNhap(String userName, String password){
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement("select * from account where  account_id = ? and password = ?");
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
