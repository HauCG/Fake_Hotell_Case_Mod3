<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xác Nhận Trả Phòng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Xác Nhận Trả Phòng</h1>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
                ${errorMessage}
        </div>
    </c:if>

    <div class="card shadow-sm">
        <div class="card-body">
            <h4>Thông Tin Phòng</h4>
            <p><strong>Mã đặt phòng:</strong> ${param.bookingId}</p>
            <div class="col-md-6">
                <img src="${param.roomImgLink}"
                     alt="Room Image"
                     class="room-image shadow"
                     onerror="this.src='https://via.placeholder.com/400x300?text=No+Image+Available'">
            </div>
            <p><strong>Khách hàng:</strong> ${param.customerName}</p>
            <p><strong>Vị trí:</strong> ${param.roomLocation}</p>
            <p><strong>Giá phòng:</strong> $${param.roomPrice}</p>

            <hr>
            <h5>Bạn có chắc chắn muốn trả phòng này không?</h5>

            <form action="${pageContext.request.contextPath}/rentRoomForm_Temporary" method="post">

                <!-- Trường ẩn để gửi giá trị action -->
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
