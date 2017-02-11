<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<input type="submit" value="Home" onclick="window.location='/'"><br>
<div class="container panel panel-default">
    <div class="panel-heading">
        ${post.title}
    </div>
    <div class="panel-body">
        <form action="/category/${post.category.id}" method="get">
            <button type="submit" class="btn btn-primary btn-xs">${post.category.name}</button>
        </form>
        <c:forEach items="${post.tags}" var="tag">
            <div class="btn-group" role="group" aria-label="...">
                <form action="/tag/${tag.id}" method="get">
                    <button type="submit" class="btn btn-info btn-xs">${tag.name}</button>
                </form>
            </div>
        </c:forEach><br>
        Created: ${post.created_date}<br>
        Author: ${post.author.user.username}<br>
        <blockquote>
            ${post.content}<br>
        </blockquote>
        <c:forEach items="${post.comments}" var="comment">
            <div class="panel-footer">
                <h4>${comment.content}</h4>
                <form action="/comment/${comment.id}/delete" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                    <button class="glyphicon glyphicon-remove-sign" aria-hidden="true"></button>
                </form>
            </div>
        </c:forEach>
        <form action="/comment/new" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <input type="text" name="content" placeholder="add content" required><br>
            <input type="submit" value="Add comment"><br>
        </form>
    </div>
</div>
</body>
</html>
