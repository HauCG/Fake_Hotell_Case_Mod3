package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.model.Booking;
import com.example.fake_hotell_ingroup.dao.BookingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "Controller", urlPatterns = "/booking")
public class BookingController extends HttpServlet {
    private BookingDAO bookingDAO;

    @Override
    public void init() throws ServletException {
        Connection conn = null; // Tạo kết nối database, delete sau.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fake_hotell","root","hikkiroku");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        bookingDAO = new BookingDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String action = request.getParameter("action");
        if ("return".equals(action)) {
            int bookingId = Integer.parseInt(request.getParameter("bookingId"));
            int roomId = Integer.parseInt(request.getParameter("roomId"));
            try {
                bookingDAO.returnBooking(bookingId, roomId);
                response.sendRedirect("rooms"); // Chuyển hướng về danh sách phòng
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else {
            request.getRequestDispatcher("Booking_View/bookingForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        Timestamp startDate = Timestamp.valueOf(request.getParameter("startDate"));
        Timestamp endDate = Timestamp.valueOf(request.getParameter("endDate"));
        double roomPrice = Double.parseDouble(request.getParameter("roomPrice"));

        Booking booking = new Booking();
        booking.setRoomId(roomId);
        booking.setUserId(userId);
        booking.setBookingStartDate(startDate);
        booking.setBookingEndDate(endDate);
        booking.calculateTotalPrice(roomPrice);

        try {
            bookingDAO.addBooking(booking);
            bookingDAO.updateRoomStatus(roomId, "rented"); // Đặt phòng thành trạng thái "đã thuê"
            response.sendRedirect("rooms"); // Chuyển hướng về danh sách phòng
        } catch (SQLException e) {

            throw new ServletException(e);
        }
    }
}
