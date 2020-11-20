package com.capstone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.capstone.beans.*;

public class ApplicationDao {

    public int registerUser(User user) {
        int rowsAffected = 0;

        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "insert into users (UserName, UserPassword) values (?,?)";

            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPassword());

            rowsAffected = statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }

    public boolean validateUser(String userName, String userPassword) {
        boolean isValidUser = false;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from users where UserName=? and UserPassword=?";

            java.sql.PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, userPassword);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                isValidUser = true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return isValidUser;
    }
    
    public User getUser(int userId) {
        User user = null;
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "select * from users where UserID=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new User();
                user.setUserId (set.getInt("UserID"));
                user.setUserName(set.getString("UserName"));
                user.setUserPassword(set.getString("UserPassword"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }

    public int updateUser(User user) {
        int rowsAffected = 0;

        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "update users set UserName=?, UserPassword=? where UserID=?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPassword());
            statement.setInt(3, user.getUserId());

            rowsAffected = statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        return rowsAffected;
    }
    
    public void deleteUser(int userId) {
        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "delete from users where UserID=?;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public int submitOrder(ArrayList<Integer> products) {
        int rowsAffected = 0;

        try {
            Connection connection = DBConnection.getConnectionToDatabase();

            String sql = "insert into orders (OrderVegetables, OrderBakedGoods, OrderMeats) values (?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            for (int i = 0; i < products.size(); i++) {
                statement.setInt(i + 1, products.get(i));
            }
            
            rowsAffected = statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }
}
