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
    public User getUserByLogin(String login){
        return userRepository
                .getUserByLogin(login)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public boolean isLoginExist(String login) {
        return userRepository
                .getUserByLogin(login)
                .isPresent();
    }
}
