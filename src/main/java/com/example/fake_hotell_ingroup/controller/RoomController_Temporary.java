package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.dao.BookingDAO;
import com.example.fake_hotell_ingroup.dao.RoomDao_Temporary;
import com.example.fake_hotell_ingroup.model.Room_Temporary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Controller6", urlPatterns = "/rooms")
public class RoomController_Temporary extends HttpServlet {
    private RoomDao_Temporary roomDAO;



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
        roomDAO = new RoomDao_Temporary(conn);
    }

    // Xử lý yêu cầu GET: Lấy danh sách phòng
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Room_Temporary> rooms = roomDAO.getAllRooms();
            request.setAttribute("rooms", rooms);
            request.getRequestDispatcher("Room_Temporary/listRoom.jsp").forward(request, response);  // Chuyển tiếp tới JSP
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    // Xử lý yêu cầu POST: Thêm phòng mới hoặc cập nhật phòng
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                Room_Temporary room = new Room_Temporary();
                room.setRoomCode(request.getParameter("code"));
                room.setRoomDescription(request.getParameter("description"));
                room.setRoomImgLink(request.getParameter("imgLink"));
                room.setRoomPrice(Double.parseDouble(request.getParameter("price")));
                room.setRoomStatus(request.getParameter("status"));
                roomDAO.addRoom(room);
            } else if ("update".equals(action)) {
                Room_Temporary room = new Room_Temporary();
                room.setRoomId(Integer.parseInt(request.getParameter("id")));
                room.setRoomDescription(request.getParameter("description"));
                room.setRoomImgLink(request.getParameter("imgLink"));
                room.setRoomPrice(Double.parseDouble(request.getParameter("price")));
                room.setRoomStatus(request.getParameter("status"));
                roomDAO.updateRoom(room);
            } else if ("delete".equals(action)) {
                int roomId = Integer.parseInt(request.getParameter("id"));
                roomDAO.deleteRoom(roomId);
            }

            response.sendRedirect("/rooms");  // Redirect về trang danh sách phòng
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
