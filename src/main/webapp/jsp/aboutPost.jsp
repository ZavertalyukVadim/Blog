<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
    <script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function call() {
            var msg = $('#deleteComm').serialize();
            $.ajax(
                {

                    url: '/ajaxtest', // адрес вызываемой страницы
                    type: 'post', // тип отправки данных
                    dataType: 'json', // тип получения данных

                    data: msg, // отправляемые данные

                    success: function (msg) {
                        alert(msg);

//                        window.location = '/post/'+data;
//                        $('.results').html(data);
//                        $("#inp1").val(data);
//                        $("#p1").text(data);
                    }
                });
        }
    </script>
</head>
<body>

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
                <form action="/comment/update" method="get">
                    <input type="hidden" name="post_id" value="${post.id}">
                    <input type="hidden" name="comm_id" value="${comment.id}">
                    <button class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                </form>
                <form  action="/comment/${comment.id}/delete" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                    <button class="glyphicon glyphicon-remove-sign" aria-hidden="true"></button>
                </form>
                <%--<form id="deleteComm"  onsubmit="call()">--%>
                    <%--<input type="hidden" name="comment_id" value="${comment.id}">--%>
                    <%--<input type="hidden" name="post_id" value="${post.id}">--%>
                    <%--<button class="glyphicon glyphicon-remove-sign" aria-hidden="true"></button>--%>
                <%--</form>--%>
            </div>
        </c:forEach>
        <form action="/comment/new" method="get">
            <input type="hidden" name="id" value="${post.id}">
            <button class="glyphicon glyphicon-plus" aria-hidden="true"></button>
        </form>

        <%--<form id="form" onsubmit="call()">--%>
            <%--<input type="hidden" name="id" value="${post.id}">--%>
            <%--<input type="text" name="name" required>--%>
            <%--<button class="glyphicon glyphicon-minus" aria-hidden="true"></button>--%>
        <%--</form>--%>

        <%--<form>--%>
            <%--<p><input type="text" id="inp1"></p>--%>
            <%--<p id="p1"></p>--%>
        <%--</form>--%>
        <%--<div class="results">Ждем ответа</div>--%>
    </div>
</div>
</body>
</html>
