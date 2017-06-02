<%--
  Created by IntelliJ IDEA.
  User: java
  Date: 02.06.2017
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info</title>
</head>
<body>

<img src="/resources/1.jpg" alt="User avatar">

<input id="user-avatar" type="file">
<button onclick="uploadFile()">Upload</button>

<script type="text/javascript">

    function uploadFile() {

        var file = document.getElementById("user-avatar").files[0];

        fetch("http://localhost:8080/user/avatar",
                {
                    headers: new Headers({
                        "Content-Type": "multipart/form-data"
                    }),
                    method: "POST",
                    body: file
                }
        )
                .then(function (response) {
                    return response.json();
                })
                .catch(alert);
    }
</script>

</body>
</html>
