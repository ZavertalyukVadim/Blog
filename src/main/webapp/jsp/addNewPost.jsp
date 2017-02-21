<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New post</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<form action="/post/newPost" method="post">
    <input type="text" name="title" placeholder="add title" required><br>
    <input type="text" name="description" placeholder="add description" required><br>
    <input type="text" name="content" placeholder="add content" required><br>
    <input type="submit" value="Add post"><br>
</form>
</body>
</html>
