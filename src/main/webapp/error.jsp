<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/10/2024
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4 text-danger">Error</h1>

    <div class="alert alert-danger text-center">
        <strong>Error: </strong> ${errorMessage}
    </div>

    <div class="text-center">
        <a href="income_statistics" class="btn btn-primary">Back to Filter</a>
    </div>
</div>
</body>
</html>

