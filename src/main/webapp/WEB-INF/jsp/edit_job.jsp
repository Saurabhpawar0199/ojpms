<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Job</title>

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/edit_job.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Edit Job</h1>

    <form action="${pageContext.request.contextPath}/updatejob"
          method="post">

        <input type="hidden"
               name="id"
               value="${job.id}">

        <label>Job Title</label>

        <input type="text"
               name="title"
               value="${job.title}"
               required>

        <label>Description</label>

        <textarea name="description"
                  rows="5"
                  required>${job.description}</textarea>

        <label>Location</label>

        <input type="text"
               name="location"
               value="${job.location}"
               required>

        <label>Salary</label>

        <input type="number"
               name="salary"
               value="${job.salary}"
               required>

        <input type="submit"
               value="Save Changes">

    </form>

</div>

</body>

</html>