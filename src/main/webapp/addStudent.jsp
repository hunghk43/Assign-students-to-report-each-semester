<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sinh viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Thêm Sinh viên</h1>
        <form action="students" method="post" class="mt-4">
            <div class="mb-3">
                <label for="fullName" class="form-label">Họ tên</label>
                <input type="text" class="form-control" id="fullName" name="fullName" required>
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Năm học</label>
                <input type="number" class="form-control" id="year" name="year" min="3" max="4" required>
            </div>
            <div class="mb-3">
                <label for="major" class="form-label">Ngành</label>
                <input type="text" class="form-control" id="major" name="major" required>
            </div>
            <div class="mb-3">
                <label for="className" class="form-label">Lớp</label>
                <input type="text" class="form-control" id="className" name="className" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="students.jsp" class="btn btn-secondary">Quay lại</a>
        </form>
    </div>
</body>
</html>