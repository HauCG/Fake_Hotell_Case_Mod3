package com.example.fake_hotell.controller;


import com.example.fake_hotell.model.Room;
import com.example.fake_hotell.model.User;
import com.example.fake_hotell.service.RoomService;
import com.example.fake_hotell.service.RoomServiceImpl;
import com.example.fake_hotell.service.UserService;
import com.example.fake_hotell.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// @todo: validate , file ảnh ; xử lý trùng ở đăng ký

@WebServlet(name = "Controller", urlPatterns = "/Fake_Hotell")
public class MainController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String show = request.getParameter("S");
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (show == null) {
            try {
                if (!checkHaveAdmin(request, response)) {
                    show = "adminRegisterPage";
                } else {
                    show = "WelcomePage";
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        switch (show) {
            case "WelcomePage":
                showWelcomePage(request, response);
                break;
            case "adminRegisterPage":
                showAdminRegisterPage(request, response);
                break;
            case "LoginPage":
                showLoginPage(request, response);
                break;
            case "RegisterPage":
                showRegisterPage(request, response);
                break;
            case "CheckEmailRecoveryPage":
                showCheckEmailRecoveryPage(request, response);
                break;
            case "IntroductionPage":
                showIntroductionPage(request, response);
                break;
            case "editUser":
                if (loggedInUser == null) {
                    response.sendRedirect("Fake_Hotell?S=LoginPage");
                    return;
                } else {
                    showEditUserPage(request, response, loggedInUser);
                }
                break;
            case "mainMenu":
                if (loggedInUser == null) {
                    response.sendRedirect("Fake_Hotell?S=LoginPage");
                    return;
                } else {
                    try {
                        showmainMenuPage(request, response, loggedInUser);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            //------------------------------------------------------------------------------------------
            //@todo nhánh của room
            case "viewRoom":
                try {
                    viewRoom(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addRoom":
                showAddRoomForm(request, response);
                break;
            case "editRoom":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteRoom":
                try {
                    deleteRoom(request, response, loggedInUser);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "listRoom":
                try {
                    listRoom(request, response, loggedInUser);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "addRoomv":
                addRoom(request, response, loggedInUser);
                break;
            case "editRoomv":
                editRoom(request, response, loggedInUser);

//                 CÁC PTHUC KHÁC Ở ĐÂY


//                --------------------------------------------------------------------------------
            case "userDetails":
                if (loggedInUser == null) {
                    response.sendRedirect("Fake_Hotell?S=LoginPage");
                    return;
                } else {
                    try {
                        showUserDetails(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

            case "deleteUser":
                if (loggedInUser == null) {
                    response.sendRedirect("Fake_Hotell?S=LoginPage");
                    return;
                } else {
                    try {
                        deleteUserLogic(request, response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
//                --------------------------------------------------------------------------------
            default:
                showNotFoundPage(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("A");
        if (action == null || action.isEmpty()) {
            showNotFoundPage(request, response);
            return;
        }
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");


        switch (action) {
            case "checkRightEmail":
                try {
                    checkRightEmail(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "renewPassword":
                try {
                    renewPassword(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addUser":
                try {
                    addUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "updateUser":
                try {
                    updateUser(request, response);
                } catch (ParseException | SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "login":
                try {
                    loginUser(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "userDetails":
                try {
                    showUserDetails(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "logout":
                logoutUser(request, response);
                break;
            //------------------------------------------------------------------------------------------
            //@todo nhánh của room

            case "addRoom":
                addRoom(request, response, loggedInUser);
                break;
            case "editRoom":
                editRoom(request, response, loggedInUser);
                break;
            // Other cases...
            //-----------------------------------------------------------------------------
            //@todo nhánh của booking
            default:
                showNotFoundPage(request, response);
                break;
        }
    }

    private void showUserDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String userEmail = request.getParameter("UE");
        User user = userService.getUserByEmail(userEmail);
        if (user != null) {
            request.setAttribute("userDetails", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserAccount/UserDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "User not found.");
            request.getRequestDispatcher("/Authentication_View/LoginPage.jsp").forward(request, response);
        }
    }


    private Boolean checkHaveAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        return userService.hasAdmin();
    }

    private void showmainMenuPage(HttpServletRequest request, HttpServletResponse response, User loggedInUser) throws ServletException, IOException, SQLException {
        List<User> users = userService.findAllUsers();
        List<Room> room = roomService.findAllRoom();
        request.setAttribute("room", room);
        request.setAttribute("userInList", users);
        request.setAttribute("user", loggedInUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_View/MainMenuPage.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditUserPage(HttpServletRequest request, HttpServletResponse response, User loggedInUser) throws ServletException, IOException {
        request.setAttribute("user", loggedInUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserAccount/EditUser.jsp");
        dispatcher.forward(request, response);
    }

    private void renewPassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userEmail = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        Boolean changePasswordResult = userService.changePasswordByEmail(newPassword, userEmail);
        if (changePasswordResult) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Authentication_View/LoginPage.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/Main_View/NotFoundPage.jsp");
        }
    }

    private void checkRightEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String userEmail = request.getParameter("email");
        User user = userService.getUserByEmail(userEmail);

        if (user == null) {
            request.setAttribute("errorMessage", "Sai Email. Vui lòng nhập lại!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Authentication_View/CheckEmailRecoveryPage.jsp"); // Forward to the same page
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("email", userEmail);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Authentication_View/RenewPasswordPage.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteUserLogic(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int userId = Integer.parseInt(request.getParameter("ID"));
        userService.deleteUser(userId);
        response.sendRedirect("/Fake_Hotell?S=mainMenu");
    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String userEmail = request.getParameter("UE");
        String userRole = request.getParameter("UR");

        if (userService.getUserByEmail(userEmail) != null) {
            request.setAttribute("errorMessage", "Đã có tài khoản với email này. Vui lòng email khác!");
            if (userRole.equals("customer")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Authentication_View/RegisterPage.jsp");
                dispatcher.forward(request, response);
                return;
            } else if (userRole.equals("admin")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Authentication_View/AdminRegisterPage.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        int userId = userService.getNextUserId();
        String userPassword = request.getParameter("UP");
        String userName = request.getParameter("UN");
        String userBirthDateStr = request.getParameter("UBD");
        String userPhoneNumber = request.getParameter("UPN");
        String userAvatarLink = request.getParameter("UAL");


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthDate;
        try {
            userBirthDate = formatter.parse(userBirthDateStr);
        } catch (ParseException e) {
            throw new ServletException("Error parsing user birth date", e);
        }
        User user = new User(userId, userEmail, userPassword, userName, userBirthDate, userPhoneNumber, userAvatarLink, userRole);
        userService.addUser(user);
        response.sendRedirect("/Authentication_View/LoginPage.jsp");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ParseException, SQLException, IOException, ServletException {
        int userId = Integer.parseInt(request.getParameter("ID"));
        String userEmail = request.getParameter("UE");
        String userPassword = request.getParameter("UP");
        String userName = request.getParameter("UN");
        String userBirthDateStr = request.getParameter("UBD");
        String userPhoneNumber = request.getParameter("UPN");
        String userAvatarLink = request.getParameter("UAL");
        String userRole = request.getParameter("UR");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthDate = formatter.parse(userBirthDateStr);

        User user = new User(userId, userEmail, userPassword, userName, userBirthDate, userPhoneNumber, userAvatarLink, userRole);
        userService.updateUser(user);
        request.getRequestDispatcher("/Fake_Hotell?A=userDetails").forward(request, response);
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userEmail = request.getParameter("UE");
        String userPassword = request.getParameter("UP");

        User user = userService.loginUser(userEmail, userPassword);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);
            response.sendRedirect("/UserAccount/UserInformationView.jsp");
        } else {
            request.setAttribute("errorMessage", "Sai email hoặc mật khẩu. Vui lòng nhập lại!");
            showLoginPage(request, response);
        }
    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
//        response.sendRedirect("/Main_View/WelcomePage.jsp");
        response.sendRedirect("/Main_View/WelcomePage.jsp");
    }

    private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/WelcomePage.jsp").forward(request, response);
    }

    private void showAdminRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/AdminRegisterPage.jsp").forward(request, response);
    }

    private void showNotFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/NotFoundPage.jsp").forward(request, response);
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/LoginPage.jsp").forward(request, response);
    }

    private void showRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/RegisterPage.jsp").forward(request, response);
    }

    private void showCheckEmailRecoveryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/CheckEmailRecoveryPage.jsp").forward(request, response);
    }

    private void showIntroductionPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/IntroductionPage.jsp").forward(request, response);
    }

// room

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response, User loggedInUser) throws SQLException, IOException, ServletException {
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        boolean deleteStatus = roomService.deleteRoom(roomId);
        if (deleteStatus) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_View/MainMenuPage.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Không thể xóa phòng.");
            showmainMenuPage(request, response, loggedInUser);
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

    private void listRoom(HttpServletRequest request, HttpServletResponse response, User loggedInUser) throws ServletException, IOException, SQLException {
        List<User> users = userService.findAllUsers();
        List<Room> room = roomService.findAllRoom();
        request.setAttribute("room", room);
        request.setAttribute("userInList", users);
        request.setAttribute("user", loggedInUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Main_View/MainMenuPage.jsp");
        dispatcher.forward(request, response);
    }

    private void addRoom(HttpServletRequest request, HttpServletResponse response, User loggedInUser  ) throws IOException, ServletException {
        try {
            Integer roomTypeId = Integer.valueOf(request.getParameter("roomTypeId"));
            String roomCode = request.getParameter("roomCode");
            String roomLocation = request.getParameter("roomLocation");
            String roomDescription = request.getParameter("roomDescription");
            String roomImgLink = request.getParameter("roomImgLink");
            double roomPrice = Double.parseDouble(request.getParameter("roomPrice"));

            if (roomCode == null || roomCode.trim().isEmpty() || roomPrice <= 0) {
                request.setAttribute("error", "Invalid room details!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Room/add.jsp");
                dispatcher.forward(request, response);
                return;
            }
            Room room = new Room(roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice);
            roomService.addRoom(room);
            request.setAttribute("user", loggedInUser);
            response.sendRedirect("/Fake_Hotell?S=mainMenu"); // Redirect to main menu after adding
        } catch (NumberFormatException | NullPointerException e) {
            request.setAttribute("error", "Invalid input. Please check your data.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Room/add.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error adding room", e);
        }
    }

    private void editRoom(HttpServletRequest req, HttpServletResponse resp, User loggedInUser  ) throws IOException, ServletException {
        try {
            int roomId = Integer.parseInt(req.getParameter("roomId"));
            int roomTypeId = Integer.parseInt(req.getParameter("roomTypeId"));
            String roomCode = req.getParameter("roomCode");
            String roomLocation = req.getParameter("roomLocation");
            String roomDescription = req.getParameter("roomDescription");
            String roomImgLink = req.getParameter("roomImgLink");
            double roomPrice = Double.parseDouble(req.getParameter("roomPrice"));

            if (roomCode == null || roomCode.trim().isEmpty() || roomPrice <= 0) {
                req.setAttribute("error", "Invalid room details!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("Room/edit.jsp");
                dispatcher.forward(req, resp);
                return;
            }
            Room room = new Room(roomId, roomTypeId, roomCode, roomLocation, roomDescription, roomImgLink, roomPrice);
            roomService.updateRoom(room);
            req.setAttribute("user", loggedInUser);
            resp.sendRedirect("/Fake_Hotell?S=mainMenu");
        } catch (NumberFormatException | NullPointerException e) {
            req.setAttribute("error", "Invalid input. Please check your data.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("Room/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Error updating room", e);
        }
    }


}
