<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/08/2024
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        /* Toàn bộ CSS không thay đổi */
    </style>
</head>
<body>
<div class="page-header">
    <div class="container-fluid">
        <h1 class="text-center mb-0">
            <i class="fas fa-hotel me-2"></i>
            Danh sách phòng
        </h1>
    </div>
</div>

<div class="container-fluid">
    <!-- Hiển thị thông báo lỗi -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            <i class="fas fa-exclamation-circle me-2"></i>
                ${errorMessage}
        </div>
    </c:if>

    <!-- Hiển thị danh sách phòng -->
    <div class="card">
        <div class="table-responsive">
            <a href="Room?action=addRoom" class="btn btn-primary mb-3">Thêm phòng</a>
            <c:choose>
                <c:when test="${not empty room}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th><i class="fas fa-hashtag me-2"></i>Mã phòng</th>
                            <th><i class="fas fa-location-arrow me-2"></i>Địa điểm</th>
                            <th><i class="fas fa-info-circle me-2"></i>Thể loại</th>
                            <th><i class="fas fa-image me-2"></i>Hình ảnh</th>
                            <th><i class="fas fa-tag me-2"></i>Giá</th>
                            <th><i class="fas fa-align-left me-2"></i>Mô tả</th>
                            <th><i class="fas fa-cogs me-2"></i>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="room" items="${room}">
                            <tr>
                                <td><strong>${room.roomCode}</strong></td>
                                <td>${room.roomLocation}</td>
                                <td>${room.roomTypeId}</td>
                                <td><img src="${room.roomImgLink}" class="img-thumbnail" alt="Hình ảnh phòng" style="width: 100px;"></td>
                                <td class="price">${room.roomPrice} VNĐ</td>
                                <td>${room.roomDescription}</td>
                                <td>
                                    <div class="d-flex">
                                        <a href="Room?action=viewRoom&roomId=${room.roomId}" class="btn btn-info btn-sm me-2">Xem</a>
                                        <a href="Room?action=editRoom&roomId=${room.roomId}" class="btn btn-warning btn-sm me-2">Sửa</a>
                                        <a href="Room?action=deleteRoom&roomId=${room.roomId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa phòng này không?')">Xóa</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p class="text-center text-muted">Không có phòng nào để hiển thị.</p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
