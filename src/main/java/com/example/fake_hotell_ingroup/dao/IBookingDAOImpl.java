package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDAOImpl {

    // Thêm mới booking
    boolean addBooking(Booking booking) throws SQLException;

    // Cập nhật trạng thái phòng
    boolean updateRoomStatus(int roomId, String status) throws SQLException;

    // Trả phòng - Cập nhật trạng thái booking và phòng
    boolean returnBooking(int bookingId, int roomId) throws SQLException;

    // Lấy danh sách booking của người dùng
    List<Booking> getBookingsByUserId(int userId) throws SQLException;

    // Lấy thông tin booking theo bookingId
    Booking getBookingById(int bookingId) throws SQLException;

    public List<Booking> getAllBookings() throws SQLException;


    // Lấy danh sách phòng đã được đặt (status = 'rented')
//    List<Room> getRentedRooms() throws SQLException;

}