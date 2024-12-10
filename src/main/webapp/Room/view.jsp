<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết phòng</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
  <style>
    body {
      min-height: 100vh;
      padding: 2rem 0;
      background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
      url('https://images.unsplash.com/photo-1564013799919-ab600027ffc6?auto=format&fit=crop&q=80');
      background-size: cover;
      background-position: center;
      background-attachment: fixed;
      background-repeat: no-repeat;
    }

    .card {
      border: none;
      border-radius: 1.5rem;
      box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
      background: white;
      padding: 2rem;
      margin-top: 2rem;
    }

    .btn-back {
      margin-top: 1rem;
      text-transform: uppercase;
      font-weight: 600;
      letter-spacing: 0.5px;
    }

    .room-img {
      max-width: 100%;
      border-radius: 1rem;
      box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
    }

    .room-detail h1 {
      font-size: 2rem;
      font-weight: 700;
      margin-bottom: 1rem;
      color: #2c3e50;
    }

    .room-detail .info {
      font-size: 1.1rem;
      margin-bottom: 0.5rem;
    }

    .room-price {
      font-size: 1.5rem;
      font-weight: 700;
      color: #e74c3c;
      margin-top: 1rem;
    }
  </style>
</head>
<body>
<div class="container">
  <a href="/Fake_Hotell?S=mainMenu">Go to Main Menu</a>
  <div class="card">
    <div class="row">
      <!-- Phần hình ảnh -->
      <div class="col-md-5">
        <img src="${room.roomImgLink}" alt="Hình ảnh phòng" class="room-img">
      </div>
      <!-- Phần thông tin -->
      <div class="col-md-7 room-detail">
        <h1>Thông tin phòng: ${room.roomCode}</h1>
        <p class="info"><strong>Địa điểm:</strong> ${room.roomLocation}</p>
        <p class="info"><strong>Thể loại phòng:</strong> ${room.roomTypeId}</p>
        <p class="info"><strong>Mô tả:</strong> ${room.roomDescription}</p>
        <p class="room-price">Giá: ${room.roomPrice} VNĐ</p>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>