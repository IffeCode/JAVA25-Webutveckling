<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
int counter = 0;




%>
<%
    counter++;
    String[] fruits = {"Banan", "Melon", "Kiwi", "Citron"};
    request.setAttribute("fruits", fruits);
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%@include file="WEB-INF/fragments/header.jsp"%>


<p class = "container">
    Denna sida har haft <%= counter %>
<p/>
<hr/>
<div class = "container">
    <ul class ="list-group">
        <c:forEach items="${fruits}" var="fruit">
        <li class="list-group-item
        <c:if test="${fruit == \"Citron\" }">citron</c:if>
        ">${fruit}</li>
        </c:forEach>
    </ul>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>