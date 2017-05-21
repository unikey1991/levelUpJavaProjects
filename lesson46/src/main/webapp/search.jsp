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
        <td>Name</td>
        <td>Last Name</td>
        <td>Phone</td>
        <td>Email</td>
    </tr>
    </thead>
    <tbody id="user-table">
    </tbody>
</table>


<script type="text/javascript">/**
 * Created by unike on 21.05.2017.
 */
function fillTable(userList) {
    var userTable = document.getElementById("user-table");

    clearTable(userTable);

    userList.forEach(function (user) {
        var row = userTable.insertRow();

        var id = row.insertCell(0);
        var login = row.insertCell(1);
        var name = row.insertCell(2);
        var lastName = row.insertCell(3);
        var phone = row.insertCell(4);
        var email = row.insertCell(5);

        id.innerHTML = user.id;
        login.innerHTML = user.login;
        name.innerHTML = user.name;
        lastName.innerHTML = user.lastName;
        phone.innerHTML = user.phone;
        email.innerHTML = user.email;
    });
}

function clearTable(table) {
    table.innerHTML = '';
}


function search() {

    var query = document.getElementById("user-login").value;
    query = " "+query +","+ document.getElementById("user-phone").value+" ";
    fetch('/search', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'query=' + query
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (userList) {
            fillTable(userList);
        })
        .catch(alert);
}</script>

</body>
</html>
