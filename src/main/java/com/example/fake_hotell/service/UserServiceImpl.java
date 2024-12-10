package com.example.fake_hotell.service;

import com.example.fake_hotell.dao.UserDao;
import com.example.fake_hotell.dao.UserDaoImpl;
import com.example.fake_hotell.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAllUsers() throws SQLException {
        return userDao.findAllUsers();
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public Boolean changePasswordByEmail(String newPassword, String userEmail) throws SQLException {
        return userDao.changePasswordByEmail(newPassword, userEmail);
    }

    @Override
    public int getNextUserId() throws SQLException {
        List<User> users = userDao.findAllUsers();
        int maxId = 0; for (User user : users) {
            if (user.getUserId() > maxId) {
                maxId = user.getUserId();
            }
        }
        return maxId + 1;
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userDao.deleteUser(userId);
    }

    @Override
    public Boolean hasAdmin() throws SQLException {
        List<User> users = userDao.findAllUsers();
        for (User user : users) {
            if ("admin".equals(user.getUserRole())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User loginUser(String userEmail, String userPassword) throws SQLException {
        return userDao.checkRightRegistration(userEmail, userPassword);
    }
}
