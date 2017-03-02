<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<body>
<a href="<c:url value="/logout" />">Logout</a><br>
<div class="container panel">
    <table>
        <tr>
            <th>Firstname </th>
            <th>Lastname </th>
            <th>Username </th>
            <th>Password </th>
            <th>Email </th>
        </tr>
        <tr>
            <td>${user.first_name}</td>
            <td>${user.last_name}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
        </tr>
    </table>
    <form action="/user/changeProfile" method="get">
        <input type="submit" value="Change Profile"><br>
    </form>
</div>
</body>
</body>
</html>
