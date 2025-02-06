package com.food.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.dbutil.DBConnection;
import com.dao.impl.OrderDAOimpl;
import com.dao.impl.OrderHistoryDAOimpl;
import com.dao.impl.OrderItemsDAOimpl;
import com.dao.interfaces.OrdersDAO;
import com.dao.interfaces.OrderHistoryDAO;
import com.dao.interfaces.OrderItemsDAO;
import com.dao.model.CardItem;
import com.dao.model.Cart;
import com.dao.model.OrderHistory;
import com.dao.model.OrderItems;
import com.dao.model.Orders;
import com.dao.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
    private OrdersDAO orderDAO;
    private OrderItemsDAO orderItemsDAO;
    private OrderHistoryDAO orderhistoryDAO;
	private Connection con;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        // Check if the user is logged in
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            // If user is not logged in, redirect to login page
            resp.sendRedirect("login.jsp");
            return;
        }
        
        
        Cart cart = (Cart) session.getAttribute("cart");
        try {
        	con = DBConnection.connect();
            con.setAutoCommit(false);
            
            orderDAO = new OrderDAOimpl(con);
            orderItemsDAO = new OrderItemsDAOimpl(con);
            orderhistoryDAO = new OrderHistoryDAOimpl(con);
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
         // If the cart is null or empty, redirect to the home page
            if (cart != null && !cart.getItems().isEmpty()) {
                String payment = req.getParameter("paymentmethod");
                Orders order = new Orders();
                order.setUserId(user.getUserId());
                order.setRestaurantId((int)session.getAttribute("restaurantId"));
                order.setPaymentMode(payment);
                order.setStatus("pending");
                
                // Set the order date to the current date and time
                order.setOrder_date(new java.util.Date());  // Set current date and time for the order
                
                double totalAmount = 0;
                for(CardItem item : cart.getItems().values()) {
                    totalAmount += item.getPrice() * item.getQunantity();
                }
                order.setTotalAmount(totalAmount);
                
                // Insert the order into the database
                orderDAO.insert(order);
                
                // Insert order items into the database
                for(CardItem item : cart.getItems().values()) {
                    OrderItems orderItems = new OrderItems();
                    orderItems.setOrder_id(order.getOrderId());
                    orderItems.setMenu_id(item.getMenu_id());
                    orderItems.setQuantity(item.getQunantity());
                    orderItems.setItem_total(item.getPrice() * item.getQunantity());
                    
                    orderItemsDAO.insert(orderItems);
                    
                }
                
                // Insert the order history into the database
                OrderHistory orderhistory = new OrderHistory();
                orderhistory.setOrderId(order.getOrderId());
                orderhistory.setUserId(user.getUserId());
                orderhistory.setTotalAmount(totalAmount);
                orderhistory.setStatus(order.getStatus());
                orderhistory.setOrderDate(new java.sql.Date(order.getOrder_date().getTime()));  // Now this will not throw NullPointerException
                
                orderhistoryDAO.insert(orderhistory);
                con.commit();
                
                // Remove cart from session and store order in session
                session.removeAttribute("cart");
                session.setAttribute("order", order);

                
                // Redirect to the confirmation page
                resp.sendRedirect("confirm.jsp");
            } else {
                // If the cart is null or empty, redirect to the home page
                resp.sendRedirect("home.jsp");
            }
        }
        catch (Exception e) {
        	  try {
                  if (con != null) {
                      con.rollback();
                  }
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
              e.printStackTrace();
          }
          finally {
              try {
                  if (con != null) {
                      con.setAutoCommit(true);
                      con.close();
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
        }
        
    }



