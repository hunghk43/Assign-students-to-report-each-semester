<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Hội đồng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Thêm Hội đồng</h1>
        <form action="addCommittee" method="post" class="mt-4">
            <div class="mb-3">
                <label for="committeeName" class="form-label">Tên Hội đồng</label>
                <input type="text" class="form-control" id="committeeName" name="committeeName" required>
            </div>
            <div class="mb-3">
                <label for="academicYear" class="form-label">Năm học</label>
                <input type="number" class="form-control" id="academicYear" name="academicYear" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="committees.jsp" class="btn btn-secondary">Quay lại</a>
        </form>
    </div>
</body>
</html>
