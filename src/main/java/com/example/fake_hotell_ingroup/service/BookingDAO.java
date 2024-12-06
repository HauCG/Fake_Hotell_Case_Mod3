package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {
    private Connection conn;

    public BookingDAO(Connection conn) {
        this.conn = conn;
    }

    // Thêm mới booking
    public boolean addBooking(Booking booking) throws SQLException {
        String sql = "INSERT INTO Booking (RoomId, UserId, BookingStartDate, BookingEndDate, BookingTotalPrice, BookingStatus, BookingCreateTime, BookingUpdateTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, booking.getRoomId());
            ps.setInt(2, booking.getUserId());
            ps.setTimestamp(3, booking.getBookingStartDate());
            ps.setTimestamp(4, booking.getBookingEndDate());
            ps.setDouble(5, booking.getTotalPrice());
            ps.setString(6, "confirming"); // Trạng thái mặc định ban đầu
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Cập nhật trạng thái phòng
    public boolean updateRoomStatus(int roomId, String status) throws SQLException {
        String sql = "UPDATE Room SET RoomStatus = ? WHERE RoomId = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, roomId);
            return ps.executeUpdate() > 0;
        }
    }

    // Trả phòng - Cập nhật trạng thái booking và phòng
    public boolean returnBooking(int bookingId, int roomId) throws SQLException {
        try {
            conn.setAutoCommit(false);
            String updateBookingSql = "UPDATE Booking SET BookingStatus = 'completed', BookingUpdateTime = NOW() WHERE BookingId = ?";
            String updateRoomSql = "UPDATE Room SET RoomStatus = 'available' WHERE RoomId = ?";
            try (PreparedStatement ps1 = conn.prepareStatement(updateBookingSql);
                 PreparedStatement ps2 = conn.prepareStatement(updateRoomSql)) {
                ps1.setInt(1, bookingId);
                ps2.setInt(1, roomId);
                ps1.executeUpdate();
                ps2.executeUpdate();
            }
            conn.commit();
            return true;
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
