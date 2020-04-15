<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Profile</title>

    <style>
        <jsp:directive.include file="bootstrap-4.3.1-dist/css/bootstrap.min.css"/>
        <jsp:directive.include file="styles/dashboard.css"/>
    </style>

</head>

<body>
<jsp:directive.include file="navbar.jsp"/>

<div class="container-fluid">
    <div class="row">

        <jsp:directive.include file="sidebar.jsp"/>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

     <h1>Profile page</h1>
      <h1>${profile.surname} ${profile.name}</h1>

            <h3>${profileRole.name}</h3>
            <p></p>
        <h2>Задачи:</h2>
            <table class="table">
                <thead>
                <tr>
                    <th class="text-left">Название задачи</th>
                    <th class="text-left">Дата задачи</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var = "task" items="${userTasks}">
                    <tr>
                        <td class="text-left">${task.title}</td>
                        <td class="text-left">${task.date}</td>
                    </tr>

                </c:forEach>
                <form method="POST" action="/fs/delete">
                    <input type="hidden" name="userId" value="${profile.id}">
                    <c:if test="${not empty userTasks}">
                        <p>Невозможно удалить пользователя, у него есть незакрытые задачи</p>
                        <button disabled type="submit" class="btn btn-outline-danger disabled">Удалить</button>
                    </c:if>
                    <c:if test="${empty userTasks}">
                        <button type="submit" class="btn btn-danger">Удалить</button>
                    </c:if>
                </form>


                </tbody>
            </table>

        </main>
    </div>
</div>



<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"/>
</body>
</html>