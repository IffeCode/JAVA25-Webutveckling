
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>

<h2>Create or edit account</h2>


<form method="POST" action="/account">
    <input type="hidden" name="id" value="${account.id}">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${account.name}">
    </div>
    <div class="mb-3">
        <label for="adress" class="form-label">Adress</label>
        <input type="text" class="form-control" id="adress" name="adress" value="${account.adress}">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <input type="text" class="form-control" id="country" name="country" value="${account.country}">
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
    <a href="/account" class="btn btn-secondary">Cancel</a>
</form>




<%@include file="/WEB-INF/fragments/footer.jsp"%>