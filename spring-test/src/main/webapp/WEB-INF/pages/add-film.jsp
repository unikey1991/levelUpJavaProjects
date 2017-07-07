<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 06.07.2017
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="save" method="post">
    <span>filmName:</span><input name="filmName" type="text">
    <span>filmDescription:</span><input name="filmDescription" type="text">
    <input type="submit" value="add">
    <button onclick="history.back()">Cancel</button>
</form>

</body>
</html>
