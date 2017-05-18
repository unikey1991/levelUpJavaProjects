<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 13.05.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register" method="post">
    <span>Login:</span><input name="login" type="text">
    <span>Password:</span><input name="password" type="password">
    <span>Name:</span><input name="name" type="text">
    <span>Last name:</span><input name="lastName" type="text">
    <span>Phone:</span><input name="phone" type="number">
    <span>Email:</span><input name="lastName" type="email">
    <input type="submit" value="post">
</form>

</body>
</html>
