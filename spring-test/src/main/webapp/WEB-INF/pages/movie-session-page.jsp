<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 04.07.2017
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>

<h1>Movie list:</h1>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>date</td>
        <td>cinemaRoom</td>
        <td>standartPrice</td>
        <td>comfortPrice</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="ms" items="${allMovieSessions}">
        <tr>
            <td>
                <c:out value="${ms.id}"/>
            </td>
            <td>
                <c:out value="${ms.date}"/>
            </td><td>
                <c:out value="${ms.cinemaRoom}"/>
            </td><td>
                <c:out value="${ms.standartPrice}"/>
            </td><td>
                <c:out value="${ms.comfortPrice}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
