package com.example.fake_hotell_ingroup.model;

import java.sql.Timestamp;

public class Room {
    private int roomId;
    private int roomTypeId;
    private int roomOwner;
    private String roomCode;
    private String roomLocation;
    private String roomDescription;
    private String roomImgLink;
    private double roomPrice;
    private String roomStatus;
    private Timestamp roomCreateDate;
    private Timestamp roomUpdateDate;

    public Room() {
    }

    public Room(int roomId, int roomTypeId, int roomOwner, String roomCode, String roomLocation, String roomDescription, String roomImgLink, double roomPrice, String roomStatus, Timestamp roomCreateDate, Timestamp roomUpdateDate) {
        this.roomId = roomId;
        this.roomTypeId = roomTypeId;
        this.roomOwner = roomOwner;
        this.roomCode = roomCode;
        this.roomLocation = roomLocation;
        this.roomDescription = roomDescription;
        this.roomImgLink = roomImgLink;
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
        this.roomCreateDate = roomCreateDate;
        this.roomUpdateDate = roomUpdateDate;
    }

    public Room(int roomId, String roomCode, String roomDescription, String roomImgLink, String roomTypeId, Double roomPrice, String roomStatus) {
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomDescription = roomDescription;
        this.roomImgLink = roomImgLink;
        this.roomTypeId = Integer.parseInt(roomTypeId);
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(int roomOwner) {
        this.roomOwner = roomOwner;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomImgLink() {
        return roomImgLink;
    }

    public void setRoomImgLink(String roomImgLink) {
        this.roomImgLink = roomImgLink;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Timestamp getRoomCreateDate() {
        return roomCreateDate;
    }

    public void setRoomCreateDate(Timestamp roomCreateDate) {
        this.roomCreateDate = roomCreateDate;
    }

    public Timestamp getRoomUpdateDate() {
        return roomUpdateDate;
    }

    public void setRoomUpdateDate(Timestamp roomUpdateDate) {
        this.roomUpdateDate = roomUpdateDate;
    }
}
