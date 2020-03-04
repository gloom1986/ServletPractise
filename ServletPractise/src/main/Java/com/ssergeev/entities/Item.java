package com.ssergeev.entities;

import javax.persistence.*;

@Table(name = "Items")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String itemName;

    @Column(name = "price")
    private Double itemPrice;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getItemName() {return itemName;}
    public void setItemName(String itemName) {this.itemName = itemName;}

    public Double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Double itemPrice) {
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
