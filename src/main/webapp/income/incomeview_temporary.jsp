<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2024
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Income Statistics for ${year}</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Income Statistics for Year ${year}</h1>

<table>
    <thead>
    <tr>
        <th>Month</th>
        <th>Income</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stat" items="${incomeStats}">
        <tr>
            <td>${stat.month}</td>
            <td>${stat.income}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="text-align: center;">
    <form action="/Fake_Hotell" method="get">
        <label for="year">Select Year:</label>
        <input type="number" id="year" name="year" value="${year}">
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
