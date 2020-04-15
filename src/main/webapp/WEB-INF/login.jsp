<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored = "false" %>
<html lang="ru">
<head>
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <jsp:directive.include file="bootstrap-4.3.1-dist/css/bootstrap.min.css"/>
        <jsp:directive.include file="styles/signin.css"/>
    </style>

</head>
<body class="text-center">
<div class="background"></div>
<form class="form-signin" method="post" action="/fs/authorization">
    <img class="mb-4" src="<c:url value="../images/logo.svg" />" alt="" width="72" height="72">

    <h2 class="h2 mb-3 font-weight-normal">Please sign in</h2>

    <label for="inputLogin" class="sr-only">Email address</label>
    <input type="text" id="inputLogin" class="form-control" name="login" placeholder="Login" required="" autofocus="">

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required="">

    <button class="btn btn-lg btn-block">Sign in</button>
</form>

<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"/>
</body>
</html>
