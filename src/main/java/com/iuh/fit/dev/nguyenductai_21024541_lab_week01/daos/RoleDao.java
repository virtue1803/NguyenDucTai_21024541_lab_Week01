package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.daos;

import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.connectDB.ConnectDB;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Role;
import com.iuh.fit.dev.nguyenductai_21024541_lab_week01.repository.IRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDao implements IRepository<Role> {
    private ConnectDB connectDB;

    public RoleDao() {
        connectDB =new ConnectDB();
    }

    @Override
    public boolean them(Role role) {
        return false;
    }

    @Override
    public boolean xoa(Role role) {
        return false;
    }

    @Override
    public boolean capNhat(Role role) {
        return false;
    }

    @Override
    public List<Role> layDs() {
        try {
            List<Role> list = new ArrayList<Role>();
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from role");
            while (resultSet.next()){
                Role role = new Role(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                list.add(role);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Role> layTheoMa(Object... objects) throws Exception {
       try {
           PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement("select * from role where role_id = ? ");
           preparedStatement.setString(1,objects.clone()[0].toString());
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               Role role = new Role(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
               return Optional.of(role);
           }else {
               throw new Exception("ko tìm thấy dữ liệu");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
           return Optional.empty();

    }
}
