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
<input id="user_role" type="hidden" name="userRole" value="${userRole}">

<form action="<%=request.getServletContext().getContextPath()%>/login" method="get">
    <input type="submit" value="Войти">

</form>
<form action="<%=request.getServletContext().getContextPath()%>/register" method="get">
    <input type="submit" value="Регистрация">
</form>
<div>
    <button onclick="goSearch()">Поиск пользователей</button>
</div>

<script type="text/javascript">
    var userRole = document.getElementById("user_role").value;

    function goSearch() {
        //alert(userRole);
        if (userRole === "ADMIN"){
            document.location.href="<%=request.getServletContext().getContextPath()%>/search";
        }else {
            alert("No rights");
        }
    }


</script>
</body>
</html>
