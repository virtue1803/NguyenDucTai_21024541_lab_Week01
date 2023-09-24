<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services.AccountService" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services.GrantAcessService" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services.RoleService" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Role" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.GrantAccess" %><%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 9/24/2023
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DashBroad</title>
    <style>
        div{
            width: 100%;
        }
        div > table{
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<%
    AccountService service  = new AccountService();
    Account account = service.layAccount(request.getParameter("accountID"),request.getParameter("password"));
    GrantAcessService grantAcessService = new GrantAcessService();
    RoleService roleService = new RoleService();
    String accDataShow = "";
    for (Account account1 : service.layDanhSachAccount()){
        accDataShow += "<tr>" +
                "<td>" + account1.getAccountID() + "</td>" +
                "<td>" + account1.getFullname() + "</td>" +
                "<td>" + account1.getPassword() + "</td>" +
                "<td>" + account1.getPhone() +  "</td>" +
                "<td>" + account1.getStatus() +"</td>" +
                "<t/tr>";
    }

    String RoleDataShow = "";
    for (Role role : roleService.layDanhSachRole()){
        RoleDataShow += "<tr>" +
                "<td>" + role.getRoleID() + "</td>" +
                "<td>" + role.getRoleName() + "</td>" +
                "<td>" + role.getDescription() + "</td>" +
                "<td>" + role.getStatus() +  "</td>" +
                "<t/tr>";
    }

    String GRDataShow = "";
    for (GrantAccess grantAccess : grantAcessService.layDanhSachGrantAccess()){
        GRDataShow += "<tr>" +
                "<td>" + grantAccess.getAccountID() + "</td>" +
                "<td>" + grantAccess.getRoleID() + "</td>" +
                "<td>" + grantAccess.isGrant() + "</td>" +
                "<td>" + grantAccess.getNote() +  "</td>" +
                "<t/tr>";
    }

%>
<body>
<div> <h1> Thông tin cá nhân</h1>
    <p>        Account ID: <%= account.getAccountID()%> <br>
    Tên đầy đủ Name: <%= account.getFullname() %> <br>
    Mật khẩu Password: <%= account.getPassword()%> <br>
    Email: <%= account.getEmail()%> <br>
    Điện thoại Phone: <%= account.getPhone()%> <br>
    Status: <%= account.getStatus()%> <br>
</p>
</div>

<div>
    <h1>Quản lý tài khoản</h1>
    <table>
        <thead>
            <tr>
               <th>Account ID</th>
                <th>Ho và Tên </th>
                <th>Mật khẩu</th>
                <th>Số điện Thoại</th>
                <th>Status</th>

            </tr>
        <tbody>
        <%=accDataShow %>
    </tbody>
        </thead>
    </table>
</div>

<div>
    <h1>Quản lý role</h1>
    <table>
        <thead>
        <tr>
            <th>Role ID</th>
            <th>Role Name </th>
            <th>Mô tả</th>
            <th>Status</th>

        </tr>
        <tbody>
    <%=RoleDataShow %>
        </tbody>
        </thead>
    </table>
</div>

<div>
    <h1>Phân quyền tài khoản</h1>
    <table>
        <thead>
        <tr>
            <th>Account ID</th>
            <th>Role ID </th>
            <th>Is Grant</th>
            <th>ghi chú</th>

        </tr>
        <tbody>
    <%=GRDataShow %>
        </tbody>
        </thead>
    </table>
</div>
</body>
</html>
