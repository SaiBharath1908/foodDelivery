package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.interfaces.UserDAO;
import com.dao.model.User;

public class UserDAOimpl implements UserDAO {
    static ArrayList<User> userList = new ArrayList<User>();
    private Connection con;
    private static final String INSERTQUERY = "INSERT INTO user(username, password, email, address) VALUES (?,?,?,?)";
    private static final String FETCHALL = "SELECT * FROM user";
    private static final String FETCHONE = "SELECT * FROM user WHERE email = ?";
    private static final String UPDATEQUERY = "UPDATE user SET username = ? WHERE user_Id = ?";
    private static final String DELETEQUERY = "DELETE FROM user WHERE user_Id = ?";

    public UserDAOimpl(Connection con) {
        this.con = con;
    }
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;
    private User user;

    @Override
    public int insert(User u) {
        int userId = 0;
        try {
            pstmt = con.prepareStatement(INSERTQUERY, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getAddress());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                ResultSet res = pstmt.getGeneratedKeys();
                if (res.next()) {
                    userId = res.getInt(1); // Get the auto-generated userId
                    u.setUserId(userId); // Set the userId in the User object
                    return userId;
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
        return userId;
    }

    @Override
    public ArrayList<User> fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCHALL);
            userList = gettingOneFromWhole(resultSet);
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
        return userList;
    }

    @Override
    public User fetchOne(String email) {
        try {
            pstmt = con.prepareStatement(FETCHONE);
            pstmt.setString(1, email);
            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt(1),  // Assuming the first column is userId
                        resultSet.getString(2),  // Assuming the second column is username
                        resultSet.getString(3),  // Assuming the third column is password
                        resultSet.getString(4),  // Assuming the fourth column is email
                        resultSet.getString(5)   // Assuming the fifth column is address
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
        return user;
    }

    private ArrayList<User> gettingOneFromWhole(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getInt(1),  // Assuming the first column is userId
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int update(int id, String username) {
        try {
            pstmt = con.prepareStatement(UPDATEQUERY);
            pstmt.setString(1, username);
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
            pstmt = con.prepareStatement(DELETEQUERY);
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
