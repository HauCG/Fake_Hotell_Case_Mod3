<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
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
            border-radius: 15px;
        }

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
<form class="container">
<h1>User Details</h1>

<c:if test="${not empty userDetails}">
    <div>
        <p>User ID: ${userDetails.userId}</p>
        <p>Name: ${userDetails.userName}</p>
        <p>Email: ${userDetails.userEmail}</p>
        <p>Password: ${userDetails.userPassword}</p>
        <p>Birth Date: ${userDetails.userBirthDate}</p>
        <p>Phone: ${userDetails.userPhoneNumber}</p>
        <p>Role: ${userDetails.userRole}</p>
        <p>Avatar: <img src="${userDetails.userAvatarLink}" alt="User Avatar" width="100"></p>
    </div>
</c:if>

<a href="Fake_Hotell?S=mainMenu" class="btn btn-secondary">Back to Main Menu</a>
</form>
</body>
</html>
