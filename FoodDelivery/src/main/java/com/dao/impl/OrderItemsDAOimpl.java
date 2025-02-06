package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.interfaces.OrderItemsDAO;
import com.dao.model.OrderItems;

public class OrderItemsDAOimpl implements OrderItemsDAO {
    ArrayList<OrderItems> item_list = new ArrayList<OrderItems>();
    private static final String INSERT = "INSERT INTO OrderItems (Order_Id, Menu_id, Quantity, ItemTotal) VALUES (?, ?, ?, ?)";
    private static final String FETCHALL = "SELECT * FROM OrderItems";
    private static final String FETCH = "SELECT * FROM OrderItems WHERE OrderItems_id = ?";
    private static final String UPDATE = "UPDATE OrderItems SET quantity = ? WHERE OrderItems_id = ?";
    private static final String DELETE = "DELETE FROM OrderItems WHERE OrderItems_id = ?";
    
    private Connection con;

    public OrderItemsDAOimpl(Connection con) {
        this.con = con;
    }


    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    private OrderItems i;

    @Override
    public int insert(OrderItems order_item) {
        int orderItemId = 0;  // Variable to hold the generated OrderItems_id
        try {
            pstmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order_item.getOrder_id());
            pstmt.setInt(2, order_item.getMenu_id());
            pstmt.setInt(3, order_item.getQuantity());
            pstmt.setInt(4, order_item.getItem_total());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated OrderItems_id
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderItemId = generatedKeys.getInt(1);  // Get the auto-generated OrderItems_id
                    order_item.setOrderItem_id(orderItemId); // Set the generated OrderItems_id in the object
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
        return orderItemId;
    }

    @Override
    public ArrayList<OrderItems> fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCHALL);
            item_list = gettingOneFromResultset(resultSet);
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
        return item_list;
    }

    private ArrayList<OrderItems> gettingOneFromResultset(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                item_list.add(new OrderItems(
                        resultSet.getInt(1),  // OrderItems_id
                        resultSet.getInt(2),  // Order_Id
                        resultSet.getInt(3),  // Menu_id
                        resultSet.getInt(4),  // Quantity
                        resultSet.getInt(5)   // ItemTotal
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item_list;
    }

    @Override
    public OrderItems fetch(int id) {
        try {
            pstmt = con.prepareStatement(FETCH);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                i = new OrderItems(
                        resultSet.getInt(1),  // OrderItems_id
                        resultSet.getInt(2),  // Order_Id
                        resultSet.getInt(3),  // Menu_id
                        resultSet.getInt(4),  // Quantity
                        resultSet.getInt(5)   // ItemTotal
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
        return i;
    }

    @Override
    public int update(int id, int quantity) {
        try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setInt(1, quantity);
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
