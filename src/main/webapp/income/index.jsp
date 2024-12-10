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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Income Statistics</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Income Statistics</h1>

    <!-- Filter Forms -->
    <div class="mb-4">
        <form action="income_statistics" method="get" class="row g-3">
            <div class="col-md-4">
                <label for="year" class="form-label">Filter by Year:</label>
                <input type="number" class="form-control" id="year" name="year" placeholder="Enter year">
            </div>
            <div class="col-md-4">
                <label for="month" class="form-label">Filter by Month:</label>
                <input type="number" class="form-control" id="month" name="month" placeholder="Enter month (1-12)">
            </div>
            <div class="col-md-4 d-flex align-items-end">
                <button type="submit" class="btn btn-primary w-100">Filter</button>
            </div>
        </form>
        <form action="income_statistics" method="get" class="mt-3">
            <button type="submit" class="btn btn-secondary w-100">Show All</button>
        </form>
    </div>

    <!-- Income Statistics Table -->
    <c:choose>
        <c:when test="${not empty incomeStats}">
            <div class="table-responsive">
                <table class="table table-bordered table-striped table-hover">
                    <thead class="table-light">
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
                            <td>${income.revenue_id}</td>
                            <td>${income.month}</td>
                            <td>${income.year}</td>
                            <td>${income.total_revenue}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning text-center" role="alert">
                No income statistics available.
            </div>
        </c:otherwise>
    </c:choose>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


