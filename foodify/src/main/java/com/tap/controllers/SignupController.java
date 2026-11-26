
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

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

//    private static final long serialVersionUID = 1L;

    private UserDAOimpl userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAOimpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        if (isBlank(name) || isBlank(email) || isBlank(password)
                || isBlank(confirmPassword) || isBlank(phone)
                || isBlank(address)) {
            showError(req, resp, "Please fill in all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError(req, resp, "Passwords do not match.");
            return;
        }

        if (password.length() < 8) {
            showError(req, resp,
                    "Password must contain at least 8 characters.");
            return;
        }

        if (!phone.trim().matches("[0-9]{10}")) {
            showError(req, resp,
                    "Enter a valid 10-digit phone number.");
            return;
        }

        try {
            email = email.trim();

            // Check whether this email is already registered
            if (userDAO.getUserByEmail(email) != null) {
                showError(req, resp,
                        "This email is already registered. Please log in.");
                return;
            }

            // Create the new user
            User newUser = new User();
            newUser.setName(name.trim());
            newUser.setEmail(email);
            
            String en_password = BCrypt.hashpw(password, BCrypt.gensalt());
            
            newUser.setPassword(en_password);
            newUser.setPhone(phone.trim());
            newUser.setAddress(address.trim());
            newUser.setRole("Customer");

            // Save the user to MySQL
            userDAO.addUser(newUser);

            // Fetch the inserted record, including its database ID
            User savedUser = userDAO.getUserByEmail(email);

            if (savedUser == null) {
                req.setAttribute("errorMessage",
                    "Registration was saved, but the user could not be retrieved.");
                req.getRequestDispatcher("/Signup.jsp").forward(req, resp);
                return;
            }

            // Automatically log the new user in
            HttpSession session = req.getSession(true);
            session.setAttribute("user", savedUser);
            session.setAttribute("userId", savedUser.getId());
            session.setAttribute("userName", savedUser.getName());
            session.setAttribute("role", savedUser.getRole());

            // Redirect to the restaurant page
            resp.sendRedirect(
                    req.getContextPath() + "/Restaurant");

        } catch (RuntimeException e) {
            e.printStackTrace();
            showError(req, resp,
                    "Unable to register. Check the server console for the database error.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private void showError(HttpServletRequest req,
                           HttpServletResponse resp,
                           String message)
            throws ServletException, IOException {

        req.setAttribute("errorMessage", message);
        req.getRequestDispatcher("/Signup.jsp").forward(req, resp);
    }
}
