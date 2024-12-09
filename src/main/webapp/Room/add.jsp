<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%-- Add Room Form --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Montserrat', sans-serif;
        }

        .page-header {
            /*background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));*/
            color: white;
            padding: 2rem;
            margin-bottom: 2rem;
            border-radius: 0 0 1.5rem 1.5rem;
            text-align: center;
        }

        .form-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 2rem;
            border-radius: 1.5rem;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
            background-color: white;
        }

        .form-label {
            font-weight: 600;
        }

        .btn-submit {
            background-color: #3498db;
            color: white;
            font-weight: 600;
            border: none;
            border-radius: 0.5rem;
            padding: 0.8rem 1.5rem;
            transition: all 0.3s ease;
        }

        .btn-submit:hover {
            background-color: #2980b9;
        }

        .form-control {
            border-radius: 0.5rem;
            padding: 0.8rem;
        }

        .back-link {
            display: inline-block;
            margin-top: 1rem;
            color: #3498db;
            text-decoration: none;
            font-weight: 600;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="page-header">
    <h1><i class="fas fa-plus-circle"></i> Thêm Phòng Mới</h1>
</div>

<div class="form-container">
    <form action="Room" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="addRoom"/>
        <div class="mb-3">
            <label for="roomCode" class="form-label">Mã phòng</label>
            <input type="text" class="form-control" id="roomCode" name="roomCode" placeholder="Nhập mã phòng" required>
        </div>
        <div class="mb-3">
            <label for="roomLocation" class="form-label">Địa điểm</label>
            <input type="text" class="form-control" id="roomLocation" name="roomLocation" placeholder="Nhập địa điểm" required>
        </div>
        <div class="mb-3">
            <label for="roomTypeId" class="form-label">Loại phòng</label>
            <select class="form-select" id="roomTypeId" name="roomTypeId" required>
                <option value="1">Đơn</option>
                <option value="2">Đôi</option>
                <option value="3">VIP</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="roomPrice" class="form-label">Giá phòng</label>
            <input type="number" class="form-control" id="roomPrice" name="roomPrice" placeholder="Nhập giá phòng" required>
        </div>
        <div class="mb-3">
            <label for="roomDescription" class="form-label">Mô tả phòng</label>
            <textarea class="form-control" id="roomDescription" name="roomDescription" rows="3" placeholder="Nhập mô tả"></textarea>
        </div>
        <div class="mb-3">
            <label for="roomImgLink" class="form-label">Hình ảnh</label>
            <input type="file" class="form-control" id="roomImgLink" name="roomImgLink">
        </div>
        <button type="submit" class="btn btn-submit">Thêm phòng</button>
        <a href="Room?action=listRoom" class="back-link">Quay lại danh sách phòng</a>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>

