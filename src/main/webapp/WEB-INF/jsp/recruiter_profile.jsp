<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Recruiter Profile</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/navbar.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/profile.css">

</head>

<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/login"/>
</c:if>

<jsp:include page="navbar.jsp"/>

<div class="profile-wrapper">

    <div class="profile-card">

        <div class="profile-header">

            <div class="avatar">
                ${sessionScope.user.name.substring(0,1).toUpperCase()}
            </div>

            <h2>${sessionScope.user.name}</h2>

            <p class="role">
                ${sessionScope.user.role}
            </p>

            <div class="profile-badge">
                Active Member
            </div>

        </div>

        <div class="profile-details">

            <p>
                <b>ID:</b>
                ${sessionScope.user.id}
            </p>

            <p>
                📧 <b>Email:</b>
                ${sessionScope.user.email}
            </p>

            <p>
                👤 <b>Role:</b>
                ${sessionScope.user.role}
            </p>

        </div>

        <form action="${pageContext.request.contextPath}/editrecruiterprofile"
              method="get">

            <input type="hidden"
                   name="userId"
                   value="${sessionScope.user.id}">

            <input type="submit"
                   value="Edit">

        </form>

    </div>

</div>

</body>
</html>