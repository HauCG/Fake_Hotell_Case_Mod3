package com.example.fake_hotell.dao.user;


import com.example.fake_hotell.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> findAllUsers() throws SQLException;

    User getUserById(int userId) throws SQLException;

    void addUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;


    User checkRightRegistration(String userEmail, String userPassword) throws SQLException; // Method to check login credentials

    User getUserByEmail(String email) throws SQLException;

    Boolean changePasswordByEmail(String newPassword, String userEmail) throws SQLException;
}
