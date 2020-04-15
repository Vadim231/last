<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Users</title>

    <style>
        <jsp:directive.include file="bootstrap-4.3.1-dist/css/bootstrap.min.css"/>
        <jsp:directive.include file="styles/dashboard.css"/>
        <jsp:directive.include file="styles/datatables-select.min.css"/>
        <jsp:directive.include file="styles/datatables.min.css"/>
        <jsp:directive.include file="styles/users.css"/>
    </style>

</head>

<body>
<jsp:directive.include file="navbar.jsp"/>

<div class="container-fluid">
    <div class="row">

        <jsp:directive.include file="sidebar.jsp"/>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <h3>Список сотрудников</h3>
            <input class="form-control" type="text" placeholder="Введите ФИО" id="search-text" onkeyup="tableSearch()">

            <div class="table--no-card m-b-40">
                <table class="table table-borderless table-striped table-earning" id="info-table">
                    <thead>
                    <tr>
                        <th style="width:5%;" class="text-left">ID</th>
                        <th style="width:20%;" class="text-left">Логин</th>
                        <th style="width:35%;" class="text-left">ФИО</th>
                        <th style="width:15%;" class="text-left">Роль</th>
                        <th style="width:20%;" class="text-center">Действия</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var = "user" items="${users}">
                        <tr>
                            <td class="text-left">${user.id}</td>
                            <td class="text-left">${user.login}</td>
                            <td class="text-left">${user.fio}</td>
                            <td class="text-left">${user.roleTitle}</td>
                            <td class="text-center">
                                <a href="/fs/profile?userId=${user.id}" class="btn-shadow btn btn-secondary">Изменить</a>

                            </td>
                        </tr>

                    </c:forEach>

                    </tbody>
                </table>
            </div>


        </main>
    </div>
</div>


<script src="bootstrap-4.3.1-dist/js/bootstrap.js.map"></script>
<script>
    function tableSearch() {
        var phrase = document.getElementById('search-text');
        var table = document.getElementById('info-table');
        var regPhrase = new RegExp(phrase.value, 'i');
        var flag = false;
        for (var i = 1; i < table.rows.length; i++) {
            flag = false;
            flag = regPhrase.test(table.rows[i].cells[2].innerHTML);
            if (flag) {
                table.rows[i].style.display = "";
            } else {
                table.rows[i].style.display = "none";
            }
        }
    }
</script>

</body>
</html>