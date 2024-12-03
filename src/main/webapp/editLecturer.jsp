<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="model.Lecturer" %>
<%
    // Lấy ID giảng viên từ request
    int lecturerId = Integer.parseInt(request.getParameter("id"));

    // Khởi tạo DAO và lấy thông tin giảng viên
    LecturerDAO lecturerDAO = new LecturerDAO();
    Lecturer lecturer = lecturerDAO.getLecturerById(lecturerId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Giảng viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Chỉnh sửa Giảng viên</h1>
        <form action="updateLecturer" method="post" class="mt-4">
            <input type="hidden" name="lecturerId" value="<%= lecturer.getLecturerId() %>">
            <div class="mb-3">
                <label for="fullName" class="form-label">Họ tên</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="<%= lecturer.getFullName() %>" required>
            </div>
            <div class="mb-3">
                <label for="department" class="form-label">Bộ môn</label>
                <input type="text" class="form-control" id="department" name="department" value="<%= lecturer.getDepartment() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
            <a href="lecturers.jsp" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
    