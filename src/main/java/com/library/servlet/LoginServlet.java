package com.library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("a");
        String password = request.getParameter("b");

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Use cj for newer versions
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/library", "root", "'Enter your password'"
            );

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, uid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    response.sendRedirect("home.jsp");
                } else {
                    request.setAttribute("error", "Invalid username or password!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Invalid username or password!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
