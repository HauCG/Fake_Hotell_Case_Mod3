package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.dao.RoomDao_Temporary;
import com.example.fake_hotell_ingroup.model.Room_Temporary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




    @WebServlet("/rentRoomForm")

    public class RentRoomFormServlet_Temporary extends HttpServlet {
        private RoomDao_Temporary roomDao = new RoomDao_Temporary();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String roomCode = request.getParameter("roomCode");

            // Tìm thông tin phòng từ roomCode (ví dụ lấy từ database)
            Room_Temporary room = roomDao.getRoomByCode(roomCode); // RoomDAO là class quản lý database

            if (room != null) {
                request.setAttribute("room", room);

                // Truyền thời gian hiện tại cho JSP
                String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
                request.setAttribute("currentDateTime", currentDateTime);

                // Chuyển hướng tới trang JSP "Cho Thuê Phòng"
                request.getRequestDispatcher("/rentRoom.jsp").forward(request, response);
            } else {
                // Nếu không tìm thấy phòng, trả về trang lỗi hoặc danh sách phòng
                response.sendRedirect(request.getContextPath() + "/roomList");
            }
        }


    }