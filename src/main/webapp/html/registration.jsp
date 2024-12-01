<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Your Account</title>
  <link rel="stylesheet" href="../css/registration.css">
</head>
<body>
  <div class="register-container">
    <h1>Create Your Account</h1>
    <p>Join us and start your journey today!</p>
    <form action="#" method="POST" class="register-form">
      <label for="username">Username</label>
      <input type="text" id="username" name="username" placeholder="Enter your username" required>

      <label for="email">Email</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <label for="confirm-password">Confirm Password</label>
      <input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm your password" required>

      <div class="button-group">
        <button type="submit" class="btn primary">Register</button>
        <button type="button" class="btn secondary" onclick="window.history.back()">Back</button>
      </div>
    </form>
    <p class="footer-text">Already have an account? <a href="login.html">Login here</a></p>
  </div>
</body>
</html>
