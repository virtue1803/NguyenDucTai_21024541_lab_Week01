<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account" %>
<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.services.AccountService" %><%--
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
               <td>Account ID</td>
                <td>Ho và Tên </td>
                <td>Mật khẩu</td>
                <td>Số điện Thoại</td>
                <td>Status</td>

            </tr>
        <tbody>

    </tbody>
        </thead>
    </table>
</div>

<div>
    <h1>Quản lý role</h1>
    <table>
        <thead>
        <tr>
            <td>Role ID</td>
            <td>Role Name </td>
            <td>Mô tả</td>
            <td>Status</td>

        </tr>
        <tbody>

        </tbody>
        </thead>
    </table>
</div>

<div>
    <h1>Phân quyền tài khoản</h1>
    <table>
        <thead>
        <tr>
            <td>Account ID</td>
            <td>Role ID </td>
            <td>Is Grant</td>
            <td>ghi chú</td>

        </tr>
        <tbody>

        </tbody>
        </thead>
    </table>
</div>
</body>
</html>
