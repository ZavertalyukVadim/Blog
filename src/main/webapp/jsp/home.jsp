<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../resources/css/style.css">
    <title>Home</title>
</head>
<body>
<div class="allTasks">
    <c:forEach items="${users}" var="user">
        <h2>${user.first_name}</h2>
    </c:forEach>
</div>
</body>
</html>
