<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/9/2024
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/6/2024
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/6/2024
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký Trang</title>
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
<div class="container mt-5">
    <h1 class="text-center mb-4">Đăng Ký Quản Trị Viên</h1>
    <form action="/Fake_Hotell" method="post">
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null && !errorMessage.isEmpty()) {
        %>
        <div class="alert alert-danger">
            <%= errorMessage %>
        </div>
        <% } %>
        <input type="hidden" name="A" value="addUser">
        <input type="hidden" name="UR" value="admin">
        <div class="mb-3">
            <label for="UE" class="form-label">Email:</label>
            <input type="email" id="UE" name="UE" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="UP" class="form-label">Mật Khẩu Mới:</label>
            <div class="input-group">
                <input type="password" id="UP" name="UP" class="form-control" required>
                <button type="button" class="btn btn-outline-secondary" onclick="togglePassword('UP')">Hiện</button>
            </div>
        </div>
        <div class="mb-3">
            <label for="UN" class="form-label">Tên:</label>
            <input type="text" id="UN" name="UN" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="UBD" class="form-label">Ngày Sinh:</label>
            <input type="date" id="UBD" name="UBD" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="UPN" class="form-label">Số Điện Thoại:</label>
            <input type="text" id="UPN" name="UPN" class="form-control" required>
        </div>
        <div class="mb-3">
            <label for="UAL" class="form-label">Đường Dẫn Đến Ảnh:</label>
            <input type="text" id="UAL" name="UAL" class="form-control">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Gửi Đi</button>
            <a href="Fake_Hotell?S=LoginPage" class="btn btn-secondary">Quay lại trang Login</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function togglePassword(fieldId) {
        var passwordField = document.getElementById(fieldId);
        var type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordField.setAttribute('type', type);
    }
</script>
</body>
</html>
