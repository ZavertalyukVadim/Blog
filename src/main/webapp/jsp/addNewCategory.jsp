<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
    <title>New Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
</head>
<body>
<input type="submit" value="Home" onclick="window.location='/'"><br>
<form:form class="container panel panel-default" method="POST"   action="/category/newCategory">

    <input type="text" name="name" placeholder="add name" required><br>
    <input type="text" name="description" placeholder="add description" required><br>
    <br>
    <input type="submit" value="Add Category" ><br>
</form:form>
</body>
</html>
