package com.example.fake_hotell.model;
import java.sql.Timestamp;

public class Room {
    private int roomId;
    private int roomTypeId;
    private String roomCode;
    private String roomLocation;
    private String roomDescription;
    private String roomImgLink;
    private double roomPrice;

    public Room() {
    }

    public Room(int roomId, int roomTypeId, String roomCode, String roomLocation, String roomDescription, String roomImgLink, double roomPrice) {
        this.roomId = roomId;
        this.roomTypeId = roomTypeId;
        this.roomCode = roomCode;
        this.roomLocation = roomLocation;
        this.roomDescription = roomDescription;
        this.roomImgLink = roomImgLink;
        this.roomPrice = roomPrice;
    }

    public Room(Integer roomTypeId, String roomCode, String roomLocation, String roomDescription, String roomImgLink, Double roomPrice) {
        this.roomTypeId = roomTypeId;
        this.roomCode = roomCode;
        this.roomLocation = roomLocation;
        this.roomDescription = roomDescription;
        this.roomImgLink = roomImgLink;
        this.roomPrice = roomPrice;
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
}