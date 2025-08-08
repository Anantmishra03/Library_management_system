package com.library.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Transaction> issueList = new ArrayList<>();
        List<Transaction> returnList = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Updated Driver
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library", "root", "'enter your password'");

            // Fetch issued books
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM issue_book");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                Transaction t = new Transaction();
                t.setStudentId(rs1.getString("student_id"));
                t.setStudentName(rs1.getString("student_name"));
                t.setBookId(rs1.getString("book_id"));
                t.setBookName(rs1.getString("book_name"));
                t.setIssueDate(rs1.getString("issue_date"));
                t.setDueDate(rs1.getString("due_date"));
                issueList.add(t);
            }

            // Fetch returned books
            PreparedStatement ps2 = con.prepareStatement("SELECT * FROM return_book");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                Transaction t = new Transaction();
                t.setStudentId(rs2.getString("student_id"));
                t.setStudentName(rs2.getString("student_name"));
                t.setBookId(rs2.getString("book_id"));
                t.setBookName(rs2.getString("book_name"));
                t.setDueDate(rs2.getString("due_date"));
                t.setReturnDate(rs2.getString("return_date"));
                returnList.add(t);
            }

            con.close();

            request.setAttribute("issueList", issueList);
            request.setAttribute("returnList", returnList);
            request.getRequestDispatcher("statistics.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database Error: " + e.getMessage());
        }
    }
}
