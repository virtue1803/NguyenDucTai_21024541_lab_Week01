<%@ page import="com.iuh.fit.dev.nguyenductai_21024541_lab_week01.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 9/24/2023
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Thông tin cá nhân</title>
</head>
<%
    Account account = (Account) request.getServletContext().getAttribute("AccountData");
%>
<body>
<h1>Thông tin cá nhân</h1>
<p>        Account ID: <%= account.getAccountID()%> <br>
      Tên đầy đủ Name: <%= account.getFullname() %> <br>
    Mật khẩu Password: <%= account.getPassword()%> <br>
                Email: <%= account.getEmail()%> <br>
     Điện thoại Phone: <%= account.getPhone()%> <br>
    Status: <%= account.getStatus()%> <br>
</p>
</body>
</html>
