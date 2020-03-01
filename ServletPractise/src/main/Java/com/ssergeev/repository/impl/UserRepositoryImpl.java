package com.ssergeev.repository.impl;

import com.ssergeev.entities.User;
import com.ssergeev.repository.UserRepository;
import com.ssergeev.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SELECT_ALL_USERS = "FROM User";
    private static final String SELECT_USER = "FROM User u WHERE u.login=:login";
    private static final String INSERT_USER = "INSERT INTO Users VALUES (?)";

    @Override
    public List<User> getAllUsers() {
        List<User> userList = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        userList = (List<User>) session.createQuery(SELECT_ALL_USERS).getResultList();
        return userList;
    }

    @Override
    public Optional<User> getUserByName(String userName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        User user = (User) session.createQuery(SELECT_USER).setParameter("login", userName).getSingleResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void saveUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.createSQLQuery(INSERT_USER).setParameter(1, userName).executeUpdate();
    }

}

    /*        try (
            Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS)
        ){
            userList = new ArrayList<>();
            while(resultSet.next()) {
                int receivedId = resultSet.getInt("id");
                String receivedUserName = resultSet.getString("login");
                user = new User(receivedId, receivedUserName);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    // -----------------------------------------------------------------------------

        /*        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)
        ){
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int receivedId = resultSet.getInt("id");
                String receivedUserName = resultSet.getString("login");
                user = new User(receivedId, receivedUserName);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        // -----------------------------------------------------------------------------

        /*        try (
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)
        ){
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/