package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.Booking;

import java.sql.SQLException;
import java.util.List;

public interface BookingServiceImpl {
    boolean createBooking(Booking booking) throws SQLException;
    boolean returnRoom(int bookingId, int roomId) throws SQLException;
    List<Booking> getAllBookings() throws SQLException;
    Booking getBookingById(int bookingId) throws SQLException;
}