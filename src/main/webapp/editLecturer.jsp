<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="model.Lecturer" %>
<%
    // Get lecturer ID from request
    int lecturerId = Integer.parseInt(request.getParameter("id"));

    // Initialize DAO and retrieve lecturer information
    LecturerDAO lecturerDAO = new LecturerDAO();
    Lecturer lecturer = lecturerDAO.getLecturerById(lecturerId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Lecturer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Edit Lecturer</h1>
        <form action="updateLecturer" method="post" class="mt-4">
            <input type="hidden" name="lecturerId" value="<%= lecturer.getLecturerId() %>">
            <div class="mb-3">
                <label for="fullName" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="<%= lecturer.getFullName() %>" required>
            </div>
            <div class="mb-3">
                <label for="department" class="form-label">Department</label>
                <input type="text" class="form-control" id="department" name="department" value="<%= lecturer.getDepartment() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="lecturers.jsp" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
