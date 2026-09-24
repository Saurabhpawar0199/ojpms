<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Applications</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/my_applications.css">

</head>

<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/login"/>
</c:if>

<jsp:include page="navbar.jsp"/>

<div class="applications-page">

    <h1>My Applications</h1>

    <p>
        Track all the jobs you have
        applied for.
    </p>

    <c:if test="${empty applications}">

        <h3>
            You haven't applied for any jobs yet.
        </h3>

    </c:if>

    <div class="applications-grid">

        <c:forEach var="app" items="${applications}">

            <div class="application-card">

                <h2>${app.job.title}</h2>

                <p>
                    <b>Description:</b>
                    ${app.job.description}
                </p>

                <p>
                    📍 <b>Location:</b>
                    ${app.job.location}
                </p>

                <p>
                    <b>Salary:</b>
                    ₹${app.job.salary}
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

        </c:forEach>

    </div>

</div>

</body>
</html>