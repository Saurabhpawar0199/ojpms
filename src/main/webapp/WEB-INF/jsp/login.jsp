<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>OJPMS - Login</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/navbar.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/login.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="login-page">

    <div class="form-container">

        <!-- Branding Section -->

        <div class="logo-section">

            <h2>OJPMS</h2>

            <p>
                Online Job Portal Management System
            </p>

        </div>

        <!-- Welcome Section -->

        <h1>Welcome Back</h1>

        <p>
            Login to continue your job search journey.
        </p>

        <!-- Login Form -->

        <form action="${pageContext.request.contextPath}/login"
              method="post">

            <label>Email</label>

            <input type="email"
                   name="email"
                   placeholder="Enter Email Address"
                   required>

            <label>Password</label>

            <input type="password"
                   name="password"
                   id="password"
                   placeholder="Enter Password"
                   required>

            <a href="${pageContext.request.contextPath}/reset"
               class="forgot-link">

                Forgot Password?

            </a>

            <input type="submit"
                   value="Login">

        </form>

        <!-- Messages -->

        <p class="error">
            ${error}
        </p>

        <p class="success">
            ${msg}
        </p>

        <!-- Register Section -->

        <div class="register-section">

            <p>

                Don't have an account?

                <a href="${pageContext.request.contextPath}/register">

                    Register Here

                </a>

            </p>

        </div>

        <hr>

        <!-- Role Information -->

        <div class="role-info">

            <h3>Login As</h3>

            <ul>

                <li>Job Seeker</li>

                <li>Recruiter</li>

            </ul>

        </div>

        <!-- Security Notice -->

        <div class="security-info">

            <p>

                🔒 Your information is protected and
                securely managed by OJPMS.

            </p>

        </div>

        <!-- Back To Home -->

        <div class="back-home">

            <a href="${pageContext.request.contextPath}/home">

                ← Back to Home

            </a>

        </div>

    </div>

</div>

</body>

</html>