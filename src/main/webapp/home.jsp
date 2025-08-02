<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <h1>HOME PAGE</h1>
        <div class="menu">
            <a href="newStudent.jsp" class="card">
                <img src="https://img.icons8.com/ios-filled/100/user-male-circle.png"/>
                <span>New Student</span>
            </a>
            <a href="newBook.jsp" class="card">
                <img src="https://img.icons8.com/ios-filled/100/book.png"/>
                <span>New Book</span>
            </a>
            <a href="issueBook.jsp" class="card">
                <img src="https://img.icons8.com/ios-filled/100/export.png"/>
                <span>Issue Book</span>
           <a href="StatisticsServlet" class="card">
    <img src="https://img.icons8.com/ios-filled/100/combo-chart.png"/>
    <span>Statistics</span>
</a>

            <a href="returnBook.jsp" class="card">
                <img src="https://img.icons8.com/ios-filled/100/import.png"/>
                <span>Return Book</span>
            </a>
            <a href="logout.jsp" class="card">
                <img src="https://img.icons8.com/ios-filled/100/power-off-button.png"/>
                <span>Logout</span>
            </a>
        </div>
    </div>
</body>
</html>