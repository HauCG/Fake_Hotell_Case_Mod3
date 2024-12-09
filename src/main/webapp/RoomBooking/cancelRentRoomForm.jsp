<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xác Nhận Trả Phòng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: hsl(12, 90%, 63%);
            --primary-dark: hsl(12, 32%, 2%);
            --text-light: hsl(0, 0%, 96%);
            --text-dark: hsl(0, 0%, 13%);
            --gray-light: hsl(0, 0%, 70%);
            --shadow-glow: 0 0 20px hsla(12, 100%, 60%, 0.3);
            --neon-blue: #00f3ff;
            --neon-purple: #ff00ff;
        }

        /* Background Animation */
        @keyframes bgMove {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Body Background with Houses */
        body {
            font-family: 'Poppins', sans-serif;
            background:
                    linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
                    url('https://images.unsplash.com/photo-1464082354059-27db6ce50048') center/cover fixed;
            color: var(--text-light);
            min-height: 100vh;
            overflow-x: hidden;
            position: relative;
        }

        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: linear-gradient(45deg,
            rgba(0, 0, 0, 0.8),
            rgba(0, 0, 0, 0.5),
            rgba(0, 0, 0, 0.8));
            animation: bgMove 20s ease infinite;
            z-index: -1;
        }

        /* Main Title Animation */
        .title-wrapper {
            position: relative;
            padding: 20px;
            margin-bottom: 40px;
        }

        .title-wrapper::before,
        .title-wrapper::after {
            content: '';
            position: absolute;
            width: 100px;
            height: 100px;
            border: 3px solid var(--neon-purple);
            animation: borderRotate 4s linear infinite;
        }

        .title-wrapper::before {
            top: 0;
            left: 0;
            border-right: none;
            border-bottom: none;
        }

        .title-wrapper::after {
            bottom: 0;
            right: 0;
            border-left: none;
            border-top: none;
        }

        @keyframes borderRotate {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        h1.text-center {
            font-size: 3.5rem;
            font-weight: 700;
            color: var(--text-light);
            text-transform: uppercase;
            letter-spacing: 4px;
            text-shadow:
                    0 0 10px var(--neon-blue),
                    0 0 20px var(--neon-blue),
                    0 0 30px var(--neon-blue);
            animation: glowText 2s ease-in-out infinite alternate;
        }

        @keyframes glowText {
            from { text-shadow: 0 0 10px var(--neon-blue), 0 0 20px var(--neon-blue); }
            to { text-shadow: 0 0 20px var(--neon-blue), 0 0 30px var(--neon-blue), 0 0 40px var(--neon-blue); }
        }

        /* Enhanced Information Text */
        .info-text {
            font-size: 1.2rem;
            margin: 15px 0;
            padding: 10px;
            border-left: 4px solid var(--primary-color);
            transition: all 0.3s ease;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 0 10px 10px 0;
        }

        .info-text:hover {
            transform: translateX(10px);
            background: rgba(255, 255, 255, 0.2);
        }

        .info-text strong {
            color: var(--neon-purple);
            font-size: 1.3rem;
            font-weight: 600;
            text-shadow: 0 0 10px rgba(255, 0, 255, 0.5);
        }

        /* Enhanced Card Style */
        .card {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 20px;
            overflow: hidden;
            transition: all 0.3s ease;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow:
                    0 0 30px rgba(0, 243, 255, 0.3),
                    0 0 60px rgba(0, 243, 255, 0.1);
        }

        /* Enhanced Button Styles */
        .btn {
            position: relative;
            padding: 15px 30px;
            border: none;
            border-radius: 50px;
            font-weight: 600;
            letter-spacing: 2px;
            text-transform: uppercase;
            overflow: hidden;
            transition: all 0.3s ease;
            margin: 15px;
            z-index: 1;
        }

        .btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(45deg,
            var(--neon-purple),
            var(--neon-blue),
            var(--neon-purple));
            background-size: 200% 200%;
            animation: gradientMove 3s ease infinite;
            z-index: -1;
            transition: all 0.3s ease;
            opacity: 0;
        }

        @keyframes gradientMove {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .btn:hover::before {
            opacity: 1;
        }

        .btn-danger {
            background: var(--primary-color);
            box-shadow: 0 0 20px rgba(255, 0, 0, 0.3);
        }

        .btn-secondary {
            background: var(--gray-light);
            box-shadow: 0 0 20px rgba(128, 128, 128, 0.3);
        }

        .btn:hover {
            transform: translateY(-5px);
            color: white;
            box-shadow:
                    0 0 30px var(--neon-purple),
                    0 0 60px var(--neon-blue);
        }

        /* Price Animation */
        .price-text {
            display: inline-block;
            color: var(--neon-blue);
            font-weight: 700;
            text-shadow: 0 0 10px var(--neon-blue);
            animation: pricePulse 2s infinite alternate;
        }

        @keyframes pricePulse {
            from { transform: scale(1); }
            to { transform: scale(1.1); }
        }

        /* Room Image Enhancement */
        .room-image {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 15px;
            transition: all 0.5s ease;
            filter: brightness(0.9);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
        }

        .room-image:hover {
            transform: scale(1.05);
            filter: brightness(1.2);
            box-shadow:
                    0 0 30px var(--neon-blue),
                    0 0 60px var(--neon-purple);
        }

        /* Responsive Adjustments */
        @media (max-width: 768px) {
            h1.text-center { font-size: 2.5rem; }
            .info-text { font-size: 1rem; }
            .room-image { height: 250px; }
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="title-wrapper">
        <h1 class="text-center mb-4">Xác Nhận Trả Phòng</h1>
    </div>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>

    <div class="card shadow-sm">
        <div class="card-body">
            <h4 class="mb-4">Thông Tin Phòng</h4>
            <div class="row">
                <div class="col-md-6 mb-4">
                    <img src="${param.roomImgLink}"
                         alt="Room Image"
                         class="room-image shadow"
                         onerror="this.src='https://via.placeholder.com/400x300?text=No+Image+Available'">
                </div>
                <div class="col-md-6">
                    <p class="info-text"><strong>Mã đặt phòng:</strong> <span class="ms-2">16</span></p>
                    <p class="info-text"><strong>Khách hàng:</strong> <span class="ms-2">Nguyễn Trung Kiên</span></p>
                    <p class="info-text"><strong>Vị trí:</strong> <span class="ms-2">123 Main Street</span></p>
                    <p class="info-text"><strong>Giá phòng:</strong> <span class="price-text ms-2">$3,000,000</span></p>
                </div>
            </div>

            <hr class="my-4">
            <h5 class="text-center mb-4">Bạn có chắc chắn muốn trả phòng này không?</h5>

            <div class="d-flex justify-content-center gap-3">
                <form action="${pageContext.request.contextPath}/rentRoomForm_Temporary" method="post">
                    <input type="hidden" name="action" value="huy phong">
                    <input type="hidden" name="bookingId" value="${param.bookingId}">
                    <button type="submit" class="btn btn-danger">Xác Nhận</button>
                </form>

                <form action="${pageContext.request.contextPath}/rentRoomForm_Temporary" method="post">
                    <a href="main_roombooking" class="btn btn-secondary">Hủy</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>