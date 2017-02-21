<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<form action="/category/newCategory" method="post">
    <input type="text" name="name" placeholder="add name" required><br>
    <input type="text" name="description" placeholder="add description" required><br>
    <input type="submit" value="Add Category"><br>
</form>
</body>
</html>
