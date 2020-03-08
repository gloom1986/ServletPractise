package com.ssergeev.repository.impl;

import com.ssergeev.entities.User;
import com.ssergeev.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String SELECT_ALL_USERS = "FROM User";
    private static final String SELECT_USER_BY_LOGIN = "FROM User u WHERE u.login=:login";

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery(SELECT_ALL_USERS, User.class)
                .getResultList();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.ofNullable(entityManager
                .createQuery(SELECT_USER_BY_LOGIN, User.class)
                .getSingleResult()
        );
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

}