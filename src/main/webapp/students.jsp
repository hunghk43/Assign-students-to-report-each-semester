<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="model.Student" %>
<%
    StudentDAO studentDAO = new StudentDAO();
    List<Student> students = studentDAO.getAllStudents();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Sinh viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Quản lý Sinh viên</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ tên</th>
                    <th>Năm học</th>
                    <th>Ngành</th>
                    <th>Lớp</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (Student student : students) { %>
                <tr>
                    <td><%= student.getStudentId() %></td>
                    <td><%= student.getFullName() %></td>
                    <td><%= student.getYear() %></td>
                    <td><%= student.getMajor() %></td>
                    <td><%= student.getStudentClass() %></td>
                    <td>
                        <a href="editStudent.jsp?id=<%= student.getStudentId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="deleteStudent?id=<%= student.getStudentId() %>" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addStudent.jsp" class="btn btn-success">Thêm Sinh viên</a>
    </div>
</body>
</html>