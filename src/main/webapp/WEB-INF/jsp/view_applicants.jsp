<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>View Applicants</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/navbar.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/view_applicants.css">

</head>

<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/login"/>
</c:if>

<jsp:include page="navbar.jsp"/>

<div class="page-header">

    <h1>Applicants Dashboard</h1>

    <p>
        Review and manage candidates who applied to your job postings.
    </p>

</div>

<div class="jobs-container">

    <c:forEach var="app" items="${applications}">

        <c:if test="${app.job.recuriter.id == recruiterId}">

            <div class="job-card">

                <h3>${app.job.title}</h3>

                <p>
                    👤 <b>Applicant:</b>
                    ${app.user.name}
                </p>

                <p>
                    📧 <b>Email:</b>
                    ${app.user.email}
                </p>

                <p>
                    📍 <b>Location:</b>
                    ${app.job.location}
                </p>

                <c:choose>

                    <c:when test="${app.status == 'APPLIED'}">
                        <span class="status status-applied">
                            📄 Applied
                        </span>
                    </c:when>

                    <c:when test="${app.status == 'UNDER_REVIEW'}">
                        <span class="status status-review">
                            ⏳ Under Review
                        </span>
                    </c:when>

                    <c:when test="${app.status == 'SELECTED'}">
                        <span class="status status-selected">
                            ✅ Selected
                        </span>
                    </c:when>

                    <c:otherwise>
                        <span class="status status-rejected">
                            ❌ Rejected
                        </span>
                    </c:otherwise>

                </c:choose>

            </div>

        </c:if>

    </c:forEach>

</div>

</body>
</html>