<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Available Classrooms</title>
    <link rel="stylesheet" href="/css/All.css">

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body{
            font-family: Ubuntu;
        }
        nav a{ color: white;
        }

    </style>
    <link rel="stylesheet" href="/css/All.css">

</head>
<body>
<%

    if(session.getAttribute("login")!=null){
%>
<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #563D7C; ">
    <!-- Navbar content -->
    <a class="navbar-brand" href="#">IIIT-B Clasroom Manager</a>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/destroy" style="margin-right: 10px"><span class="glyphicon glyphicon-log-in" ></span> Logout</a></li>
    </ul>
</nav>

<div class="container">
    <h4>Hey, here are the available classrooms..</h4>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Classroom</th>
            <th scope="col">Capacity</th>
            <th scope="col">Projectors</th>
            <th scope="col">Plugs</th>
            <th scope="col">Request</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${availableClassrooms}">
        <tr>
            <td>${e.classCode}</td>
            <td>${e.capacity}</td>
            <td>${e.projector}</td>
            <td>${e.plugs}</td>
            <td><a href="/postRequest/${e.classCode}" class="btn btn-secondary">Request this room</a></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div>
    <!-- Footer -->
    <footer class="page-footer font-small blue">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">2020 Copyright:
            <a>Students of IIIT-B</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->
</div>
</body>
<% }
else {
    response.sendRedirect("LoginFirst.jsp");
}
%>
</html>