package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.connection.DatabaseConnection;
import com.example.fake_hotell_ingroup.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    private static final String SELECT_ALL_ROOM = "SELECT * FROM Room";
    private static final String INSERT_ROOM_SQL = "INSERT INTO Room (roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_ROOM_SQL = "DELETE FROM Room WHERE roomId = ?";
    private static final String UPDATE_ROOM_SQL = "UPDATE Room SET roomTypeId = ?, roomCode = ?, roomLocation = ?, roomDescription = ?, roomImgLink = ?, roomPrice = ? WHERE roomId = ?";
    private static final String SELECT_ROOM_BY_ID = "SELECT roomId, roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice FROM Room WHERE roomId = ?";
    private static final String SEARCH_ROOM_SQL = "SELECT * FROM Room WHERE roomCode LIKE ? OR roomLocation LIKE ?";

    @Override
    public List<Room> findAllRoom() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("roomId"),
                        resultSet.getInt("roomTypeId"),
                        resultSet.getString("roomCode"),
                        resultSet.getString("roomLocation"),
                        resultSet.getString("roomDescription"),
                        resultSet.getString("roomImgLink"),
                        resultSet.getDouble("roomPrice")
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) throws SQLException {
        Room room = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROOM_BY_ID)) {
            statement.setInt(1, roomId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                room = new Room(
                        rs.getInt("roomId"),
                        rs.getInt("roomTypeId"),
                        rs.getString("roomCode"),
                        rs.getString("roomLocation"),
                        rs.getString("roomDescription"),
                        rs.getString("roomImgLink"),
                        rs.getDouble("roomPrice")
                );
            }
        }
        return room;
    }

    @Override
    public int getNextRoomId() throws SQLException {
        String query = "SELECT MAX(roomId) AS maxId FROM Room";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("maxId") + 1;
            }
        }
        return 1; // Nếu bảng Room rỗng, bắt đầu từ 1.
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
            preparedStatement.setInt(1, room.getRoomTypeId());
            preparedStatement.setString(2, room.getRoomCode());
            preparedStatement.setString(3, room.getRoomLocation());
            preparedStatement.setString(4, room.getRoomDescription());
            preparedStatement.setString(5, room.getRoomImgLink());
            preparedStatement.setDouble(6, room.getRoomPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateRoomttoSQL(Room room) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL)) {
            statement.setInt(1, room.getRoomTypeId());
            statement.setString(2, room.getRoomCode());
            statement.setString(3, room.getRoomLocation());
            statement.setString(4, room.getRoomDescription());
            statement.setString(5, room.getRoomImgLink());
            statement.setDouble(6, room.getRoomPrice());
            statement.setInt(7, room.getRoomId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteRoom(int roomId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL)) {
            statement.setInt(1, roomId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Room> searchRoom(String keyword) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ROOM_SQL)) {
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("roomId"),
                        resultSet.getInt("roomTypeId"),
                        resultSet.getString("roomCode"),
                        resultSet.getString("roomLocation"),
                        resultSet.getString("roomDescription"),
                        resultSet.getString("roomImgLink"),
                        resultSet.getDouble("roomPrice")
                );
                rooms.add(room);
            }
        }
        return rooms;
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
