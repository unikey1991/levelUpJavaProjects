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
    <style type="text/css">
        #aa {
            height: 500px; /* Высота блока */
            width: 1000px; /* Ширина блока */
            /*overflow: auto; !* Добавляем полосы прокрутки *!*/
            /*padding-left: 15px; !* Отступ от текста слева *!*/
            background: url("https://www.soyuz.ru/public/uploads/files/6/6968307/20170308232619a4176baf60.jpg") repeat-y #fc0;
            padding-top: 300px;
            /* Цвет фона,
                                                               путь к фоновому изображению и
                                                               повторение фона по вертикали */
        }
    </style>
</head>
<body>
<div align="center" >
<div align="center" id="aa">
    <table class="table">
        <thead class="thead-inverse">
        </thead>
        <tbody id="user-table">
        </tbody>
    </table>
    <div>
        <input type="text" id="movie-session-id"/><span>
    <button onclick="getArray()">Load</button></span>
    </div>
</div></div>


<script type="text/javascript">

    var userTable = document.getElementById("user-table");
    var allHals = ${allHalls};

    function draw(tickets) {

        clearTable(userTable);

        var currentHall = 0;
        allHals.forEach(function (p1) {
            if (p1.id.value === tickets[0].hallId.value) {
                currentHall = p1;
            }
        });
        console.log(currentHall);
//        var img1 = new Image(100, 100);
//        var img2 = new Image(100, 100);
//        img1.src = '/resources/images/1.img';
//        img1.src = 'http://s1.iconbird.com/ico/2013/9/446/w512h5121380376664MetroUITask.png';
//        img2.src = '/resources/images/2.img';
//        img1.src = 'http://iconizer.net/files/Puck_icons_pack_II/orig/Windows_Close_Program.png';


//        var rowsAndCels = [12][12];
        var rowsAndCels = [];
        var k = 0;
        for (var i = 0; i < currentHall.rowsNumberInHall; i++) {
            rowsAndCels[i] = userTable.insertRow(i);
            for (var j = 0; j < currentHall.seatsNumberInHall; j++) {
                rowsAndCels[i][j] = rowsAndCels[i].insertCell(j);
                rowsAndCels[i][j].innerHTML = '<img src="http://s1.iconbird.com/ico/0612/vistabasesoftwareicons/w256h2561339252444BoxGreen.png" width="40" height="40" alt="lorem">';

            }
            k++;
        }

        tickets.forEach(function (tickets) {

            var lineNum = tickets.lineNumber - 1;
            var seatNum = tickets.seatNumber - 1;
            console.log(lineNum);
            console.log(seatNum);

            rowsAndCels[lineNum][seatNum].innerHTML = '<img src="http://s1.iconbird.com/ico/2013/9/446/w512h5121380376664MetroUITask.png" width="40" height="40" alt="lorem">';
//            console.log(img2);

        });


    }

    function clearTable(table) {
        table.innerHTML = '';
    }

    function getArray() {


        var hallId = document.getElementById("movie-session-id").value;
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
