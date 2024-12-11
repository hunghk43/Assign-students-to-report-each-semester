<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="model.Lecturer" %>
<%
    LecturerDAO lecturerDAO = new LecturerDAO();
    List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Lecturers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script>
        function confirmDelete(lecturerId) {
            if (confirm("Bạn có chắc chắn muốn xóa giảng viên này?")) {
                window.location.href = "lecturers?action=delete&id=" + lecturerId;
            }
        }
    </script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Quản lí Giảng Viên</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ tên</th>
                    <th>Ngành</th>
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
                        <a href="lecturers?action=edit&id=<%= lecturer.getLecturerId() %>" class="btn btn-warning btn-sm">Sửa</a>
                         <a href="#" onclick="confirmDelete(<%= lecturer.getLecturerId()%>)" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addLecturer.jsp" class="btn btn-success">Thêm giảng viên</a>
        <a href="index.jsp" class="btn btn-success">Trang chủ</a>
    </div>
</body>
</html>