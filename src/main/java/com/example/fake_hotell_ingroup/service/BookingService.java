package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.Booking;
import com.example.fake_hotell_ingroup.dao.BookingDAO;

import java.sql.*;
import java.util.*;

public class BookingService implements BookingServiceImpl {
    private BookingDAO bookingDAO;

    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public boolean createBooking(Booking booking) throws SQLException {
        return bookingDAO.addBooking(booking);
    }

    @Override
    public boolean returnRoom(int bookingId, int roomId) throws SQLException {
        return bookingDAO.returnBooking(bookingId, roomId);
    }

    @Override
    public List<Booking> getAllBookings() throws SQLException {
        return bookingDAO.getAllBookings();
    }

    @Override
    public Booking getBookingById(int bookingId) throws SQLException {
        return bookingDAO.getBookingById(bookingId);
    }
}