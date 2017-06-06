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

<img src="/resources/user-avatar" alt="">

<input id="user-avatar" type="file">
<button>Upload</button>

<script>

    function uploadFile() {

        var file = document.getElementById("user-avatar");

        fetch("http://localhost:8080/user/avatar",
                {
                    headers: new Headers({
                        "Content-Type": "multipart/form-data"
                    }),
                    method: "POST",
                    body: file
                }).then(response -> response.json())
                .thead(function (response) {
                    console.log(response)
                }).catch(error -> console.error(error))

    }
</script>

</body>
</html>
