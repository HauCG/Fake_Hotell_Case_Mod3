<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hủy Phòng Thành Công</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700" rel="stylesheet">
    <style>
        :root {
            --white: #FCFCFC;
            --gray: #CBCDD3;
            --dark: #777777;
            --danger: #FF6F61;
            --secondary: #FFA69E;
        }

        html, body {
            min-height: 100%;
            font-family: 'Lato', sans-serif;
            background: linear-gradient(135deg, #fdfbfb 0%, #ebedee 100%);
            overflow-x: hidden;
        }

        .container {
            position: relative;
            max-width: 1000px;
            margin: 50px auto;
        }

        .booking-cancelled {
            background: linear-gradient(to bottom right, var(--danger) 40%, var(--secondary) 100%);
            border-radius: 20px;
            padding: 2.5rem;
            box-shadow: 0 15px 30px rgba(0,0,0,0.15);
            position: relative;
            overflow: hidden;
            transform: translateY(30px);
            opacity: 0;
            animation: slideUp 0.8s ease-out forwards;
        }

        .cancel-icon {
            position: relative;
            width: 80px;
            height: 80px;
            border-radius: 50%;
            background: white;
            margin: 0 auto 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 2rem;
            font-weight: 700;
            color: var(--danger);
            animation: bounce 1s ease-in infinite;
        }

        .alert-heading {
            font-size: 2.2rem;
            font-weight: 700;
            color: white;
            text-transform: uppercase;
            margin: 1.5rem 0;
            padding: 0.5rem 1rem;
            border: 3px solid white;
            display: inline-block;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            text-shadow: 2px 2px 4px rgba(0,0,0,0.1);
            letter-spacing: 1px;
        }

        .text-white {
            font-size: 1.2rem;
            font-weight: 500;
            margin-bottom: 2rem;
        }

        .booking-details {
            background: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            padding: 2rem;
            margin-top: 2rem;
            transform: translateY(20px);
            opacity: 0;
            animation: slideUp 0.8s ease-out 0.3s forwards;
        }

        .info-item {
            margin: 15px 0;
            padding: 15px;
            border-radius: 12px;
            background: rgba(255,255,255,0.7);
            transform: translateX(-50px);
            opacity: 0;
            animation: slideRight 0.5s ease-out forwards;
            font-size: 1.1rem;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }

        .info-item strong {
            font-weight: 700;
            color: #444;
            margin-right: 10px;
        }

        .info-item:nth-child(1) { animation-delay: 0.4s; }
        .info-item:nth-child(2) { animation-delay: 0.6s; }

        .btn-return {
            background: white;
            border: none;
            padding: 15px 35px;
            border-radius: 50px;
            font-weight: 700;
            font-size: 1.1rem;
            letter-spacing: 1.5px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            transition: all 0.3s ease;
            transform: translateY(20px);
            opacity: 0;
            animation: slideUp 0.8s ease-out 1.2s forwards;
            text-transform: uppercase;
        }

        .btn-return:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
            background: var(--secondary);
            color: white;
        }

        @keyframes bounce {
            50% { transform: translateY(-10px); }
        }

        @keyframes slideUp {
            from {
                transform: translateY(30px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes slideRight {
            from {
                transform: translateX(-50px);
                opacity: 0;
            }
            to {
                transform: translateX(0);
                opacity: 1;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="booking-cancelled text-center">
        <div class="cancel-icon">✘</div>
        <h4 class="alert-heading">Hủy phòng thành công!</h4>
        <p class="text-white">Thông tin hủy phòng của bạn đã được xử lý thành công.</p>
        <a href="${pageContext.request.contextPath}/main_roombooking" class="btn btn-return mt-4">
            Quay lại danh sách phòng
        </a>
    </div>
</div>
</body>
</html>
