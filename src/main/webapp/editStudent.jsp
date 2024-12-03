<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.StudentDAO" %>
<%@ page import="model.Student" %>
<%
    // Lấy ID sinh viên từ request
    int studentId = Integer.parseInt(request.getParameter("id"));

    // Khởi tạo DAO và lấy thông tin sinh viên
    StudentDAO studentDAO = new StudentDAO();
    Student student = studentDAO.getStudentById(studentId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Sinh viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Chỉnh sửa Sinh viên</h1>
        <form action="updateStudent" method="post" class="mt-4">
            <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
            <div class="mb-3">
                <label for="fullName" class="form-label">Họ tên</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="<%= student.getFullName() %>" required>
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Năm học</label>
                <input type="number" class="form-control" id="year" name="year" min="3" max="4" value="<%= student.getYear() %>" required>
            </div>
            <div class="mb-3">
                <label for="major" class="form-label">Ngành</label>
                <input type="text" class="form-control" id="major" name="major" value="<%= student.getMajor() %>" required>
            </div>
            <div class="mb-3">
                <label for="className" class="form-label">Lớp</label>
                <input type="text" class="form-control" id="className" name="className" value="<%= student.getStudentClass() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
            <a href="students.jsp" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
    