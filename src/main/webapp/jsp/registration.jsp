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
    <div>
        FirstName: <input type="text" name="first_name"/><br/><br/>
        <div class="has-error">
            <form:errors path="first_name" class="help-inline"/>
        </div>
    </div>
    <div>
        LastName: <input type="text" name="last_name"/><br/><br/>
        <div class="has-error">
            <form:errors path="last_name" class="help-inline"/>
        </div>
    </div>
    <div>
        Username: <input type="text" name="username"/><br/><br/>
        <div class="has-error">
            <form:errors path="username" class="help-inline"/>
        </div>
    </div>
    <div>
        Email: <input type="text" name="email"/><br/><br/>
        <div class="has-error">
            <form:errors path="email" class="help-inline"/>
        </div>
    </div>
    <div>
        Password: <input type="password" name="password"/><br/><br/>
        <div class="has-error">
            <form:errors path="password" class="help-inline"/>
        </div>
    </div>
    <div>
        BD : <input type="text" name="birthday" placeholder="dd/MM/yyyy"/><br/><br/>
        <div class="has-error">
            <form:errors path="birthday" class="help-inline"/>
        </div>
    </div>
    <input type="submit" value="register"/>
</form>
</body>
</html>
0