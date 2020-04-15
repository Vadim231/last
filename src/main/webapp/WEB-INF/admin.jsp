<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>TaskKit</title>

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

            <div class="container">
                <div class="row">

                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <svg class="card-img-top" width="100%" height="300">
                                <rect width="100%" height="100%" fill="#221817"></rect>
                                <text x="42%" y="50%" fill="#eceeef" >Users</text>
                            </svg>
                            <div class="card-body">
                                <p class="card-text">101 registered users</p>
                                <p class="card-text">32 is online</p>
                                <a href="/fs/users">users</a>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <svg class="card-img-top" width="100%" height="300">
                                <rect width="100%" height="100%" fill="#2d221e"></rect>
                                <text x="40%" y="50%" fill="#eceeef" >Projects</text>
                            </svg>
                            <div class="card-body">
                                <p class="card-text">10 started projects</p>
                                <p class="card-text">6 finished yet</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <svg class="card-img-top" width="100%" height="300">
                                <rect width="100%" height="100%" fill="#352e2c"></rect>
                                <text x="42%" y="50%" fill="#eceeef" >Tasks</text>
                            </svg>
                            <div class="card-body">
                                <p class="card-text">316 tasks given</p>
                                <p class="card-text">305 done yet</p>
                            </div>
                        </div>
                    </div>



                </div>
            </div>

        </main>
    </div>
</div>



<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"/>
</body>
</html>
