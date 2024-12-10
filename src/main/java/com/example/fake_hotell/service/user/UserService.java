package com.example.fake_hotell.service.user;

import com.example.fake_hotell.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> findAllUsers() throws SQLException;

    User getUserById(int userId) throws SQLException;

    int getNextUserId() throws SQLException;

    void addUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;

    Boolean hasAdmin() throws SQLException;

    User loginUser(String userEmail, String userPassword) throws SQLException;

    User getUserByEmail(String userEmail) throws SQLException;

    Boolean changePasswordByEmail(String newPassword, String userEmail) throws SQLException;
}
