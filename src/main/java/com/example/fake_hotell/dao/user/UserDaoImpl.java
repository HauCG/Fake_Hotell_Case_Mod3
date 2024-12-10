package com.example.fake_hotell.dao.user;

import com.example.fake_hotell.connection.DatabaseConnection;
import com.example.fake_hotell.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final DatabaseConnection dbc = new DatabaseConnection();
    private final String FIND_ALL_USERS = "SELECT * FROM User";
    private final String GET_USER_BY_ID = "SELECT * FROM User WHERE UserId = ?";
    private final String GET_USER_BY_EMAIL = "SELECT * FROM User WHERE UserEmail = ?";
    private final String ADD_NEW_USER = "INSERT INTO User (UserId, UserEmail, UserPassword, UserName, UserBirthDate, UserPhoneNumber, UserAvatarLink, UserRole) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_USER = "UPDATE User SET UserEmail = ?, UserPassword = ?, UserName = ?, UserBirthDate = ?, UserPhoneNumber = ?, UserAvatarLink = ?, UserRole = ? WHERE UserId = ?";
    private final String DELETE_USER_BY_ID = "DELETE FROM User WHERE UserId = ?";
    private final String CHECK_RIGHT_REGISTRATION = "SELECT * FROM User WHERE UserEmail = ? AND UserPassword = ?";
    private final String UPDATE_USER_PASSWORD_BY_EMAIL = "UPDATE User SET UserPassword = ? WHERE UserEmail = ?";


    @Override
    public List<User> findAllUsers() throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS);
        ResultSet rs = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User(
                    rs.getInt("UserId"),
                    rs.getString("UserEmail"),
                    rs.getString("UserPassword"),
                    rs.getString("UserName"),
                    rs.getDate("UserBirthDate"),
                    rs.getString("UserPhoneNumber"),
                    rs.getString("UserAvatarLink"),
                    rs.getString("UserRole")
            );
            users.add(user);
        }
        return users;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_ID);
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new User(
                    rs.getInt("UserId"),
                    rs.getString("UserEmail"),
                    rs.getString("UserPassword"),
                    rs.getString("UserName"),
                    rs.getDate("UserBirthDate"),
                    rs.getString("UserPhoneNumber"),
                    rs.getString("UserAvatarLink"),
                    rs.getString("UserRole")
            );
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new User(
                    rs.getInt("UserId"),
                    rs.getString("UserEmail"),
                    rs.getString("UserPassword"),
                    rs.getString("UserName"),
                    rs.getDate("UserBirthDate"),
                    rs.getString("UserPhoneNumber"),
                    rs.getString("UserAvatarLink"),
                    rs.getString("UserRole")
            );
        }
        return null;
    }

    @Override
    public Boolean changePasswordByEmail(String newPassword, String userEmail) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PASSWORD_BY_EMAIL);
        statement.setString(1, newPassword);
        statement.setString(2, userEmail);
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }


    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER);
        statement.setInt(1, user.getUserId());
        statement.setString(2, user.getUserEmail());
        statement.setString(3, user.getUserPassword());
        statement.setString(4, user.getUserName());
        statement.setDate(5, new java.sql.Date(user.getUserBirthDate().getTime()));
        statement.setString(6, user.getUserPhoneNumber());
        statement.setString(7, user.getUserAvatarLink());
        statement.setString(8, user.getUserRole());
        statement.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
        statement.setString(1, user.getUserEmail());
        statement.setString(2, user.getUserPassword());
        statement.setString(3, user.getUserName());
        statement.setDate(4, new java.sql.Date(user.getUserBirthDate().getTime()));
        statement.setString(5, user.getUserPhoneNumber());
        statement.setString(6, user.getUserAvatarLink());
        statement.setString(7, user.getUserRole());
        statement.setInt(8, user.getUserId());
        statement.executeUpdate();
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);
        statement.setInt(1, userId);
        statement.executeUpdate();
    }


    @Override
    public User checkRightRegistration(String userEmail, String userPassword) throws SQLException {
        Connection connection = dbc.getConnection();
        PreparedStatement statement = connection.prepareStatement(CHECK_RIGHT_REGISTRATION);
        statement.setString(1, userEmail);
        statement.setString(2, userPassword);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new User(
                    rs.getInt("UserId"),
                    rs.getString("UserEmail"),
                    rs.getString("UserPassword"),
                    rs.getString("UserName"),
                    rs.getDate("UserBirthDate"),
                    rs.getString("UserPhoneNumber"),
                    rs.getString("UserAvatarLink"),
                    rs.getString("UserRole")
            );
        }
        return null;
    }
}
