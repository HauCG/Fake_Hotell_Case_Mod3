package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.model.Room;
import com.example.fake_hotell_ingroup.service.RoomService;
import com.example.fake_hotell_ingroup.service.RoomServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RoomController", urlPatterns = "/Room")
public class RoomController extends HttpServlet {
    private final RoomService roomService = new RoomServiceImpl();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "viewRoom":
                try {
                    viewRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addRoom":
                showAddRoomForm(req, resp);
                break;
            case "editRoom":
                try {
                    showEditForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteRoom":
                try {
                    deleteRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listRoom(req, resp);
                break;
        }
    }

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        boolean deleteStatus = roomService.deleteRoom(roomId);
        if (deleteStatus) {
            resp.sendRedirect("Room?action=listRoom");
        } else {
            req.setAttribute("error", "Không thể xóa phòng.");
            listRoom(req, resp);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Room room = roomService.getRoomById(roomId);
        req.setAttribute("room", room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showAddRoomForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void viewRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Room room = roomService.getRoomById(roomId);
        req.setAttribute("room", room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/view.jsp");
        dispatcher.forward(req, resp);
    }

    private void listRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Room> room = roomService.findAllRoom();
            req.setAttribute("room", room);
            RequestDispatcher dispatcher = req.getRequestDispatcher("Room/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace(); // Ghi log lỗi chi tiết
            req.setAttribute("error", "Cannot retrieve the room list.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addRoom":
                try {
                    addRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editRoom":
                try {
                    editRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listRoom(req, resp);
                break;
        }
    }

    private void editRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Integer roomTypeId = Integer.valueOf(req.getParameter("roomTypeId"));
        String roomCode = req.getParameter("roomCode");
        String roomLocation = req.getParameter("roomLocation");
        String roomDescription = req.getParameter("roomDescription");
        String roomImgLink = req.getParameter("roomImgLink");
        Double roomPrice = Double.valueOf(req.getParameter("roomPrice"));

        Room room = new Room(roomId, roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice);
        roomService.updateRoom(room); // Gọi phương thức update từ RoomService
        resp.sendRedirect("Room?action=roomId");

    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Integer roomTypeId = Integer.valueOf(req.getParameter("roomTypeId"));
        String roomCode = req.getParameter("roomCode");
        String roomLocation = req.getParameter("roomLocation");
        String roomDescription = req.getParameter("roomDescription");
        String roomImgLink = req.getParameter("roomImgLink");
        Double roomPrice = Double.valueOf(req.getParameter("roomPrice"));


        Room room = new Room(roomId, roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice);
        roomService.addRoom(room);
        resp.sendRedirect("Room?action=listRoom");
    }

}