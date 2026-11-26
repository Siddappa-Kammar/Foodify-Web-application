
package com.tap.controllers;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tap.DAOimpl.OrderItemDAOimpl;
import com.tap.DAOimpl.OrderTableDAOimpl;
import com.tap.model.OrderItem;
import com.tap.model.OrderTable;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrdersController")
public class OrdersController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp)
	        throws ServletException, IOException {
	
	    HttpSession session = req.getSession(false);
	
	    if (session == null || session.getAttribute("userId") == null) {
	        resp.sendRedirect(req.getContextPath() + "/Login.jsp");
	        return;
	    }
	
	    int userId = (Integer) session.getAttribute("userId");
	
	    try {
	        OrderTableDAOimpl orderDAO = new OrderTableDAOimpl();
	        OrderItemDAOimpl itemDAO = new OrderItemDAOimpl();
	
	        List<OrderTable> orders = orderDAO.getOrdersByUserId(userId);
	
	        System.out.println("Logged-in user ID: " + userId);
	        System.out.println("Orders found: " + orders.size());
	
	        Map<Integer, List<OrderItem>> orderItemsMap = new HashMap<>();
	
	        for (OrderTable order : orders) {
	            List<OrderItem> items =
	                    itemDAO.getOrderItemsByOrderId(order.getOrderId());
	
	            orderItemsMap.put(order.getOrderId(), items);
	
	            System.out.println("Order ID: " + order.getOrderId()
	                    + ", items found: " + items.size());
	        }
	
	        req.setAttribute("orders", orders);
	        req.setAttribute("orderItemsMap", orderItemsMap);
	
	        req.getRequestDispatcher("/Orders.jsp").forward(req, resp);
	
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ServletException("Failed to load orders", e);
	    }
	}

}
