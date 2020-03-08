package com.ssergeev.repository.impl;

import com.ssergeev.entities.Order;
import com.ssergeev.entities.User;
import com.ssergeev.repository.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String SELECT_ALL_ORDERS = "FROM Order";
    private static final String SELECT_USER_ORDERS = "FROM Order o WHERE o.user=:user";
//    private static final String SELECT_LAST_USER_ORDER = "SELECT * FROM Orders WHERE user_id=? ORDER BY id DESC LIMIT 1";

    @Override
    public List<Order> getAllOrders() {
        return entityManager
                .createQuery(SELECT_ALL_ORDERS, Order.class)
                .getResultList();
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return entityManager
                .createQuery(SELECT_USER_ORDERS, Order.class)
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        entityManager.persist(order);
    }

/*    @Override
    public Optional<Order> getLastUserOrder(User user) {

        return Optional.ofNullable(entityManager
                .createNativeQuery(SELECT_LAST_USER_ORDER, Order.class)
                .setParameter(1, user.getId())
                .getSingleResult());
    }*/
}