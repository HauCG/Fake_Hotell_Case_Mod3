<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/9/2024
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Tin Người Dùng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "Poppins", sans-serif;
        }

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

        .container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0,0,0,0.2);
            padding: 2rem;
            max-width: 800px;
            margin: auto;
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        h1 {
            text-align: center;
            margin-bottom: 2rem;
            color: #34495e;
            font-size: 3rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 2px;
            text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.3);
        }

        .btn-primary {
            background: linear-gradient(45deg, #3498db, #2ecc71);
            border: none;
            color: white;
            padding: 12px 30px;
            border-radius: 50px;
            font-weight: 600;
            transition: all 0.3s ease;
            box-shadow: 0 5px 15px rgba(52, 152, 219, 0.3);
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(46,204,113,0.3);
        }

        .btn-secondary {
            background: #95a5a6;
            color: white;
            padding: 12px 30px;
            border-radius: 50px;
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s ease;
        }

        .btn-secondary:hover {
            background: #7f8c8d;
            color: white;
        }
    </style>
</head>
<body class="bg-light">
<div class="container mt-5 d-flex justify-content-center">
    <div class="card shadow-sm" style="width: 100%; max-width: 800px;">
        <div class="card-body d-flex flex-column">

            <div class="d-flex align-items-center mb-4">
                <img src="${loggedInUser.userAvatarLink}" alt="Avatar" class="rounded-circle" width="100" height="100">
                <h4 class="ms-3 mb-0">${loggedInUser.userName}</h4>
            </div>

            <div class="card mt-3">
                <div class="card-body">
                    <h5 class="card-title">Chi Tiết Cá Nhân</h5>
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Email:</strong> ${loggedInUser.userEmail}</li>
                        <li class="list-group-item"><strong>Ngày Sinh:</strong> ${loggedInUser.userBirthDate}</li>
                        <li class="list-group-item"><strong>Số Điện Thoại:</strong> ${loggedInUser.userPhoneNumber}</li>
                    </ul>
                </div>
            </div>

            <div class="text-center mt-4">
                <a href="${pageContext.request.contextPath}/Fake_Hotell?S=editUser&ID=${loggedInUser.userId}" class="btn btn-primary">Chỉnh Sửa Thông Tin</a>
                <a href="${pageContext.request.contextPath}/Fake_Hotell?A=logout" class="btn btn-secondary">Đăng Xuất</a>
                <a href="${pageContext.request.contextPath}/Fake_Hotell?S=mainMenu" class="btn btn-secondary">Home Page</a>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
