<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <title>Post</title>
</head>
<body>
<div class="page-header">
    <div class="container">
        <h1>Blog</h1>
    </div>
</div>
<c:forEach items="${posts}" var="post">

        <div class="container panel panel-default">
            <div class="panel-heading ">
                    <h2><a href="/post/${post.id}"> ${post.title}</a></h2>
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
                </c:forEach>
                <br>
                <br>
                <blockquote>
                    <p class="lead">${post.description}</p>
                </blockquote>
            </div>
        </div>

</c:forEach>
</body>
</html>
