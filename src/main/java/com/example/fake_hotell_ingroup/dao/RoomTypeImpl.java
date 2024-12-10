package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.connection.DatabaseConnection;
import com.example.fake_hotell_ingroup.model.Room;
import com.example.fake_hotell_ingroup.model.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomTypeImpl implements RoomTypeDao{

    private final DatabaseConnection databaseConnection = new DatabaseConnection();


    private static final String SELECT_ALL_ROOMTTYPE = "SELECT * FROM RoomType";
    private static final String SELECT_ROOMTYPE_BY_ID = "SELECT roomTypeName FROM Room WHERE roomTypeId = ?";



    @Override
    public List<RoomType> findAllRoomType() throws SQLException {
        List<RoomType> roomTypes = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMTTYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RoomType roomType = new RoomType(
                        resultSet.getInt("roomTypeId"),
                        resultSet.getString("roomTypeName")
                );
                roomTypes.add(roomType);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return roomTypes;
    }

    @Override
    public RoomType getRoomTypeById(int roomTypeId) throws SQLException {
        RoomType roomType = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROOMTYPE_BY_ID)) {
            statement.setInt(1, roomTypeId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                roomType = new RoomType(
                        rs.getInt("roomTypeId"),
                        rs.getString("roomTypeName")
                );
            }
        }
        return roomType;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
