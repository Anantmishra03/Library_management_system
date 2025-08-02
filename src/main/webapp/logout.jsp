<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Logout Confirmation</title>
    <script>
        function confirmLogout() {
            const userConfirmed = confirm("Are you sure you want to logout?");
            if (userConfirmed) {
                // If confirmed, send request to logout.jsp with logout=true
                window.location.href = "logout.jsp?logout=true";
            } else {
                // Stay on the current page
                window.history.back(); // or redirect to home/dashboard page
            }
        }
    </script>
</head>
<body onload="confirmLogout()">
<%
    String logoutParam = request.getParameter("logout");
    if ("true".equals(logoutParam)) {
        HttpSession session2 = request.getSession(false);
        if (session2 != null) {
            session2.invalidate();
        }
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>