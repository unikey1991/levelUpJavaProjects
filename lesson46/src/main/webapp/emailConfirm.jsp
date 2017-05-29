<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 29.05.2017
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email confirm</title>
</head>
<body>
<input id="user_id" type="hidden" name="userId" value="${userId}">
<span>Name:${name}</span><br>
<span>Last name:${lastName}</span>
<span>Вы не подтвердили свой email. Выслать повторно письмо подтверждения?
<button id="btn_send" onclick="sendEmail()">Отправить</button></span>

<script type="text/javascript">

    function sendEmail() {
        var userId = document.getElementById("user_id").value;
        var request = "userId=" + userId;
        fetch('/sendEmail',{
            method: 'POST',
            headers: {
                'Accept': 'application/json, application/xml, text/plain, text/html, *.*',
                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: request
        }).catch(alert);
        var btn = document.getElementById("btn_send");

        alert("Отправлено")
    }


</script>
</body>
</html>
