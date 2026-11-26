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

@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        // LoginController sets "userId" as Integer — match exactly
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/Login.jsp");
            return;
        }

        
        int userId = (Integer) session.getAttribute("userId");
        UserDAOimpl userDAO = new UserDAOimpl();
        User user = userDAO.getUser(userId);   // matches your DAOimpl method name

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/Login.jsp");
            return;
        }

        request.setAttribute("profileUser", user);
        request.getRequestDispatcher("/Profile.jsp").forward(request, response);
    }
}