<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border: none;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-white rounded">
        Chi Tiết Phòng
    </h1>
    <c:choose>
        <c:when test="${not empty Room}">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${products.name}</h5>
                    <p class="card-text"><strong>Mã sản phẩm:</strong> ${products.id}</p>
                    <p class="card-text"><strong>Giá:</strong> <fmt:formatNumber value="${products.price}" type="currency" currencySymbol="₫" /></p>
                    <p class="card-text"><strong>Màu sắc:</strong> ${products.color}</p>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger mt-4" role="alert">
                Không tìm thấy sản phẩm.
            </div>
        </c:otherwise>
    </c:choose>
    <div class="mt-4">
        <a href="products?action=list" class="btn btn-secondary w-100">Quay lại</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
