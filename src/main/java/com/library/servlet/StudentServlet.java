package com.library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form data
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String branch = request.getParameter("branch");

        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library", "root", "Anant@2004");

            // Insert query
            String query = "INSERT INTO new_student (student_id, student_name, course, branch) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentId);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setString(4, branch);

            int result = ps.executeUpdate();

            if (result > 0) {
                // Redirect to home or show success message
                response.sendRedirect("home.jsp");
            } else {
                out.println("❌ Failed to insert student.");
            }

            con.close();

        } catch (Exception e) {
            out.println("⚠ Error: " + e.getMessage());
        }
    }
}
