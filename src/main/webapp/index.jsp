<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Hội đồng Báo cáo</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        .hover-card:hover {
            transform: scale(1.05);
            transition: 0.3s;
        }

        .card-title {
            font-size: 1.25rem;
            font-weight: bold;
        }

        .navbar-brand {
            font-weight: bold;
        }

        .bg-header {
            background: linear-gradient(to right, #007bff, #00c6ff);
            color: white;
        }

        .bg-header h1 {
            font-size: 2.5rem;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Quản lý Hệ thống</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="students.jsp"><i class="fas fa-user-graduate"></i> Quản lý Sinh viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lecturers.jsp"><i class="fas fa-chalkboard-teacher"></i> Quản lý Giảng viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="committees.jsp"><i class="fas fa-users"></i> Quản lý Hội đồng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="assignments.jsp"><i class="fas fa-tasks"></i> Phân công Giảng viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="reports.jsp"><i class="fas fa-file-alt"></i> Quản lý Báo cáo</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header class="py-5 bg-header text-center">
        <div class="container">
            <h1>Hệ thống Quản lý Hội đồng Báo cáo</h1>
            <p class="lead">Nền tảng hiện đại giúp quản lý hiệu quả và tiết kiệm thời gian</p>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container my-5">
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <!-- Card 1 -->
            <div class="col">
                <div class="card hover-card shadow-sm border-0">
                    <div class="card-body text-center">
                        <h5 class="card-title"><i class="fas fa-user-graduate"></i> Quản lý Sinh viên</h5>
                        <a href="students.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <!-- Card 2 -->
            <div class="col">
                <div class="card hover-card shadow-sm border-0">
                    <div class="card-body text-center">
                        <h5 class="card-title"><i class="fas fa-chalkboard-teacher"></i> Quản lý Giảng viên</h5>
                        <a href="lecturers.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <!-- Card 3 -->
            <div class="col">
                <div class="card hover-card shadow-sm border-0">
                    <div class="card-body text-center">
                        <h5 class="card-title"><i class="fas fa-users"></i> Quản lý Hội đồng</h5>
                        <a href="committees.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <!-- Card 4 -->
            <div class="col">
                <div class="card hover-card shadow-sm border-0">
                    <div class="card-body text-center">
                        <h5 class="card-title"><i class="fas fa-tasks"></i> Phân công Giảng viên</h5>
                        <a href="assignments.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
            <!-- Card 5 -->
            <div class="col">
                <div class="card hover-card shadow-sm border-0">
                    <div class="card-body text-center">
                        <h5 class="card-title"><i class="fas fa-file-alt"></i> Quản lý Báo cáo</h5>
                        <a href="reports.jsp" class="btn btn-primary">Xem Chi tiết</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white py-3 text-center">
        <p class="mb-0">© 2024 Quản lý Hội đồng Báo cáo. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
