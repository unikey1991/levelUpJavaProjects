<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 18.05.2017
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript"--%>
        <%--src="${request.contextPath}/js/userTable.js">--%>
<%--</script>--%>

<html>
<head>
    <title>Search</title>
</head>
<body>
<%--<form action="search" method="post">--%>
    <%--<span>Логин:</span><input name="login" type="text">--%>
    <%--<span>Телефон:</span><input name="phone" type="text">--%>
    <%--<input type="submit" value="Найти">--%>
<%--</form>--%>

<div>
    <input type="text" id="user-login"/><span>
    <input type="text" id="user-phone"/><span>
    <button onclick="search()">Search</button></span></span>
</div>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Login</td>
        <td>Email</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Age</td>
        <td>Address</td>
    </tr>
    </thead>
    <tbody id="user-table">
    </tbody>
</table>

<script src="${pageContext.servletContext.contextPath}/js/userTable.js"></script>

<%--<script type="text/javascript"--%>
        <%--src="${pageContext.servletContext.contextPath}/js/userTable.js">--%>
<%--</script>--%>

<%--<table>--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<td>Login</td>--%>
        <%--<td>Name</td>--%>
        <%--<td>Last Name</td>--%>
        <%--<td>Phone</td>--%>
        <%--<td>Email</td>--%>
    <%--</tr>--%>
    <%--</thead>--%>

    <%--<tbody>--%>
    <%--<c:forEach var="sr" items="${searchResultList}">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<c:out value="${sr.login}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<c:out value="${sr.name}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<c:out value="${sr.lastName}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<c:out value="${sr.phone}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<c:out value="${sr.email}"/>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form action="search" method="post">--%>

                    <%--<input type="submit" value="Удалить">--%>
                    <%--<input type="hidden" name="deleteId" value="${sr.id}">--%>

                <%--</form>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form action="search" method="post">--%>
                    <%--<input type="submit" value="Изменить">--%>
                    <%--<input type="hidden" name="updateId" value="${sr.id}">--%>

                <%--</form>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>
</body>
</html>
