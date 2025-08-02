<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Login</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="login-box">
        <h2>LIBRARY<br>MANAGEMENT<br>SYSTEM</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="a" placeholder="Username" required><br>
            <input type="password" name="b" placeholder="Password" required><br>
            <button type="submit">Log In</button>
        </form>
    </div>

    <%-- Show error popup if login failed --%>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <script>
        alert("<%= error %>");
    </script>
    <% } %>
</body>
</html>
