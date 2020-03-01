package com.ssergeev.entities;

import java.util.List;

public class Order {

    private int id;
    private double totalPrice;
    private User user;
    private List<Item> items;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public List<Item> getItems() {return items;}
    public void setItems(List<Item> items) {this.items = items;}

    public Order(int id, double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return String.valueOf(totalPrice);
    }
}
