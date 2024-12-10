package com.example.fake_hotell.service;

import com.example.fake_hotell.dao.RoomDao;
import com.example.fake_hotell.dao.RoomDaoImpl;
import com.example.fake_hotell.model.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao = new RoomDaoImpl();

    @Override
    public List<Room> findAllRoom() throws SQLException {
        return roomDao.findAllRoom();
    }

    @Override
    public Room getRoomById(int roomId) throws SQLException {
        return roomDao.getRoomById(roomId);
    }

    @Override
    public int getNextRoomId() throws SQLException {
        return roomDao.getNextRoomId();
    }

    @Override
    public void addRoom(Room room) throws SQLException {
        roomDao.addRoom(room);
    }

    @Override
    public void updateRoom(Room room) throws SQLException {
        roomDao.updateRoomttoSQL(room);
    }

    @Override
    public boolean deleteRoom(int roomId) throws SQLException {
        roomDao.deleteRoom(roomId);
        return false;
    }

    @Override
    public List<Room> searchRoom(String keyword) throws SQLException {
        return roomDao.searchRoom(keyword);
    }
}