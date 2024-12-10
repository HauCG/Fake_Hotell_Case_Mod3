<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fake Hotell - Đặt Phòng Ngay Hôm Nay</title>

    <!-- Google Fonts - Poppins -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

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

        /* Cập nhật kiểu cho tiêu đề h1 */
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

        /* Căn chỉnh nút */
        .btn-group-custom {
            display: flex;
            justify-content: space-between;
            gap: 1rem;
            margin-bottom: 2rem;
        }

        .btn-group-custom a {
            flex: 1;
            padding: 15px;
            font-size: 1.2rem;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        .btn-group-custom a:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
        }

        .btn-group-custom a:active {
            transform: scale(1);
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        /* Nút Chat hình chữ nhật bo góc */
        .btn-chat {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background-color: #ffc107;
            color: white;
            font-size: 1.2rem;
            padding: 15px 25px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
            transition: all 0.3s ease;
            border: none;
            z-index: 1000;
            border-radius: 15px;  /* Bo góc cho nút */
        }

        /* Hiệu ứng khi hover lên nút chat */
        .btn-chat:hover {
            background-color: #ffb300;
            transform: scale(1.1);
            box-shadow: 0 12px 20px rgba(0, 0, 0, 0.4);
        }

        .btn-chat:active {
            transform: scale(1);
        }

    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Fake Hotell - Đặt Phòng Ngay Hôm Nay</h1>

    <div class="btn-group-custom">
        <a href="Fake_Hotell?S=RegisterPage" class="btn btn-primary">Đăng Ký</a>
        <a href="Fake_Hotell?S=LoginPage" class="btn btn-success">Đăng Nhập</a>
        <a href="Fake_Hotell?S=IntroductionPage" class="btn btn-info">Giới Thiệu</a>
    </div>
</div>

<!-- Nút Chat -->
<a href="https://zalo.me/0966372185" class="btn-chat" target="_blank">
    Chat
</a>

</body>
</html>
