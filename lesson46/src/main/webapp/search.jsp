<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 18.05.2017
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="search" method="post">
    <span>Логин:</span><input name="login" type="text">
    <span>Телефон:</span><input name="phone" type="text">
    <input type="submit" value="Найти">
</form>
<table>
    <thead>
    <tr>
        <td>Login</td>
        <td>Name</td>
        <td>Last Name</td>
        <td>Phone</td>
        <td>Email</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="sr" items="${searchResultList}">
        <tr>
            <td>
                <c:out value="${sr.login}"/>
            </td>
            <td>
                <c:out value="${sr.name}"/>
            </td>
            <td>
                <c:out value="${sr.lastName}"/>
            </td>
            <td>
                <c:out value="${sr.phone}"/>
            </td>
            <td>
                <c:out value="${sr.email}"/>
            </td>
            <td>
                <form action="search" method="post">

                    <input type="submit" value="Удалить">
                    <input type="hidden" name="deleteId" value="${sr.id}">

                </form>
            </td>
            <td>
                <form action="search" method="post">
                    <input type="submit" value="Изменить">
                    <input type="hidden" name="updateId" value="${sr.id}">

                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
