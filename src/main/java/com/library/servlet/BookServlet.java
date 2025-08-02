package com.library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookId = request.getParameter("bookId");
        String name = request.getParameter("name");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");  // For older MySQL versions
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Use this if using MySQL 8+

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library", "root", "");

            // Insert query
            String query = "INSERT INTO new_book (book_id, book_name, publisher, price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookId);
            ps.setString(2, name);
            ps.setString(3, publisher);
            ps.setDouble(4, Double.parseDouble(price));

            // Execute insert
            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("home.jsp"); // redirect on success
            } else {
                response.getWriter().println("<script>alert('Failed to insert book!'); window.history.back();</script>");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
