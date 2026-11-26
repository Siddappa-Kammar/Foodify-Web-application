package com.tap.controllers;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.RestaurantDAOimpl;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Restaurant")
public class RestaurantController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		RestaurantDAOimpl restaurantDAO = new RestaurantDAOimpl();
		List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurant();  
		
		req.setAttribute("restaurant", allRestaurants);
		
		RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
		rd.forward(req, resp);
	}

}
