<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/fragments/header.jsp"%>
<%@include file="/WEB-INF/fragments/navbar.jsp"%>

<h2>Account Details</h2>

<a href="/account" class="btn btn-primary">Back to account list</a>

<hr>

<p> Account Name</p>
<p>${account.name}</p>

<p> Account Adress</p>
<p>${account.adress}</p>

<p> Account Country</p>
<p>${account.country}</p>





<%@include file="/WEB-INF/fragments/footer.jsp"%>