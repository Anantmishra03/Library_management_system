package com.library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String issueDate = request.getParameter("issueDate");
        String dueDate = request.getParameter("dueDate");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library", "root", "'Enter your password'");

            // ✅ 1. Check if student exists
            PreparedStatement studentCheck = con.prepareStatement(
                "SELECT * FROM new_student WHERE student_id = ?");
            studentCheck.setString(1, studentId);
            ResultSet studentRs = studentCheck.executeQuery();

            if (!studentRs.next()) {
                response.getWriter().println("<script>alert('Student does not exist!'); window.history.back();</script>");
                return;
            }

            // ✅ 2. Check if book exists
            PreparedStatement checkBook = con.prepareStatement(
                "SELECT * FROM new_book WHERE book_id = ?");
            checkBook.setString(1, bookId);
            ResultSet checkBookRs = checkBook.executeQuery();

            if (!checkBookRs.next()) {
                response.getWriter().println("<script>alert('Book ID does not exist in the library!'); window.history.back();</script>");
                return;
            }

            // ✅ 3. Check if book is already issued and not returned
            PreparedStatement bookCheck = con.prepareStatement(
                "SELECT * FROM issue_book WHERE book_id = ? AND book_id NOT IN (SELECT book_id FROM return_book)");
            bookCheck.setString(1, bookId);
            ResultSet bookRs = bookCheck.executeQuery();

            if (bookRs.next()) {
                response.getWriter().println("<script>alert('Book is already issued and not yet returned.'); window.history.back();</script>");
                return;
            }

            // ✅ 4. Insert into issue_book
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO issue_book (student_id, student_name, book_id, book_name, issue_date, due_date) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, bookId);
            ps.setString(4, bookName);
            ps.setString(5, issueDate);
            ps.setString(6, dueDate);
            ps.executeUpdate();

            con.close();
            response.sendRedirect("StatisticsServlet");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
