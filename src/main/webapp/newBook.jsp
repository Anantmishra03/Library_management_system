<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Book</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="form-container">
        <h2>NEW BOOK</h2>
        
        <form action="BookServlet" method="post">
            <input type="text" name="bookId" placeholder="Book ID" required>
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="publisher" placeholder="Publisher" required>
            <input type="text" name="price" placeholder="Price" required>

            <div class="button-group">
                <button type="submit" class="save-btn">Save</button>
                <button type="button" class="close-btn" onclick="window.location.href='home.jsp'">Close</button>
            </div>
        </form>
    </div>
</body>
</html>