package com.library.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String dueDate = request.getParameter("dueDate");
        String returnDate = request.getParameter("returnDate");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library", "root", "'Enter your password'");

            // ✅ 1. Check if the book is actually issued
            String checkIssuedQuery = "SELECT * FROM issue_book WHERE book_id = ? AND student_id = ?";
            PreparedStatement checkIssued = con.prepareStatement(checkIssuedQuery);
            checkIssued.setString(1, bookId);
            checkIssued.setString(2, studentId);
            ResultSet rs = checkIssued.executeQuery();

            if (rs.next()) {
                // ✅ 2. Insert return record
                String insertReturn = "INSERT INTO return_book (student_id, student_name, book_id, book_name, due_date, return_date) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(insertReturn);
                ps.setString(1, studentId);
                ps.setString(2, studentName);
                ps.setString(3, bookId);
                ps.setString(4, bookName);
                ps.setString(5, dueDate);
                ps.setString(6, returnDate);
                ps.executeUpdate();

                // ✅ 3. Remove from issue_book
                String deleteIssued = "DELETE FROM issue_book WHERE book_id = ? AND student_id = ?";
                PreparedStatement del = con.prepareStatement(deleteIssued);
                del.setString(1, bookId);
                del.setString(2, studentId);
                del.executeUpdate();

                con.close();
                response.sendRedirect("StatisticsServlet");
            } else {
                con.close();
                response.getWriter().println("<script>alert('No issued book found for this student.'); window.location='returnBook.jsp';</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
