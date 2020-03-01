package com.ssergeev.services;

import com.ssergeev.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    boolean isUserNameExist(String userName);

    User getUserByName(String userName);

    void setUser(String userName);

}
