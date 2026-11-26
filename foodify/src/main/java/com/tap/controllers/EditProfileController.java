package com.tap.controllers;

import java.io.IOException;

import com.tap.DAOimpl.UserDAOimpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EditProfileController")
public class EditProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect(req.getContextPath() + "/Login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        if (name == null || name.trim().isEmpty() ||
            phone == null || !phone.trim().matches("[0-9]{10}") ||
            address == null || address.trim().isEmpty()) {

            session.setAttribute("profileError", "Please fill in all fields with a valid 10-digit phone number.");
            resp.sendRedirect(req.getContextPath() + "/ProfileController");
            return;
        }

        UserDAOimpl userDAO = new UserDAOimpl();
        User user = userDAO.getUser(userId);

        if (user != null) {
            user.setName(name.trim());
            user.setPhone(phone.trim());
            user.setAddress(address.trim());

            userDAO.updateUser(user);

            // Update session values so navbar reflects new name immediately
            session.setAttribute("userName", user.getName());
            session.setAttribute("user", user);

            session.setAttribute("profileSuccess", "Profile updated successfully!");
        }

        resp.sendRedirect(req.getContextPath() + "/ProfileController");
    }
}