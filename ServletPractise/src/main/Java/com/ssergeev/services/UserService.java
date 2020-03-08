package com.ssergeev.services;

import com.ssergeev.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    boolean isLoginExist(String login);

    User getUserByLogin(String login);

}
