/**
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
    //var  query = document.getElementById("user-search").value;

    var queryLogin = document.getElementById("user-login").value;
    var queryPhone = document.getElementById("user-phone").value;

    fetch('/search', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'queryLogin=' + queryLogin,
        body: 'queryPhone=' + queryPhone
    })
        .then(function (response) {
            return response.json();
        })
        .then(function (userList) {
            fillTable(userList);
        })
        .catch(alert);
}