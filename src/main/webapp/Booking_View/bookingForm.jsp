<%--
  Created by IntelliJ IDEA.
  User: Mr Loc
  Date: 12/6/2024
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form action="booking" method="post">
    <input type="hidden" name="roomId" value="${room.roomId}">
    <input type="hidden" name="userId" value="${sessionScope.user.userId}">
    <input type="hidden" name="roomPrice" value="${room.roomPrice}">

    <div>
        <label>Mã phòng:</label>
        <span>${room.roomCode}</span>
    </div>
    <div>
        <label>Thời gian bắt đầu cho thuê:</label>
        <input type="datetime-local" name="startDate" value="${now}">
    </div>
    <div>
        <label>Thời gian trả phòng:</label>
        <input type="datetime-local" name="endDate">
    </div>
    <button type="submit">Xác nhận đặt phòng</button>
</form>

<form action="booking?action=return" method="post">
    <input type="hidden" name="bookingId" value="${booking.bookingId}">
    <input type="hidden" name="roomId" value="${booking.roomId}">
    <button type="submit">Trả phòng</button>
</form>