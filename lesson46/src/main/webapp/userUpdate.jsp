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

<form action="updateUser" method="post">
    <input type="hidden" name="userId" value="${userId}">
<span>Имя:</span><input name="name" type="text" value="${name}"><br/>
<span>Фамилия:</span><input name="lastName" type="text" value="${lastName}"><br/>
<span>Телефон в формате 38...:</span><input name="phone" type="tel" pattern="38[0-9]{10}" value="${phone}"><br/>
<span>Email:</span><input name="email" type="email" value="${email}"><br/>
<input type="submit" value="Применить">
    <input type="hidden" name="update" value="1">
</form>
<script></script>

</body>
</html>
