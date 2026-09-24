<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Profile</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/edit_job.css">

</head>

<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/login"/>
</c:if>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Edit Profile</h1>

    <form action="${pageContext.request.contextPath}/edituserprofile"
          method="post">

        <input type="hidden"
               name="id"
               value="${user.id}">

        <label>User Name</label>

        <input type="text"
               name="name"
               value="${user.name}"
               required>

        <label>Email</label>

        <input type="email"
               name="email"
               value="${user.email}"
               required>

        <label>Password</label>

        <input type="text"
               name="password"
               value="${user.password}"
               required>

        <input type="submit"
               value="Edit Profile">

    </form>

</div>

</body>
</html>