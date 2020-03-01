package com.ssergeev.services.impl;

import com.ssergeev.entities.User;
import com.ssergeev.repository.UserRepository;
import com.ssergeev.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserByName(String userName){
        return userRepository.getUserByName(userName).orElseThrow(RuntimeException::new);
    }

    @Override
    public void setUser(String userName) {
        userRepository.saveUser(userName);
    }

    @Override
    public boolean isUserNameExist(String userName) {
        return userRepository.getUserByName(userName).isPresent();
    }
}
