<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="form-container1">
        <h2>RETURN BOOK</h2>
        <form action="ReturnBookServlet" method="post">
            <input type="text" name="bookId" placeholder="Book ID" required>
            <input type="text" name="bookName" placeholder="Book Name" required>

            <input type="text" name="studentId" placeholder="Student ID" required>
            <input type="text" name="studentName" placeholder="Student Name" required>

            <input type="date" name="dueDate" required>
            <input type="date" name="returnDate" required>

            <div class="button-group1">
                <button type="submit" name="action" value="return" class="return-btn1">Return</button>
                <button type="button" class="close-btn1" onclick="window.location.href='home.jsp'">Close</button>
            </div>
        </form>
    </div>
</body>
</html>
