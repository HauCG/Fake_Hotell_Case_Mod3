package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDao {
    List<Room> findAllRoom() throws SQLException;

    Room getRoomById(int roomId) throws SQLException;

    int getNextRoomId() throws SQLException;

    void addRoom(Room room) throws SQLException;

    boolean updateRoomttoSQL(Room room) throws SQLException;

    boolean deleteRoom(int roomId) throws SQLException;

    List<Room> searchRoom(String keyword) throws SQLException;
}
