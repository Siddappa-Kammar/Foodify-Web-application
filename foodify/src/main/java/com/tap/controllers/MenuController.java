package com.tap.controllers;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimpl.MenuDAOimpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MenuController")
public class MenuController extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
	
		MenuDAOimpl Menudao = new MenuDAOimpl();
		List<Menu> menuList = Menudao.getMenuByRestaurantId(restaurantId);

		
		req.setAttribute("allMenu", menuList);
		
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);
			
	}

}
