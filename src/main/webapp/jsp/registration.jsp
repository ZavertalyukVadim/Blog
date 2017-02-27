<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<form class="container panel panel-default" action="/registration" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    FirstName: <input type="text" name="first_name"/><br/><br/>
    LastName: <input type="text" name="last_name"/><br/><br/>
    Username: <input type="text" name="username"/><br/><br/>
    Email: <input type="text" name="email"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    BD : <input type="date" name="birthday"/><br/><br/>
    <input type="submit" value="register"/>
</form>
</body>
</html>
