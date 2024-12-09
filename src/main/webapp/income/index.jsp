<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2024
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Income Statistics</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .filter-form {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>Income Statistics</h1>

<div class="filter-form">
    <form action="income_statistics" method="get">
        <label for="year">Filter by Year:</label>
        <input type="number" id="year" name="year" placeholder="Enter year">
        <button type="submit">Filter</button>
    </form>
    <form action="income_statistics" method="get">
        <label for="month">Filter by Month:</label>
        <input type="number" id="month" name="month" placeholder="Enter month (1-12)">
        <button type="submit">Filter</button>
    </form>
    <form action="income_statistics" method="get">
        <button type="submit">Show All</button>
    </form>
</div>

<c:choose>
    <c:when test="${not empty incomeStats}">
        <table>
            <thead>
            <tr>
                <th>Revenue ID</th>
                <th>Month</th>
                <th>Year</th>
                <th>Total Income</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="income" items="${incomeStats}">
                <tr>
                    <td>${income.revenueId}</td>
                    <td>${income.month}</td>
                    <td>${income.year}</td>
                    <td>${income.totalIncome}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>No income statistics available.</p>
    </c:otherwise>
</c:choose>

</body>
</html>

