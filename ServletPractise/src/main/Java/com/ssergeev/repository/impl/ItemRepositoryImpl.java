package com.ssergeev.repository.impl;

import com.ssergeev.entities.Item;
import com.ssergeev.repository.ItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private static final String SELECT_ALL_ITEMS="FROM Item";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Item> getAllItems() {
        return entityManager.createQuery(SELECT_ALL_ITEMS, Item.class).getResultList();
    }
}