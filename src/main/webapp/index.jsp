<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Hội đồng Báo cáo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Hệ thống Quản lý Hội đồng Báo cáo</h1>
        <div class="row mt-4">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản lý Sinh viên</h5>
                        <a href="students.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản lý Giảng viên</h5>
                        <a href="lecturers.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản lý Hội đồng</h5>
                        <a href="committees.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Phân công Giảng viên</h5>
                        <a href="assignments.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body text-center">
                        <h5 class="card-title">Quản lý Báo cáo</h5>
                        <a href="reports.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
