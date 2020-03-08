package com.ssergeev.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "Orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private Double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> items;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(Double totalPrice) {this.totalPrice = totalPrice;}

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
