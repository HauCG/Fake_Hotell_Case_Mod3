<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cho Thuê Phòng</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Cho Thuê Phòng: ${room.roomCode}</h1>

<!-- Hiển thị thông báo nếu có lỗi -->
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<!-- Form cho thuê phòng -->
<form action="${pageContext.request.contextPath}/rentRoom" method="POST">
    <div class="mb-3">
        <label for="roomCode" class="form-label">Mã phòng</label>
        <input type="text" class="form-control" id="roomCode" name="roomCode" value="${room.roomCode}" readonly>
    </div>
    <div class="mb-3">
        <label for="roomDescription" class="form-label">Mô tả phòng</label>
        <input type="text" class="form-control" id="roomDescription" name="roomDescription" value="${room.roomDescription}" readonly>
    </div>
    <div class="mb-3">
        <label for="roomPrice" class="form-label">Giá phòng</label>
        <input type="number" class="form-control" id="roomPrice" name="roomPrice" value="${room.roomPrice}" readonly>
    </div>
    <div class="mb-3">
        <label for="rentStart" class="form-label">Thời gian cho thuê</label>
        <input type="datetime-local" class="form-control" id="rentStart" name="rentStart" value="${currentDateTime}" required readonly>
    </div>
    <div class="mb-3">
        <label for="rentEnd" class="form-label">Thời gian trả phòng</label>
        <input type="datetime-local" class="form-control" id="rentEnd" name="rentEnd" required>
    </div>
    <div class="mb-3">
        <label for="totalAmount" class="form-label">Tổng số tiền</label>
        <input type="number" class="form-control" id="totalAmount" name="totalAmount" readonly>
    </div>

    <button type="submit" class="btn btn-success">Lưu</button>
    <a href="${pageContext.request.contextPath}/roomList" class="btn btn-secondary">Quay lại</a>
</form>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script>
    // Sử dụng jQuery để tính toán giá thuê khi người dùng nhập thời gian trả phòng
    $(document).ready(function () {
        $('#rentEnd').on('change', function () {
            var rentStart = new Date($('#rentStart').val());
            var rentEnd = new Date($('#rentEnd').val());

            if (rentEnd <= rentStart) {
                alert('Thời gian trả phòng phải sau thời gian cho thuê');
                return;
            }

            // Tính toán số giờ thuê
            var timeDiff = rentEnd - rentStart; // thời gian chênh lệch tính theo mili giây
            var hours = timeDiff / (1000 * 3600); // chuyển sang giờ

            // Tính tổng số tiền
            var roomPrice = $('#roomPrice').val();
            var totalAmount = roomPrice * hours;
            $('#totalAmount').val(totalAmount.toFixed(2)); // Hiển thị số tiền
        });
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
