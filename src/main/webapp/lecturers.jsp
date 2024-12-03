<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="model.Lecturer" %>
<%
    // Khởi tạo DAO và lấy danh sách giảng viên
    LecturerDAO lecturerDAO = new LecturerDAO();
    List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Giảng viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Quản lý Giảng viên</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ tên</th>
                    <th>Bộ môn</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (Lecturer lecturer : lecturers) { %>
                <tr>
                    <td><%= lecturer.getLecturerId() %></td>
                    <td><%= lecturer.getFullName() %></td>
                    <td><%= lecturer.getDepartment() %></td>
                    <td>
                        <a href="editLecturer.jsp?id=<%= lecturer.getLecturerId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="deleteLecturer?id=<%= lecturer.getLecturerId() %>" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addLecturer.jsp" class="btn btn-success">Thêm Giảng viên</a>
    </div>
</body>
</html>
