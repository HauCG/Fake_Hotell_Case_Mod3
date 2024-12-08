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
    private final RoomServiceImpl roomServiceIml = new RoomServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listRoom":
                try {
                    listRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "viewRoom":
                try {
                    viewRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addRoomForm":
                showAddRoomForm(req, resp);
                break;
            case "editRoomForm":
                try {
                    showEditRoomForm(req, resp);
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
                try {
                    listRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        boolean deleteStatus = roomServiceIml.deleteRoom(roomId);
        String message = deleteStatus ? "Room was deleted successfully" : "Failed to delete Room";
        req.setAttribute("message", message);
        resp.sendRedirect("Room");

    }

    private void showEditRoomForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Room room = roomServiceIml.getRoomById(roomId);
        req.setAttribute("Room", room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showAddRoomForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void viewRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        Room room = roomServiceIml.getRoomById(roomId);
        req.setAttribute("room", room);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/view.jsp");
        dispatcher.forward(req, resp);
    }

    private void listRoom(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Room> rooms = roomServiceIml.findAllRoom();
        req.setAttribute("room", rooms);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Room/list.jsp");
        dispatcher.forward(req, resp);
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
                editRoom(req, resp);
                break;
            default:
                try {
                    listRoom(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void editRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String roomCode = req.getParameter("roomCode");
        String roomDescription = req.getParameter("roomDescription");
        String roomImgLink = req.getParameter("roomImgLink");
        String roomTypeId = req.getParameter("roomTypeId");
        Double roomPrice = Double.valueOf(req.getParameter("roomPrice"));
        String roomStatus = req.getParameter("roomStatus");

        Room room = new Room(roomId, roomCode, roomDescription, roomImgLink, roomTypeId, roomPrice, roomStatus);
        resp.sendRedirect("Room?action=listRoom");
    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String roomCode = req.getParameter("roomCode");
        String roomDescription = req.getParameter("roomDescription");
        String roomImgLink = req.getParameter("roomImgLink");
        String roomTypeId = req.getParameter("roomTypeId");
        Double roomPrice = Double.valueOf(req.getParameter("roomPrice"));
        String roomStatus = req.getParameter("roomStatus");

        Room room = new Room(roomId, roomCode, roomDescription, roomImgLink, roomTypeId, roomPrice, roomStatus);
        roomServiceIml.addRoom(room);
        resp.sendRedirect("Room?action=listRoom");
    }

}
