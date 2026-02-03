
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%@include file="/WEB-INF/fragments/header.jsp"%>

    <h1>Login to CRM</h1>

    <form method="POST" action="/login">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>


    </form>

<%--</body>--%>
<%--</html>--%>
<%@include file="/WEB-INF/fragments/footer.jsp"%>
