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
</head>
<body>
<body>
Dear <strong>${user}</strong>, Welcome to Admin Page.
<a href="<c:url value="/logout" />">Logout</a>
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
</body>
</body>
</html>
