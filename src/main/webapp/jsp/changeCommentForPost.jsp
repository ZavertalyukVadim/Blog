<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>

<div class="container panel panel-default">
    <div class="panel-heading">
        ${post.title}
        <input type="submit" value="Home" onclick="window.location='/'">
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

                <c:if test="${comment.id == comm.id}">
                    <form action="/comment/update" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="hidden" name="comm_id" value="${comm.id}">
                        <input type="hidden" name="post_id" value="${post.id}">
                        <input type="text" name="content" value=${comm.content} required><br>
                        <input type="submit" value="Update comment"><br>
                    </form>
                </c:if>
                <c:if test="${comment.id != comm.id}">
                    <h4>${comment.content}</h4>
                    <form action="/comment/${comment.id}/change" method="get">
                        <input type="hidden" name="id" value="${post.id}">
                        <button class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                    </form>
                </c:if>
                <form action="/comment/${comment.id}/delete" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                    <button class="glyphicon glyphicon-remove-sign" aria-hidden="true"></button>
                </form>
            </div>
        </c:forEach>
        <form action="/comment/new" method="get">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" name="id" value="${post.id}">
            <button class="glyphicon glyphicon-plus" aria-hidden="true"></button>
        </form>
    </div>
</div>
</body>
</html>
