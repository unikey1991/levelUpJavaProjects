<%--
  Created by IntelliJ IDEA.
  User: unike
  Date: 10.07.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hall map</title>
</head>
<body>


<table class="table">
    <thead class="thead-inverse">
    </thead>
    <tbody id="user-table">
    </tbody>
</table>
<div>

    <input type="text" id="Введите ИД сеанса"/><span>
    <button onclick="getArray()">Load</button>
</div>

<script type="text/javascript">

    var userTable = document.getElementById("user-table");

    function draw(seatsAndRanges) {


        var img1 = new Image(100, 100);
        var img2 = new Image(100, 100);
//        img1.src = '/resources/images/1.img';
        img1.src = 'http://s1.iconbird.com/ico/2013/9/446/w512h5121380376664MetroUITask.png';
//        img1.src = '/resources/images/2.img';
        img1.src = 'http://iconizer.net/files/Puck_icons_pack_II/orig/Windows_Close_Program.png';


        for (var i = 0; i < 12; i++) {
            var row = userTable.insertRow(i);
            for (var j = 0; j < 12; j++) {
                var id = row.insertCell(j);
                id.innerHTML = seatsAndRanges[i][j];
                if (seatsAndRanges[i][j] >= 0){
                    id.innerHTML = img1;
                } else {
                    id.innerHTML = img2;
                }

            }
        }
    }


    function getArray() {


        var hallId = document.getElementById("hall-id").value;
        fetch('/movie/getHall', {
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            body: 'hallId=' + hallId
        })
            .then(function (response) {
                return response.json();
            })
            .then(function (list) {
                draw(list);
            })
            .catch(alert);

    }

</script>


</body>
</html>
