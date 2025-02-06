package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.dao.dbutil.DBConnection;
import com.dao.interfaces.OrderHistoryDAO;
import com.dao.model.OrderHistory;

public class OrderHistoryDAOimpl implements OrderHistoryDAO {
    ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
    private Connection con;
    private static final String INSERT = "INSERT INTO OrderHistory (Order_Id, user_Id, totalAmount, Status, OrderDate) VALUES (?, ?, ?, ?, ?)";
    private static final String FETCH_ALL = "SELECT * FROM OrderHistory";
    private static final String FETCH_ONE = "SELECT * FROM OrderHistory WHERE OrderHistory_Id = ?";
    private static final String UPDATE = "UPDATE OrderHistory SET Status = ? WHERE OrderHistory_Id = ?";
    private static final String DELETE = "DELETE FROM OrderHistory WHERE OrderHistory_Id = ?";
    public OrderHistoryDAOimpl(Connection con) {
        this.con = con;
    }
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    private OrderHistory orderHistory;

    @Override
    public int insert(OrderHistory orderHistory) {
        int orderHistoryId = 0;  // Variable to hold the generated OrderHistory_Id
        try {
            pstmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setInt(2, orderHistory.getUserId());
            pstmt.setDouble(3, orderHistory.getTotalAmount());
            pstmt.setString(4, orderHistory.getStatus());
            pstmt.setDate(5, orderHistory.getOrderDate());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated OrderHistory_Id
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderHistoryId = generatedKeys.getInt(1);  // Get the auto-generated OrderHistory_Id
                    orderHistory.setOrderhistory_id(orderHistoryId);  // Set the generated OrderHistory_Id in the object
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close the resources
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderHistoryId;
    }

    @Override
    public ArrayList<OrderHistory> fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCH_ALL);
            orderHistoryList = gettingOneFromResultSet(resultSet);
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
        return orderHistoryList;
    }

    @Override
    public OrderHistory fetch(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(FETCH_ONE);
            pstmt.setInt(1, orderHistoryId);
            resultSet = pstmt.executeQuery();
            orderHistory = gettingOneFromResultSet(resultSet).get(0);
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
        return orderHistory;
    }

    private ArrayList<OrderHistory> gettingOneFromResultSet(ResultSet resultSet) {
        ArrayList<OrderHistory> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                list.add(new OrderHistory(
                        resultSet.getInt(1),  // OrderHistory_Id
                        resultSet.getInt(2),  // Order_Id
                        resultSet.getInt(3),  // User_Id
                        resultSet.getDouble(4),  // TotalAmount
                        resultSet.getString(5),  // Status
                        resultSet.getDate(6)  // OrderDate
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateStatus(int orderHistoryId, String status) {
        try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setString(1, status);
            pstmt.setInt(2, orderHistoryId);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, orderHistoryId);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
