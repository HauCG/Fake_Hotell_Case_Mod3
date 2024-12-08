<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .card-header {
            background-color: #007bff;
            color: white;
            font-size: 1.5rem;
            font-weight: bold;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container my-5">
    <div class="card shadow-lg">
        <div class="card-header text-center">
            Chỉnh Sửa
        </div>
        <div class="card-body">
            <form action="Room" method="post">
                <input type="hidden" name="action" value="editRoom"/>
                <input type="hidden" name="roomId" value="${Room.roomId}"/>

                <div class="mb-3">
                    <label for="roomCode" class="form-label">Ma Phong</label>
                    <input type="text" class="form-control" id="roomCode" name="roomCode" value="${Room.roomCode}" required>
                </div>

                <div class="mb-3">
                    <label for="roomDescription" class="form-label">Mo Ta</label>
                    <input type="text" class="form-control" id="roomDescription" name="roomDescription" value="${Room.roomDescription}" required>
                </div>

                <div class="mb-3">
                    <label for="roomImgLink" class="form-label">Mo Ta</label>
                    <input type="text" class="form-control" id="roomImgLink" name="roomImgLink" value="${Room.roomImgLink}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Thể Loại</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>${Room.roomTypeId}</option>
                        <option value="1">Đơn</option>
                        <option value="2">Đôi</option>
                        <option value="3">VIP</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="roomPrice" class="form-label">Giá Phong</label>
                    <input type="text" class="form-control" id="roomPrice" name="roomPrice"
                           value="<fmt:formatNumber value='${Room.roomPrice}' pattern='###,###,###' />" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Trạng Thái</label>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>${Room.roomStatus}</option>
                        <option value="1">Confirming</option>
                        <option value="2">Available</option>
                        <option value="3">Completed</option>
                        <option value="4">Canceled</option>
                    </select>
                </div>

                <div class="mt-4 text-end">
                    <a href="Room?action=listRoom" class="btn btn-secondary me-2">Quay lại</a>
                    <button type="submit" class="btn btn-custom">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
