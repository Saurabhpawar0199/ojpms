<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>OJPMS - Reset Password</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/reset.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="form-container">

    <h1>Reset Password</h1>

    <p class="form-subtitle">
        Enter your registered email address and create a new password.
    </p>

    <form action="${pageContext.request.contextPath}/reset"
          method="post">

        <label>Email Address</label>

        <input type="email"
               name="email"
               placeholder="Enter your registered email"
               required>

        <label>New Password</label>

        <input type="password"
               name="password"
               placeholder="Enter new password"
               required>

        <label>Confirm Password</label>

        <input type="password"
               name="confirmPassword"
               placeholder="Confirm new password"
               required>

        <small>
            Password should contain at least 6 characters.
        </small>

        <input type="submit"
               value="Reset Password">

    </form>

    <div class="form-links">

        <a href="${pageContext.request.contextPath}/login"
           class="btn">
            Back to Login
        </a>

        <a href="${pageContext.request.contextPath}/register"
           class="btn register-btn">
            Create New Account
        </a>

    </div>

    <p class="success">
        ${success}
    </p>

    <p class="error">
        ${error}
    </p>

    <div class="security-note">

        <h3>Security Notice</h3>

        <p>
            Never share your password with anyone.
            OJPMS support will never ask for your password.
        </p>

    </div>

</div>

</body>
</html>