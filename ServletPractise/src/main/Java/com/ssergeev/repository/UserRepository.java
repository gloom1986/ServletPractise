package com.ssergeev.repository;

import com.ssergeev.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAllUsers();

    Optional<User> getUserByName(String userName);

    void saveUser(String userName);
}
