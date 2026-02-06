
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>

    <h1>Login to CRM</h1>


    <form method="POST" action="/login">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="${username}">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>


    </form>


<p>
    If you don't already have an account, you can <a href="/register.jsp">register here</a>
</p>

<%--</body>--%>
<%--</html>--%>
<%@include file="/WEB-INF/fragments/footer.jsp"%>
