package com.food.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.dbutil.DBConnection;
import com.dao.impl.MenuDAOimpl;
import com.dao.interfaces.MenuDAO;
import com.dao.model.CardItem;
import com.dao.model.Cart;
import com.dao.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class CartServlet
 */
//@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private Connection con;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		if(cart== null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		String action = req.getParameter("action");
		int item_id = Integer.parseInt(req.getParameter("itemId").trim());

		MenuDAO menuDAO = null;
		try {
			con = DBConnection.connect();
			menuDAO = new MenuDAOimpl(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}


		try {
			if(action.equals("add")) {
				Menu menuItem = menuDAO.fetch(item_id);
				if(menuItem != null){
					int quantity = 1;
					CardItem cartItem = new CardItem(
							menuItem.getMenu_id(),
							menuItem.getRestaurant_id(),
							menuItem.getName(),
							quantity,
							menuItem.getPrice()
							);
					cart.addItems(cartItem);
				}
			}
			else if (action.equals("update")) {
	            // Update item quantity logic
	            int quantity = Integer.parseInt(req.getParameter("quantity").trim());
	            cart.update(item_id, quantity);
	        } else if (action.equals("remove")) {
	            // Remove item logic
	            cart.remove(item_id);
	        }


		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("cart", cart);
		resp.sendRedirect("cart.jsp");
	}
}

