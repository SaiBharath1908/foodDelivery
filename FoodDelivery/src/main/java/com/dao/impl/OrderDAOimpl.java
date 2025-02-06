package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.interfaces.OrdersDAO;
import com.dao.model.Orders;

public class OrderDAOimpl implements OrdersDAO {
    private Connection con;
    ArrayList<Orders> order_list = new ArrayList<Orders>();
    private static final String INSERTQUERY = "INSERT INTO orders (user_Id, restaurant_id, TotalAmount, Status, paymentMode) VALUES (?, ?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM Orders";
    private static final String FETCH = "SELECT * FROM Orders WHERE Restaurant_id = ?";
    private static final String UPDATE = "UPDATE orders SET Status = ? WHERE Order_Id = ?";
    private static final String DELETE = "DELETE FROM orders WHERE Restaurant_id = ?";

    public OrderDAOimpl(Connection con) {
        this.con = con;
    }

    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    private Orders o;

    @Override
    public int insert(Orders o) {
        int orderId = 0;
        try {
            // Prepare the insert query with the return of generated keys
            pstmt = con.prepareStatement(INSERTQUERY, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, o.getUserId());
            pstmt.setInt(2, o.getRestaurantId());
            pstmt.setDouble(3, o.getTotalAmount());
            pstmt.setString(4, o.getStatus());
            pstmt.setString(5, o.getPaymentMode());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Get the generated order ID
                ResultSet res = pstmt.getGeneratedKeys();
                if (res.next()) {
                    orderId = res.getInt(1); // Get the auto-generated orderId
                    o.setOrderId(orderId);  // Set the generated orderId to the Order object

                    // Optional: Fetch and set the order date for the newly created order
                    pstmt = con.prepareStatement("SELECT order_date FROM orders WHERE order_id = ?");
                    pstmt.setInt(1, orderId);
                    ResultSet orderDateResult = pstmt.executeQuery();
                    if (orderDateResult.next()) {
                        o.setOrder_date(orderDateResult.getTimestamp("order_date")); // Set the order date
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            // Always close the resources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderId;
    }

    @Override
    public ArrayList<Orders> fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCHALL);
            order_list = gettingOneFromResultset(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close the resources
            try {
                if (stmt != null) stmt.close();
                if (resultSet != null) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order_list;
    }

    @Override
    public Orders fetch(int id) {
        try {
            pstmt = con.prepareStatement(FETCH);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                o = new Orders(
                        resultSet.getInt(1),  // orderId
                        resultSet.getInt(2),  // userId
                        resultSet.getInt(3),  // restaurantId
                        resultSet.getDouble(4), // TotalAmount
                        resultSet.getString(5),  // Status
                        resultSet.getString(6),  // paymentMode
                        resultSet.getTimestamp(7)  // orderDate
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (resultSet != null) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return o;
    }

    private ArrayList<Orders> gettingOneFromResultset(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                order_list.add(new Orders(
                        resultSet.getInt(1), // orderId
                        resultSet.getInt(2), // userId
                        resultSet.getInt(3), // restaurantId
                        resultSet.getDouble(4), // TotalAmount
                        resultSet.getString(5), // Status
                        resultSet.getString(6), // paymentMode
                        resultSet.getTimestamp(7) // orderDate
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order_list;
    }

    @Override
    public int update(int id, String status) {
        try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            // Always close the resources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int delete(int id) {
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            // Always close the resources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
