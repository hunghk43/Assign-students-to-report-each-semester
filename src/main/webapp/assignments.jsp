<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.LecturerAssignmentDAO" %>
<%@ page import="model.LecturerAssignment" %>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Committee" %>
<%@ page import="model.Lecturer" %>
<%
    LecturerAssignmentDAO assignmentDAO = new LecturerAssignmentDAO();
    List<LecturerAssignment> assignments = assignmentDAO.getAllAssignments();

    LecturerDAO lecturerDAO = new LecturerDAO();
    List<Lecturer> lecturers = lecturerDAO.getAllLecturers();

    CommitteeDAO committeeDAO = new CommitteeDAO();
    List<Committee> committees = committeeDAO.getAllCommittees();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Phân công Giảng viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
     <script>
        function confirmDelete(assignmentId) {
            if (confirm("Bạn có chắc chắn muốn xóa phân công này?")) {
                window.location.href = "assignments?action=delete&id=" + assignmentId;
            }
        }
    </script>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Quản lý Phân công Giảng viên</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID Phân công</th>
                    <th>Giảng viên</th>
                    <th>Hội đồng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (LecturerAssignment assignment : assignments) { %>
                <tr>
                    <td><%= assignment.getAssignmentId() %></td>
                    <td><%= assignment.getLecturer() != null ? assignment.getLecturer().getFullName() : "Unknown" %></td>
                    <td><%= assignment.getCommittee() != null ? assignment.getCommittee().getCommitteeName() : "Unknown" %></td>
                    <td>
                        <a href="assignments?action=edit&id=<%= assignment.getAssignmentId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="#" onclick="confirmDelete(<%= assignment.getAssignmentId() %>)" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addAssignment.jsp" class="btn btn-success">Thêm Phân công</a>
        <a href="index.jsp" class="btn btn-success">Trang chủ</a>
    </div>
</body>
</html>