package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    List<Room> findAllRoom() throws SQLException;

    Room getRoomById(int roomId ) throws SQLException;

    int getNextRoomId() throws SQLException;

    void addRoom(Room room) throws SQLException;

    void updateRoom(Room room) throws SQLException;

    boolean deleteRoom(int roomId) throws SQLException;

    List<Room> searchRoom(String keyword) throws SQLException;
}
