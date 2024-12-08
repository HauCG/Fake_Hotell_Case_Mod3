<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .card {
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-primary {
            background-color: #28a745;
            border: none;
        }
        .btn-primary:hover {
            background-color: #218838;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
    </style>
</head>
<body class="bg-light">
<div class="container my-5">
    <div class="card">
        <div class="card-header bg-success text-white text-center py-3">
            <h1 class="fw-bold">Thêm Phòng</h1>
        </div>
        <div class="card-body p-4">
            <form action="products" method="post">
                <input type="hidden" name="action" value="addProduct"/>
                <div class="mb-3">
                    <label for="roomCode" class="form-label">Mã Phòng</label>
                    <input type="text" class="form-control" id="roomCode" name="roomCode" required>
                </div>

                <div class="mb-3">
                    <label for="roomDescription" class="form-label">Mô Tả</label>
                    <input type="text" step="0.01" class="form-control" id="roomDescription" name="roomDescription" required>
                </div>

                <div class="mb-3">
                    <label for="roomImgLink" class="form-label">Hình Ảnh</label>
                    <input type="text" class="form-control" id="roomImgLink" name="roomImgLink" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Thể Loại</label>
                    <select class="form-select" aria-label="Default select example">
                        <option value="1">Đơn</option>
                        <option value="2">Đôi</option>
                        <option value="3">VIP</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="roomPrice" class="form-label">Giá Thuê</label>
                    <input type="text" class="form-control" id="roomPrice" name="roomPrice" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Trạng Thái</label>
                    <select class="form-select" aria-label="Default select example">
                        <option value="1">Confirming</option>
                        <option value="2">Available</option>
                        <option value="3">Completed</option>
                        <option value="4">Canceled</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary w-100">Thêm Phòng</button>
            </form>
            <div class="mt-4">
                <a href="Room?action=listRoom" class="btn btn-secondary w-100">Quay lại</a>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById("price").addEventListener("input", formatCurrency);

    function formatCurrency() {
        let inputNumber = document.getElementById("price");
        let onlyNumber = inputNumber.value.split(",").join("").replace(/[^0-9]/g, '');
        inputNumber.value = Number(onlyNumber).toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
