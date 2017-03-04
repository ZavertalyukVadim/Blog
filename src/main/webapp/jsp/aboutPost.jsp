<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function deleteComm(id) {
            $.ajax({
                type: "GET",
                url: "/ajaxtest/" + id
            })
        }

        function remove() {
            $('.delete').click(function () {
                var id = $(this).val();
                var id_comment = "comment_" + id;
                var comment = document.getElementById(id_comment);
//                alert("!");
                $.ajax({
                    type: "GET",
                    url: "/ajaxtest",
                    data: {'id': id},
                    response: "text",
                    success: function () {
//                        comment.remove(comment);
                        comment.parentNode.removeChild(comment);
//                        alert("yeeeeeeeeees!");
                    }
                })
            })
        }
    </script>
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
            <div id="comment_${comment.id}" class="comment">
                <div class="panel-footer">
                    <h4>${comment.content}</h4>
                    <form action="/comment/update" method="get">
                        <input type="hidden" name="post_id" value="${post.id}">
                        <input type="hidden" name="comm_id" value="${comment.id}">
                        <button class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                    </form>
                        <%--<form class="delete">--%>
                        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                    <%--<button class="delete btn-link" value="${comment.id}">Видалити</button>--%>
                        <%--</form>--%>
                    <a href="" onclick="deleteComm(${comment.id})">
                        <i class="material-icons" style="color: red; font-size:20px">delete_forever</i>
                    </a>
                </div>
            </div>
        </c:forEach>
        <form action="/comment/new" method="get">
            <input type="hidden" name="id" value="${post.id}">
            <button class="glyphicon glyphicon-plus" aria-hidden="true"></button>
        </form>
    </div>
</div>
</body>
</html>
