<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 24.02.17
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<body>
<div class="page-header">
    Dear <strong>${user}</strong>, Welcome to Admin Page.
    <a href="<c:url value="/logout" />">Logout</a>
</div>
<div class="container panel">
    <table>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.first_name}</td>
                <td>${user.last_name}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</body>
</html>
