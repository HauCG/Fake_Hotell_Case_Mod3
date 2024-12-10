<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/09/2024
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%-- Update Room Form --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
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
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            padding: 2rem;
            max-width: 800px;
            margin: auto;
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        h1 {
            text-align: center;
            margin-bottom: 2rem;
            color: white;
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
            box-shadow: 0 5px 15px rgba(46, 204, 113, 0.3);
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
<body>
<div class="page-header">
    <h1><i class="fas fa-edit"></i> Cập Nhật Phòng</h1>
</div>

<div class="container">
      <form action="/Fake_Hotell" method="get" enctype="multipart/form-data">
        <input type="hidden" name="S" value="editRoomv"/>


        <input type="hidden" name="roomId" value="${room.roomId}">

        <div class="mb-3">
            <label for="roomCode" class="form-label">Mã phòng</label>
            <input type="text" class="form-control" id="roomCode" name="roomCode" value="${room.roomCode}" required>
        </div>
        <div class="mb-3">
            <label for="roomLocation" class="form-label">Địa điểm</label>
            <input type="text" class="form-control" id="roomLocation" name="roomLocation" value="${room.roomLocation}"
                   required>
        </div>
        <div class="mb-3">
            <label for="roomTypeId" class="form-label">Loại phòng</label>
            <select class="form-select" id="roomTypeId" name="roomTypeId" value="${room.roomTypeId}" required>
                <option value="1">Đơn</option>
                <option value="2">Đôi</option>
                <option value="3">VIP</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="roomPrice" class="form-label">Giá phòng</label>
            <input type="number" class="form-control" id="roomPrice" name="roomPrice" value="${room.roomPrice}"
                   required>
        </div>
        <div class="mb-3">
            <label for="roomDescription" class="form-label">Mô tả phòng</label>
            <textarea class="form-control" id="roomDescription" name="roomDescription"
                      rows="3">${room.roomDescription}</textarea>
        </div>
        <div class="mb-3">
            <label for="roomImgLink" class="form-label">Link Ảnh</label>
            <input type="text" class="form-control" id="roomImgLink" name="roomImgLink" placeholder="Link ảnh"></input>
        </div>
        <div>

                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                    <a href="/Fake_Hotell?S=mainMenu">Go to Main Menu</a>
        </div>
    </form>
</div>
</div>


</body>
</html>