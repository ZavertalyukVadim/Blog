<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New post</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<input type="submit" value="Home" onclick="window.location='/'"><br>
<form class="container panel panel-default" action="/post/newPost" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <br>
    <input type="text" name="title" placeholder="add title" required><br>
    <input type="text" name="description" placeholder="add description" required><br>
    <input type="text" name="content" placeholder="add content" required><br><br>
        <select name="category_id" >
            <c:forEach items="${categories}" var="category">
                <option  value=${category.id}> ${category.name}</option>
            </c:forEach>
        </select>
    <br>
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
