<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Google Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;500;600;700&display=swap"
      rel="stylesheet">

<!-- Navbar CSS -->
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/base.css">

<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/navbar.css">

<div class="navbar">

    <!-- Left Section -->
    <div class="nav-left">

        <a href="${pageContext.request.contextPath}/home"
           class="logo">
            OJPMS
        </a>

        <c:if test="${sessionScope.user != null && sessionScope.user.role == 'JOB_SEEKER'}">

            <form action="${pageContext.request.contextPath}/viewjob"
                  method="get"
                  class="nav-search">

                <input type="search"
                       name="search"
                       placeholder="Search jobs...">

                <button type="submit">
                    Search
                </button>

            </form>

        </c:if>

    </div>

    <!-- Right Section -->
    <div class="nav-right">

        <button id="themeToggle" class="theme-btn">
            🌙
        </button>

        <!-- Guest -->

        <c:if test="${sessionScope.user == null}">

            <a href="${pageContext.request.contextPath}/home"
               class="nav-btn">
                Home
            </a>

            <a href="${pageContext.request.contextPath}/login"
               class="nav-btn">
                Login
            </a>

            <a href="${pageContext.request.contextPath}/register"
               class="nav-btn">
                Register
            </a>

        </c:if>

        <!-- Job Seeker -->

        <c:if test="${sessionScope.user != null && sessionScope.user.role == 'JOB_SEEKER'}">

            <a href="${pageContext.request.contextPath}/userdashboard"
               class="nav-btn">
                Dashboard
            </a>

            <a href="${pageContext.request.contextPath}/viewjob"
               class="nav-btn">
                Jobs
            </a>

			<a href="${pageContext.request.contextPath}/profile?id=${sessionScope.user.id}"
			   class="nav-btn">
			    Profile
			</a>

            <span class="user-name">
                Hi, ${sessionScope.user.name}
            </span>

            <a href="${pageContext.request.contextPath}/logout"
               class="logout-btn">
                Logout
            </a>

        </c:if>

        <!-- Recruiter -->

        <c:if test="${sessionScope.user != null && sessionScope.user.role == 'RECRUITER'}">

            <a href="${pageContext.request.contextPath}/recruiterdashboard"
               class="nav-btn">
                Dashboard
            </a>

            <a href="${pageContext.request.contextPath}/postjob"
               class="nav-btn">
                Post Job
            </a>

            <a href="${pageContext.request.contextPath}/recruiterprofile"
               class="nav-btn">
                Profile
            </a>

            <span class="user-name">
                Hi, ${sessionScope.user.name}
            </span>

            <a href="${pageContext.request.contextPath}/logout"
               class="logout-btn">
                Logout
            </a>

        </c:if>

    </div>

</div>

<script>

const themeBtn = document.getElementById("themeToggle");

if (themeBtn) {

    if (localStorage.getItem("theme") === "dark") {

        document.body.classList.add("dark-theme");
        themeBtn.innerHTML = "☀️";

    }

    themeBtn.addEventListener("click", () => {

        document.body.classList.toggle("dark-theme");

        if (document.body.classList.contains("dark-theme")) {

            localStorage.setItem("theme", "dark");
            themeBtn.innerHTML = "☀️";

        } else {

            localStorage.setItem("theme", "light");
            themeBtn.innerHTML = "🌙";

        }

    });

}

</script>