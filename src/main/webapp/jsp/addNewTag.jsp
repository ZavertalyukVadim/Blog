<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Tag</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<input type="submit" value="Home" onclick="window.location='/'"><br>
<form class="container panel panel-default" action="/tag/newTag" method="post">
    <input type="text" name="name" placeholder="add name" required><br>
    <input type="submit" value="Add tag"><br>
</form>
</body>
</html>
