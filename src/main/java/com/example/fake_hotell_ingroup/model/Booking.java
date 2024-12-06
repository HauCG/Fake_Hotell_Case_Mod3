package com.example.fake_hotell_ingroup.model;

import java.sql.Timestamp;

public class Booking {
    private int bookingId;           // ID của Booking
    private int roomId;              // ID phòng liên kết
    private int userId;              // ID người dùng đặt phòng
    private Timestamp bookingStartDate; // Ngày bắt đầu thuê
    private Timestamp bookingEndDate;   // Ngày kết thúc thuê
    private double totalPrice;       // Tổng tiền thuê
    private String status;           // Trạng thái đặt phòng
    private Timestamp createTime;    // Thời gian tạo booking
    private Timestamp updateTime;    // Thời gian cập nhật booking

    public Booking() {
    }

    public Booking(int bookingId, int roomId, int userId, Timestamp bookingStartDate, Timestamp bookingEndDate,
                   double totalPrice, String status, Timestamp createTime, Timestamp updateTime) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.userId = userId;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Timestamp bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Timestamp getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(Timestamp bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus(String bookingStatus) {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    // Tính tổng tiền thuê (thời gian thuê * giá phòng)
    public void calculateTotalPrice(double roomPrice) {
        if (bookingStartDate != null && bookingEndDate != null) {
            long durationInMillis = bookingEndDate.getTime() - bookingStartDate.getTime();
            long hours = durationInMillis / (1000 * 60 * 60); // Chuyển đổi millisec thành giờ
            this.totalPrice = hours * roomPrice;
        } else {
            throw new IllegalArgumentException("Booking start date or end date is null.");
        }
    }

    // Cập nhật trạng thái phòng về "available" khi trả phòng
    public void returnRoom() {
        this.status = "available";
    }



    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", roomId=" + roomId +
                ", userId=" + userId +
                ", bookingStartDate=" + bookingStartDate +
                ", bookingEndDate=" + bookingEndDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

