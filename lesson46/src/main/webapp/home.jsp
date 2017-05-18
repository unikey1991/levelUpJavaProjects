<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 13.05.2017
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="<%=request.getServletContext().getContextPath()%>/login" method="get">
    <input type="submit" value="Войти">
</form>
<form action="<%=request.getServletContext().getContextPath()%>/register" method="get">
    <input type="submit" value="Регистрация">
</form>
<form action="<%=request.getServletContext().getContextPath()%>/search.jsp" method="get">
    <input type="submit" value="Поиск пользователей">
</form>
</body>
</html>
