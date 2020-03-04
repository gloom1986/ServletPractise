package com.ssergeev.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "Users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column (name = "name", unique = true)
    private String userName;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> userOrderList;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

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
        return userName + " " + password;
    }
}
