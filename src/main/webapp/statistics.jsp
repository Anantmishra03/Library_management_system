<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.library.servlet.Transaction" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Statistics</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Statistics</h1>

    <h2>Issued Books</h2>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Issue Date</th>
            <th>Due Date</th>
        </tr>
        <%
            List<Transaction> issueList = (List<Transaction>) request.getAttribute("issueList");
            if (issueList != null && !issueList.isEmpty()) {
                for (Transaction t : issueList) {
        %>
        <tr>
            <td><%= t.getStudentId() %></td>
            <td><%= t.getStudentName() %></td>
            <td><%= t.getBookId() %></td>
            <td><%= t.getBookName() %></td>
            <td><%= t.getIssueDate() %></td>
            <td><%= t.getDueDate() %></td>
        </tr>
        <% }} else { %>
        <tr><td colspan="6">No issued books found.</td></tr>
        <% } %>
    </table>

    <h2>Returned Books</h2>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Due Date</th>
            <th>Return Date</th>
        </tr>
        <%
            List<Transaction> returnList = (List<Transaction>) request.getAttribute("returnList");
            if (returnList != null && !returnList.isEmpty()) {
                for (Transaction t : returnList) {
        %>
        <tr>
            <td><%= t.getStudentId() %></td>
            <td><%= t.getStudentName() %></td>
            <td><%= t.getBookId() %></td>
            <td><%= t.getBookName() %></td>
            <td><%= t.getDueDate() %></td>
            <td><%= t.getReturnDate() %></td>
        </tr>
        <% }} else { %>
        <tr><td colspan="6">No returned books found.</td></tr>
        <% } %>
    </table>

    <div style="text-align: center; margin-top: 30px;">
        <form action="home.jsp" method="get">
            <button type="submit" class="close-button">Close</button>
        </form>
    </div>
</body>
</html>
