<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Committee" %>
<%
    CommitteeDAO committeeDAO = new CommitteeDAO();
    List<Committee> committees = committeeDAO.getAllCommittees();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Hội đồng</title>
     <!-- Favicon -->
    <link href="image/logo_ued.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/index.css" rel="stylesheet">
    <link rel="stylesheet" href="css/committees.css">
    <script>
        function confirmDelete(committeeId) {
            if (confirm("Bạn có chắc chắn muốn xóa hội đồng này?")) {
                window.location.href = "committees?action=delete&id=" + committeeId;
            }
        }
    </script>
</head>
<body>
 <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->
  <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
           <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
       <img src="image/logo_ued.jpg" alt="Logo Đại học SP" height="50">
            <h2 class="m-0 text-primary">ĐH SƯ PHẠM ĐÀ NẴNG</h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="index.jsp" class="nav-item nav-link">TRANG CHỦ</a>
                <a href="about.jsp" class="nav-item nav-link">GIỚI THIỆU</a>
                <a href="activity.jsp" class="nav-item nav-link">HOẠT ĐỘNG</a>
                <a href="contact.jsp" class="nav-item nav-link">LIÊN HỆ</a>
                 <a href="committees.jsp" class="nav-item nav-link active">HỘI ĐÒNG</a>
           
    </nav>
    
    <!-- Navbar End -->
    <div class="container mt-5">
        <h1 class="text-center">Quản lý Hội đồng</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên Hội đồng</th>
                    <th>Năm học</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (Committee committee : committees) { %>
                <tr>
                    <td><%= committee.getCommitteeId() %></td>
                    <td><%= committee.getCommitteeName() %></td>
                    <td><%= committee.getAcademicYear() %></td>
                    <td>
                        <a href="committees?action=edit&id=<%= committee.getCommitteeId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="#" onclick="confirmDelete(<%= committee.getCommitteeId() %>)" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addCommittee.jsp" class="btn btn-success">Thêm Hội đồng</a>
     
    </div>
     <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="Js/main.js"></script>
</body>
</html>