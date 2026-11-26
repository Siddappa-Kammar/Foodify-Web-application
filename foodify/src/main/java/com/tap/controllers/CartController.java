package com.tap.controllers;

import java.io.IOException;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartController")
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String menuIdParam = req.getParameter("menuId");
        if (menuIdParam == null || menuIdParam.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/Restaurant");
            return;
        }

        int menuId = Integer.parseInt(menuIdParam);

        MenuDAOimpl menuDAO = new MenuDAOimpl();
        Menu menu = menuDAO.getMenu(menuId);

        if (menu == null) {
            resp.sendRedirect(req.getContextPath() + "/Restaurant");
            return;
        }

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // CHECK: Cart exists AND has items from a DIFFERENT restaurant
        if (cart != null && !cart.getItems().isEmpty()
                && cart.getRestId() != menu.getRestId()) {

            session.setAttribute("conflictMenuId", menuId);
            session.setAttribute("conflictRestId", menu.getRestId());
            session.setAttribute("cartConflict", true);

            resp.sendRedirect(req.getContextPath() + "/Cart.jsp");
            return;
        }

        // No conflict — add to cart
        if (cart == null) {
            cart = new Cart();
            cart.setRestId(menu.getRestId());
        }

        CartItem cartItem = cart.getItems().get(menuId);
        if (cartItem == null) {
            cartItem = new CartItem(menu, 1);
            cart.getItems().put(menuId, cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }

        session.setAttribute("cart", cart);

        // Redirect back to Menu page
        resp.sendRedirect(req.getContextPath() + "/MenuController?restaurantId=" + menu.getRestId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String restIdParam = req.getParameter("restId");
        HttpSession session = req.getSession();

        if ("increase".equals(action)) {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                CartItem item = cart.getItems().get(menuId);
                if (item != null) item.setQuantity(item.getQuantity() + 1);
                session.setAttribute("cart", cart);
            }

        } else if ("decrease".equals(action)) {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                CartItem item = cart.getItems().get(menuId);
                if (item != null) {
                    if (item.getQuantity() <= 1) {
                        cart.getItems().remove(menuId);
                    } else {
                        item.setQuantity(item.getQuantity() - 1);
                    }
                }
                session.setAttribute("cart", cart);
            }

        } else if ("remove".equals(action)) {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                cart.getItems().remove(menuId);
                session.setAttribute("cart", cart);
            }

        } else if ("clearAndAdd".equals(action)) {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            MenuDAOimpl menuDAO = new MenuDAOimpl();
            Menu menu = menuDAO.getMenu(menuId);

            if (menu != null) {
                Cart newCart = new Cart();
                newCart.setRestId(menu.getRestId());
                CartItem cartItem = new CartItem(menu, 1);
                newCart.getItems().put(menuId, cartItem);
                session.setAttribute("cart", newCart);

                session.removeAttribute("cartConflict");
                session.removeAttribute("conflictMenuId");
                session.removeAttribute("conflictRestId");
                resp.sendRedirect(req.getContextPath() + "/MenuController?restaurantId=" + menu.getRestId());
                return;
            }

        } else if ("clearCart".equals(action)) {
            session.removeAttribute("cart");
        }

        // Clear conflict flags
        session.removeAttribute("cartConflict");
        session.removeAttribute("conflictMenuId");
        session.removeAttribute("conflictRestId");

        // ✅ If action was triggered from Menu page (restId present), redirect back to Menu page
        if (restIdParam != null && !restIdParam.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/MenuController?restaurantId=" + restIdParam);
        } else {
            resp.sendRedirect(req.getContextPath() + "/Cart.jsp");
        }
    }
}