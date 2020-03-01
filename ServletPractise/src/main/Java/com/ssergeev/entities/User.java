package com.ssergeev.entities;

import java.util.List;

public class User {
    private int id;
    private String userName;
    private List<Order> userOrderList;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public List<Order> getUserOrderList() {return userOrderList;}
    public void setUserOrderList(List<Order> userOrderList) {this.userOrderList = userOrderList;}

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return userName;
    }
}
