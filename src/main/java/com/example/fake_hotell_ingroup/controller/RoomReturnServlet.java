package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.dao.RoomDao_Temporary;
import com.example.fake_hotell_ingroup.model.Room_Temporary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnRoom")
public class RoomReturnServlet extends HttpServlet {
    private RoomDao_Temporary roomDao = new RoomDao_Temporary();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String roomCode = request.getParameter("roomCode");

        // Lấy thông tin phòng từ database
        Room_Temporary room = roomDao.getRoomByCode(roomCode);

        if (room != null) {
            // Truyền thông tin phòng vào JSP để xác nhận trả phòng
            request.setAttribute("room", room);
            request.getRequestDispatcher("/returnRoom.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/roomList");
        }
    }
}
