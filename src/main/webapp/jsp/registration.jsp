<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<div class="form-container">

    <h1>New User Registration Form</h1>

    <form:form method="POST" modelAttribute="user" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="first_name">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="first_name" id="first_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="first_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="last_name">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="last_name" id="last_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="last_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="username">username</label>
                <div class="col-md-7">
                    <form:input type="text" path="username" id="username" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="username" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">Password</label>
                <div class="col-md-7">
                    <form:input type="password" path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="birthday">BD</label>
                <div class="col-md-7">
                    <form:input type="text" path="birthday" id="birthday" class="form-control input-sm" placeholder="dd/mm/yyyy"/>
                    <div class="has-error">
                        <form:errors path="birthday" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <%--<div class="row">--%>
            <%--<div class="form-group col-md-12">--%>
                <%--<label class="col-md-3 control-lable" for="userProfiles">Roles</label>--%>
                <%--<div class="col-md-7">--%>
                    <%--<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>--%>
                    <%--<div class="has-error">--%>
                        <%--<form:errors path="userProfiles" class="help-inline"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value="/registration" />">Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
