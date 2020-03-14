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
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> userOrderList;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Order> getUserOrderList() {return userOrderList;}
    public void setUserOrderList(List<Order> userOrderList) {this.userOrderList = userOrderList;}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return login + " " + password;
    }
}
