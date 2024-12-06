package com.example.fake_hotell_ingroup.dao;


import com.example.fake_hotell_ingroup.model.Room_Temporary;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDao_Temporary {
    private Connection connection;

    public RoomDao_Temporary(Connection connection) {
        this.connection = connection;
    }

    public RoomDao_Temporary() {

    }


    // Phương thức tạo phòng tạm thời
    public void createTemporaryRoom() {
        String sql = "INSERT INTO Room (RoomId, RoomTypeId, RoomOwner, RoomCode, RoomLocation, RoomDescription, "
                + "RoomImgLink, RoomPrice, RoomStatus, RoomCreateDate, RoomUpdateDate) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Gán giá trị cho phòng tạm thời
            stmt.setInt(1, 999); // ID phòng tạm thời (không trùng với dữ liệu hiện tại)
            stmt.setInt(2, 1); // RoomTypeId: 1 - Loại phòng "Đơn"
            stmt.setInt(3, 1); // RoomOwner: 1 - Admin sở hữu
            stmt.setString(4, "TEMP999"); // Mã phòng tạm thời
            stmt.setString(5, "Temporary Location"); // Vị trí tạm thời
            stmt.setString(6, "Phòng tạm thời cho mục đích thử nghiệm"); // Mô tả phòng
            stmt.setString(7, null); // Không có ảnh
            stmt.setDouble(8, 1000000); // Giá thuê tạm thời
            stmt.setString(9, "available"); // Trạng thái phòng: "available"

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Room TEMP999 was created successfully for testing!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Các phương thức khác, ví dụ truy vấn phòng theo mã (RoomCode)
    public Room_Temporary getRoomByCode(String roomCode) {
        String sql = "SELECT * FROM Room WHERE RoomCode = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, roomCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Lấy thông tin phòng từ kết quả truy vấn
                    return new Room_Temporary(

                            rs.getInt("RoomId"),
                            rs.getInt("RoomTypeId"),
                            rs.getInt("RoomOwner"),
                            rs.getString("RoomCode"),
                            rs.getString("RoomLocation"),
                            rs.getString("RoomDescription"),
                            rs.getString("RoomImgLink"),
                            rs.getDouble("RoomPrice"),
                            rs.getString("RoomStatus"),
                            rs.getTimestamp("RoomCreateDate"),
                            rs.getTimestamp("RoomUpdateDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Get all rooms
    public List<Room_Temporary> getAllRooms() throws SQLException {
        String query = "SELECT RoomId, RoomTypeId, RoomOwner, RoomCode, RoomLocation, RoomDescription, " +
                "RoomImgLink, RoomPrice, RoomStatus, RoomCreateDate, RoomUpdateDate " +
                "FROM Room";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            List<Room_Temporary> rooms = new ArrayList<>();

            while (rs.next()) {
                Room_Temporary room = new Room_Temporary();

                // Gán các giá trị từ ResultSet vào đối tượng Room_Temporary
                room.setRoomId(rs.getInt("RoomId"));
                room.setRoomTypeId(rs.getInt("RoomTypeId"));
                room.setRoomOwner(rs.getInt("RoomOwner"));
                room.setRoomCode(rs.getString("RoomCode"));
                room.setRoomLocation(rs.getString("RoomLocation"));
                room.setRoomDescription(rs.getString("RoomDescription"));
                room.setRoomImgLink(rs.getString("RoomImgLink"));
                room.setRoomPrice(rs.getDouble("RoomPrice"));
                room.setRoomStatus(rs.getString("RoomStatus"));
                room.setRoomCreateDate(rs.getTimestamp("RoomCreateDate"));
                room.setRoomUpdateDate(rs.getTimestamp("RoomUpdateDate"));

                // Thêm phòng vào danh sách
                rooms.add(room);
                System.out.println(rooms);
            }

            return rooms;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại SQLException nếu có lỗi
        }
    }


    // Add a new room
    public void addRoom(Room_Temporary room) throws SQLException {
        String query = "INSERT INTO Room (RoomCode, RoomDescription, RoomImgLink, RoomPrice, RoomStatus, RoomCreateDate, RoomUpdateDate) " +
                "VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, room.getRoomCode());
        ps.setString(2, room.getRoomDescription());
        ps.setString(3, room.getRoomImgLink());
        ps.setDouble(4, room.getRoomPrice());
        ps.setString(5, room.getRoomStatus());
        ps.executeUpdate();
    }

    // Update room information
    public void updateRoom(Room_Temporary room) throws SQLException {
        String query = "UPDATE Room SET RoomDescription = ?, RoomImgLink = ?, RoomPrice = ?, RoomStatus = ?, RoomUpdateDate = NOW() WHERE RoomId = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, room.getRoomDescription());
        ps.setString(2, room.getRoomImgLink());
        ps.setDouble(3, room.getRoomPrice());
        ps.setString(4, room.getRoomStatus());
        ps.setInt(5, room.getRoomTypeId());
        ps.executeUpdate();
    }

    // Delete a room
    public void deleteRoom(int roomId) throws SQLException {
        String query = "DELETE FROM Room WHERE RoomId = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, roomId);
        ps.executeUpdate();
    }

}