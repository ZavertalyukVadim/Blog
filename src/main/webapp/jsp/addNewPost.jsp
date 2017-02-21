<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New post</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<form class="container panel panel-default" action="/post/newPost" method="post">
    <input type="text" name="title" placeholder="add title" required><br>
    <input type="text" name="description" placeholder="add description" required><br>
    <input type="text" name="content" placeholder="add content" required><br><br>
    <div class="container panel panel-default">
        <h5>Only one category!</h5>
        <c:forEach items="${categories}" var="category">
            <input type="checkbox" name="category_id" value=${category.id}> ${category.name}<br>
        </c:forEach>
    </div>
    <br>

    <div class="container panel panel-default">
        <c:forEach items="${tags}" var="tag">
            <input type="checkbox" name="tag_id[]" value=${tag.id}> ${tag.name}<br>
        </c:forEach>
    </div>
    <input type="submit" value="Add post"><br>
</form>
</body>
</html>
