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
    <span>Логин:</span><input name="login" type="text">
    <span>Пароль:</span><input name="password" type="password">
    <span>Имя:</span><input name="name" type="text">
    <span>Фамилия:</span><input name="lastName" type="text">
    <span>Телефон в формате 380...:</span><input type="tel" name="phone" pattern="38[0-9]{10}">
    <span>Email:</span><input name="email" type="email">
    <input type="submit" value="Зарегистрироваться">
</form>

</body>
</html>
