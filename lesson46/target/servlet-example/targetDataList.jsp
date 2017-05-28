<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 16.05.2017
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Target Data List</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <td>Email</td>
        <td>User Name</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="td" items="${targetDataList}">
        <tr>
            <td>
                <c:out value="${td.email}"/>
            </td>
            <td>
                <c:out value="${td.userName}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
