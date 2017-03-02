<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="container panel">
    <table>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
        </tr>
        <tr>
            <form action="/user/changeProfile" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="hidden" name="id" value="${user.id}">
                <td><input type="text" name="first_name" value="${user.first_name}"><br></td>
                <td><input type="text" name="last_name" value="${user.last_name}"></td>
                <td><input type="text" name="username" value="${user.username}"></td>
                <td><input type="text" name="password" value="${user.password}"></td>
                <td><input type="text" name="email" value="${user.email}"></td>
                <td><input type="submit" value="Change Profile"></td>
            </form>
        </tr>
    </table>
</div>
</body>
</html>
