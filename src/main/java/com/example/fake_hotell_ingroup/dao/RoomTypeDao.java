package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.Room;
import com.example.fake_hotell_ingroup.model.RoomType;

import java.sql.SQLException;
import java.util.List;

public interface RoomTypeDao {
    List<RoomType> findAllRoomType() throws SQLException;

    RoomType getRoomTypeById(int roomId) throws SQLException;

}
