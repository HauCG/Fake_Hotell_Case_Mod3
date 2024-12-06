<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room List</title>
    <link rel="stylesheet" href="styles.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1>Danh sách phòng</h1>

<!-- Hiển thị thông báo nếu có lỗi -->
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<!-- Hiển thị bảng danh sách phòng -->
<table border="1">
    <thead>
    <tr>
        <th>Mã phòng</th>
        <th>Mô tả phòng</th>
        <th>Giá phòng</th>
        <th>Trạng thái</th>
        <th>Ngày tạo</th>
        <th>Ngày cập nhật</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <!-- Lặp qua danh sách phòng và hiển thị thông tin -->
    <c:forEach var="room" items="${rooms}">
        <tr>
            <td>${room.roomCode}</td>
            <td>${room.roomDescription}</td>
            <td>${room.roomPrice}</td>
            <td>${room.roomStatus}</td>
            <td>${room.roomCreateDate}</td>
            <td>${room.roomUpdateDate}</td>
            <td>
                <form action="${pageContext.request.contextPath}/Room_Temporary/rentRoomForm_Temporary.jsp" method="GET">
                    <input type="hidden" name="roomCode" value="${room.roomCode}">
                    <button type="submit" class="btn btn-danger">CHO THUÊ PHÒNG</button>
                </form>
                <form action="${pageContext.request.contextPath}/Room_Temporary/returnRoom.jsp" method="GET">
                    <input type="hidden" name="roomCode" value="${room.roomCode}">
                    <button type="submit" class="btn btn-primary">TRẢ PHÒNG</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
