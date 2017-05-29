<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 12.05.2017
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>

<span>Name:${name}</span><br>
<span>Last name:${lastName}</span>

<script language = 'javascript'>
    var delay = 5000;
    setTimeout("document.location.href='/'", delay);
</script>
<p>Логин успешный. Через 5 секунд Вы будете перенаправлены на домашнюю страницу.
</p>

</body>
</html>
