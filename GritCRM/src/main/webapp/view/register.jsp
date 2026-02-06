
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>

<h1>Register to CRM</h1>

<c:if test="${empty success}">
    <form method="POST" action="/register">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                    ${error}
            </div>
        </c:if>
    <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" name="username" value="${username}">
    </div>

    <div class="mb-3">
        <label for="password1" class="form-label">Password</label>
        <input type="password" class="form-control" id="password1" name="password1" value="${password1}">
    </div>

    <div class="mb-3">
        <label for="password2" class="form-label">Repeat Password</label>
        <input type="password" class="form-control" id="password2" name="password2" value="${password2}">
    </div>

    <button type="submit" class="btn btn-primary">Register</button>

    </form>
</c:if>

<c:if test="${not empty success}">

    <div class="alert alert-success">
            ${success}
    </div>

</c:if>



<p>
   If you already have an account, you can <a href="/view/login.jsp">login here</a>
</p>

<%@include file="/WEB-INF/fragments/footer.jsp"%>