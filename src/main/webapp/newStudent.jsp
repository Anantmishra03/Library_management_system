<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Student</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="form-container">
        <h2>NEW STUDENT</h2>
        <form action="StudentServlet"method="post">
            <input type="text" name="studentId" placeholder="Student ID" required>
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="course" placeholder="Course Name" required>
            <input type="text" name="branch" placeholder="Branch Name" required>

            <div class="button-group">
                <button type="submit" class="save-btn" onclick="window.location.href='issueBook.jsp'">Save</button>
                <button type="button" class="close-btn" >Close</button>
            </div>
        </form>
    </div>
</body>
</html>
