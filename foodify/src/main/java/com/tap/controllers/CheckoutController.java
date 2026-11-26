package com.tap.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
//import com.sun.jdi.connect.spi.Connection;
import com.tap.model.Cart;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Get cart from session
        Cart cart = (Cart) session.getAttribute("cart");

        // Check whether cart is empty
        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {

            resp.sendRedirect(req.getContextPath() + "/Cart.jsp");
            return;
        }

        // Send cart to checkout page
        req.setAttribute("cart", cart);

        RequestDispatcher rd =
                req.getRequestDispatcher("/Checkout.jsp");

        rd.forward(req, resp);
    }



@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    HttpSession session = req.getSession(false);

    if (session == null || session.getAttribute("userId") == null) {
        resp.sendRedirect(req.getContextPath() + "/Login.jsp");
        return;
    }

    Cart cart = (Cart) session.getAttribute("cart");

    if (cart == null || cart.getItems() == null
            || cart.getItems().isEmpty()) {
        resp.sendRedirect(req.getContextPath() + "/Cart.jsp");
        return;
    }

    String fullName = req.getParameter("fullName");
    String phone = req.getParameter("phone");
    String address = req.getParameter("address");
    String paymentMethod = req.getParameter("paymentMode");

    if (fullName == null || fullName.trim().isEmpty()
            || phone == null || !phone.matches("[0-9]{10}")
            || address == null || address.trim().isEmpty()
            || paymentMethod == null
            || !java.util.Arrays.asList("COD", "UPI", "CARD")
                    .contains(paymentMethod)) {

        resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                "Please provide valid checkout details.");
        return;
    }

    int userId = (Integer) session.getAttribute("userId");
    int restId = cart.getRestId();

    double itemTotal = 0;

    for (com.tap.model.CartItem item : cart.getItems().values()) {
        if (item == null || item.getMenu() == null
                || item.getQuantity() <= 0) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid cart item.");
            return;
        }

        itemTotal += item.getTotalAmount();
    }

    double deliveryFee = 40.0;
    double taxes = 20.0;
    double grandTotal = itemTotal + deliveryFee + taxes;

    Connection connection = null;

    try {
        connection = com.tap.util.DBConnection.getConnection();
        connection.setAutoCommit(false);

        com.tap.DAOimpl.OrderTableDAOimpl orderDAO =
                new com.tap.DAOimpl.OrderTableDAOimpl();

        com.tap.DAOimpl.OrderItemDAOimpl itemDAO =
                new com.tap.DAOimpl.OrderItemDAOimpl();

        com.tap.model.OrderTable order =
                new com.tap.model.OrderTable(
                        userId,
                        restId,
                        grandTotal,
                        "PLACED",
                        paymentMethod
                );

        int orderId = orderDAO.addOrderTable(order, connection);

        for (com.tap.model.CartItem cartItem
                : cart.getItems().values()) {

            com.tap.model.OrderItem orderItem =
                    new com.tap.model.OrderItem(
                            orderId,
                            cartItem.getMenu().getMenuId(),
                            cartItem.getQuantity(),
                            cartItem.getTotalAmount()
                    );

            itemDAO.addOrderItem(orderItem, connection);
        }

        connection.commit();

        session.removeAttribute("cart");
        session.setAttribute("lastOrderId", orderId);

        resp.sendRedirect(
                req.getContextPath() + "/OrderSuccess.jsp");
        return;

    } catch (Exception e) {

        e.printStackTrace();

        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        }

        throw new ServletException(
            "Failed to place order. Check the root cause in the Tomcat console.",
            e
        );


    } finally {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException closeError) {
                closeError.printStackTrace();
            }
        }
    }
}


}