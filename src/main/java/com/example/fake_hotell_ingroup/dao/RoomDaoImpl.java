package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.connection.DatabaseConnection;
import com.example.fake_hotell_ingroup.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class RoomDaoImpl implements RoomDao {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    private static final String SELECT_ALL_ROOM = "SELECT * FROM Room";
    private static final String INSERT_ROOM_SQL = "INSERT INTO Room (roomId, roomTypeId,roomOwner,roomCode,roomLocation,roomDescription,roomImgLink,roomPrice,roomStatus,roomCreateDate,roomUpdateDate;) VALUES (?, ?, ?);";
    private static final String DELETE_ROOM_SQL = "delete from Room where roomId = ?;";
    private static final String UPDATE_ROOM_SQL = "update Room set roomCode = ?,roomDescription= ?, roomImgLink =?,roomTypeId =?,roomPrice =?   where roomId = ?;";
    private static final String SELECT_ROOM_BY_ID = "select roomId, roomTypeId,roomOwner,roomCode,roomLocation,roomDescription,roomImgLink,roomPrice,roomStatus,roomCreateDate,roomUpdateDate from room where roomId =?";

    @Override
    public List<Room> findAllRoom() throws SQLException {
        Connection connection = databaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {

                Room room = new Room(resultSet.getInt("roomId"), resultSet.getInt("roomTypeId"), resultSet.getInt("roomOwner"), resultSet.getString("roomCode"), resultSet.getString("roomLocation"), resultSet.getString("roomDescription"), resultSet.getString("roomImgLink"), resultSet.getDouble("roomPrice"), resultSet.getString("roomStatus"), resultSet.getTimestamp("roomCreateDate"), resultSet.getTimestamp("roomUpdateDate"));
                rooms.add(room);
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room getRoomById(int roomId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ROOM_BY_ID);
        statement.setInt(1, roomId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new Room(
                    rs.getInt("roomId"),
                    rs.getInt("roomTypeId"),
                    rs.getInt("roomOwner"),
                    rs.getString("roomCode"),
                    rs.getString("roomLocation"),
                    rs.getString("roomDescription"),
                    rs.getString("roomImgLink"),
                    rs.getDouble("roomPrice"),
                    rs.getString("roomStatus"),
                    rs.getTimestamp("roomCreateDate"),
                    rs.getTimestamp("roomUpdateDate")
            );
        }
        return null;
    }

    @Override
    public int getNextRoomId() throws SQLException {
        return 0;
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        System.out.println(INSERT_ROOM_SQL);
        try (Connection connection = databaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setInt(1, room.getRoomTypeId());
            preparedStatement.setInt(2, room.getRoomOwner());
            preparedStatement.setString(3, room.getRoomCode());
            preparedStatement.setString(4, room.getRoomLocation());
            preparedStatement.setString(5, room.getRoomDescription());
            preparedStatement.setString(6, room.getRoomImgLink());
            preparedStatement.setDouble(7, room.getRoomPrice());
            preparedStatement.setString(8, room.getRoomStatus());
            preparedStatement.setTimestamp(9, room.getRoomCreateDate());
            preparedStatement.setTimestamp(10, room.getRoomUpdateDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateRoom(Room room) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = databaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL);) {
            statement.setInt(1, room.getRoomTypeId());
            statement.setInt(2, room.getRoomOwner());
            statement.setString(3, room.getRoomCode());
            statement.setString(4, room.getRoomLocation());
            statement.setString(5, room.getRoomDescription());
            statement.setString(6, room.getRoomImgLink());
            statement.setDouble(7, room.getRoomPrice());
            statement.setString(8, room.getRoomStatus());
            statement.setTimestamp(9, room.getRoomCreateDate());
            statement.setTimestamp(10, room.getRoomUpdateDate());
            statement.setInt(11, room.getRoomId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteRoom(int roomId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = databaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL);) {
            statement.setInt(1, roomId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Room> searchRoom(String keyword) throws SQLException {
        return Collections.emptyList();
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
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
