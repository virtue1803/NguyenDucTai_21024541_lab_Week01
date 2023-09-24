<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Đăng nhập tài khoản</h1>
<form action="control-servlet" method="post">
    Tên tài khoản:  <input type="text" name="accountID" placeholder="userName" >
    Mật khẩu: <input type="password" name="password" placeholder="password">
    <input type="submit" name="action" value="login"><br>

    <p style="font-size: 15px; color: red"> <%= request.getServletContext().getAttribute("loginStatus") != null ?  "đăng nhập ko thành công" : ""%>

    <%
        request.getServletContext().setAttribute("action","login");
    %>
</form>


</body>
</html>