<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediPlan - Home</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <header class="header">
        <div class="container">
            <h1 class="logo">MediPlan</h1>
            <nav class="navigation">
                <ul>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="signup.jsp">Sign Up</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main>
        <section id="hero">
            <div class="hero-content">
                <h2>Welcome to MediPlan</h2>
                <p>Your ultimate solution for managing medications and healthcare tasks.</p>
                <a href="signup.jsp" class="btn">Get Started</a>
            </div>
        </section>

        <section id="about">
            <div class="container">
                <h2>About MediPlan</h2>
                <p>MediPlan helps you stay on top of your health by offering medication reminders, refill orders, and appointment management in one place.</p>
            </div>
        </section>
    </main>

    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 MediPlan. All rights reserved.</p>
        </div>
    </footer>
</body>

</html>
