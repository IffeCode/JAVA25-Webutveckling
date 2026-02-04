
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>

<h1>Register to CRM</h1>

<form method="POST" action="/register">

    <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" name="username" value="">
    </div>

    <div class="mb-3">
        <label for="password1" class="form-label">Password</label>
        <input type="password" class="form-control" id="password1" name="password1" value="">
    </div>

    <div class="mb-3">
        <label for="password2" class="form-label">Repeat Password</label>
        <input type="password" class="form-control" id="password2" name="password2" value="">
    </div>

    <button type="submit" class="btn btn-primary">Register</button>


</form>



<p>
   If you already have an account, you can <a href="/view/login.jsp">login here</a>
</p>

<%@include file="/WEB-INF/fragments/footer.jsp"%>