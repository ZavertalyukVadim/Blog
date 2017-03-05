<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <title>Blog</title>
</head>
<body>
<c:if test="${role}">
    <span>
        <a href="/logout" style="margin-left: 96%;" class="btn btn-primary btn-xs">Logout</a>
    </span>
</c:if>
<c:if test="${!role}">
    <span class="">
        <a href="/login" class="btn btn-primary btn-xs" style="margin-left: 92%;">Sing in</a>
       <a href="/registration" class="btn btn-primary btn-xs">Sing up</a>
    </span>
</c:if>
<nav class="navbar navbar-default">
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <div class="nav navbar-nav navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="/post/newPost">Add post</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="/category/newCategory">Add category<span class="sr-only">(current)</span></a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="/tag/newTag">Add tag<span class="sr-only">(current)</span></a></li>
                </ul>
                <c:if test="${role}">
                    <ul class="nav navbar-nav">
                        <li><a href="/user">User Profile<span class="sr-only">(current)</span></a></li>
                    </ul>
                </c:if>
            </div>
        </div>
    </div>
</nav>
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
