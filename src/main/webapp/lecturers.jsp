<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="model.Lecturer" %>
<%
    // Initialize DAO and retrieve list of lecturers
    LecturerDAO lecturerDAO = new LecturerDAO();
    List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Lecturers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Manage Lecturers</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (Lecturer lecturer : lecturers) { %>
                <tr>
                    <td><%= lecturer.getLecturerId() %></td>
                    <td><%= lecturer.getFullName() %></td>
                    <td><%= lecturer.getDepartment() %></td>
                    <td>
                        <a href="editLecturer.jsp?id=<%= lecturer.getLecturerId() %>" class="btn btn-warning btn-sm">Edit</a>
                        <a href="deleteLecturer?id=<%= lecturer.getLecturerId() %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addLecturer.jsp" class="btn btn-success">Add Lecturer</a>
    </div>
</body>
</html>
