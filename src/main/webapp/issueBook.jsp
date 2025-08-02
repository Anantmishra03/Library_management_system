<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Issue Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="form-container">
        <h2>ISSUE BOOK</h2>
       <form action="IssueBookServlet" method="post">
            <input type="text" name="studentId" placeholder="Student ID" required>
            <input type="text" name="studentName" placeholder="Student Name" required>
            <input type="text" name="bookId" placeholder="Book ID" required>
            <input type="text" name="bookName" placeholder="Book Name" required>
            <input type="date" name="issueDate" value="<%= currentDate %>" required>
            <input type="date" name="dueDate" placeholder="Due Date" required>

            <div class="button-group">
                <button type="submit" class="issue-btn">Issue</button>
                <button type="button" class="close-btn" onclick="window.location.href='home.jsp'">Close</button>
            </div>
        </form>
    </div>
</body>
</html>
