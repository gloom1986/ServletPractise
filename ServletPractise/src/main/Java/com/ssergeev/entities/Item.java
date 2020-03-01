package com.ssergeev.entities;

public class Item {

    private int id;
    private String itemName;
    private double itemPrice;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getItemName() {return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName;}

    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public Item(int id, String itemName, double itemPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item() {
    }

    @Override
    public String toString() { return id + " " + itemName + " " + itemPrice + " $"; }
}
