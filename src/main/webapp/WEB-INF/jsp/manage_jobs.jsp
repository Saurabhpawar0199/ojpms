<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Manage Jobs</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/manage_job.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="jobs-page">

    <h1>Manage Jobs</h1>

    <p>
        View all jobs posted by you.
    </p>

    <c:if test="${empty jobs}">
        <h3>No jobs posted yet.</h3>
    </c:if>

    <div class="jobs-container">

        <c:forEach var="job" items="${jobs}">

            <div class="job-card">

                <h2>
                    ${job.title}
                </h2>

                <p>
                    <b>Description:</b>
                    ${job.description}
                </p>

                <p>
                    📍 <b>Location:</b>
                    ${job.location}
                </p>

                <p>
                    <b>Salary:</b>
                    ₹${job.salary}
                </p>

                <span class="status">
                    ● Active
                </span>

                <a href="${pageContext.request.contextPath}/editjob?id=${job.id}"
                   class="apply-btn">
                    ✏️ Edit Job
                </a>

            </div>

        </c:forEach>

    </div>

</div>

</body>

</html>