package com.ssergeev.repository.impl;

import com.ssergeev.entities.Item;
import com.ssergeev.repository.ItemRepository;
import com.ssergeev.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private static final String SELECT_ALL_ITEMS="FROM Item";

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        itemList = (List<Item>) session.createQuery(SELECT_ALL_ITEMS).getResultList();
        return itemList;
    }
}

/*        try (
            Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ITEMS)
        ){
            itemList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Item item = new Item(id, name, price);
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/