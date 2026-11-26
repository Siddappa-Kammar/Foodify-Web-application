package com.tap.controllers;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get login form data
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validate empty fields
        if (email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            req.setAttribute("error", "Email and password are required.");

            req.getRequestDispatcher("/Login.jsp")
               .forward(req, resp);

            return;
        }

        // Create DAO object
        UserDAOimpl userDAO = new UserDAOimpl();

        // Get user using email
        User user = userDAO.getUserByEmail(email);
        
//        String en_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // Check user and password
//        String en_password = BCrypt.checkpw(password, user.getPassword()));
        
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {

            // Create session
            HttpSession session = req.getSession();

            // Store logged-in user
            session.setAttribute("user", user);

            // Store user id separately if needed later
            session.setAttribute("userId", user.getId());

            // Store user name
            session.setAttribute("userName", user.getName());

            // Store role
            session.setAttribute("role", user.getRole());

            // Login successful
            resp.sendRedirect(req.getContextPath() + "/Restaurant");

        } else {

            // Login failed
            req.setAttribute("error", "Invalid email or password.");

            req.getRequestDispatcher("/Login.jsp")
               .forward(req, resp);
        }
    }
}