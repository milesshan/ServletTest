package com.capstone.beans;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User(String username, String password) {
        this.userName = username;
        this.userPassword = password;
    }
    
    public User() {
    
    }
    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
