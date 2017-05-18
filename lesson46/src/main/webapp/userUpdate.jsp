<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 18.05.2017
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>

<form action="search" method="post">
    <input type="hidden" name="userId" value="${userId}">
<span>Логин:</span><input name="login" type="text" value="${login}">
<span>Имя:</span><input name="name" type="text" value="${name}">
<span>Фамилия:</span><input name="lastName" type="text" value="${lastName}">
<span>Телефон в формате 38...:</span><input name="phone" type="tel" pattern="38[0-9]{10}" value="${phone}">
<span>Email:</span><input name="email" type="email" value="${email}">
<input type="submit" value="Применить">
    <input type="hidden" name="update" value="1">
</form>

</body>
</html>
