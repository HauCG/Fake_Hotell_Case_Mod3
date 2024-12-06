<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 12/6/2024
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác nhận trả phòng</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Xác nhận trả phòng</h1>

    <p>Bạn có chắc chắn muốn trả phòng này không?</p>

    <!-- Hiển thị thông tin phòng -->
    <table class="table">
        <tr>
            <th>Mã phòng</th>
            <td>${room.roomCode}</td>
        </tr>
        <tr>
            <th>Mô tả phòng</th>
            <td>${room.roomDescription}</td>
        </tr>
        <tr>
            <th>Giá phòng</th>
            <td>${room.roomPrice}</td>
        </tr>
        <tr>
            <th>Ngày thuê</th>
            <td>${room.rentalDate}</td>
        </tr>
    </table>

    <!-- Form xác nhận trả phòng -->
    <form action="${pageContext.request.contextPath}/returnRoom" method="POST">
        <input type="hidden" name="roomCode" value="${room.roomCode}">
        <button type="submit" class="btn btn-danger">Xác nhận trả phòng</button>
    </form>

    <a href="${pageContext.request.contextPath}/roomList" class="btn btn-secondary">Quay lại danh sách phòng</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
