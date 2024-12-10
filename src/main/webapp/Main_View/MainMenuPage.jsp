<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">
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
<body>
<div class="page-header">
    <div class="container-fluid">
        <h1 class="text-center mb-0">
            <i class="fas fa-home me-2"></i>
            Menu Chính
        </h1>
    </div>
</div>

<div class="container mt-5">
    <!-- Hiển thị danh sách người dùng nếu user là admin -->
    <c:if test="${user.userRole == 'admin'}">
        <div class="card mt-5">
            <div class="card-header">
                <h2 class="mb-0">Quản Lý Người Dùng (Admin)</h2>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Tên</th>
                            <th>Ngày Sinh</th>
                            <th>Số Điện Thoại</th>
                            <th>Vai Trò</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="userInList" items="${userInList}">
                            <tr>
                                <td>${userInList.userId}</td>
                                <td>${userInList.userEmail}</td>
                                <td>${userInList.userName}</td>
                                <td>${userInList.userBirthDate}</td>
                                <td>${userInList.userPhoneNumber}</td>
                                <td>${userInList.userRole}</td>
                                <td>
                                    <form action="Fake_Hotell" method="get">
                                        <input type="hidden" name="S" value="userDetails">
                                        <input type="hidden" name="UE" value="${userInList.userEmail}">
                                        <button type="submit" class="btn btn-info">Xem</button>
                                    </form>

                                    <form action="Fake_Hotell" method="get" onsubmit="return confirm('Are you sure you want to delete this user?')">
                                        <input type="hidden" name="S" value="deleteUser">
                                        <input type="hidden" name="ID" value="${userInList.userId}">
                                        <button type="submit" class="btn btn-danger">Xóa</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            <i class="fas fa-exclamation-circle me-2"></i>
                ${errorMessage}
        </div>
    </c:if>
    <div class="page-header">
        <div class="container-fluid">
            <h1 class="text-center mb-0">
                <i class="fas fa-hotel me-2"></i>
                Danh sách phòng
            </h1>
        </div>
    </div>
    <div class="card">
        <div class="table-responsive">
            <div>
                <a href="/Fake_Hotell?S=addRoom" class="btn btn-primary mb-3">Thêm phòng</a>
            </div>
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
                                        <a href="Fake_Hotell?S=viewRoom&roomId=${room.roomId}" class="btn btn-info btn-sm me-2">Xem</a>
                                        <a href="Fake_Hotell?S=editRoom&roomId=${room.roomId}" class="btn btn-warning btn-sm me-2">Update</a>
                                        <a href="Fake_Hotell?S=deleteRoom&roomId=${room.roomId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa phòng này không?')">Delete</a>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
