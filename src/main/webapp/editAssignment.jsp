<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.LecturerAssignment" %>
<%@ page import="dao.LecturerAssignmentDAO" %>
<%@ page import="dao.LecturerDAO" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Lecturer" %>
<%@ page import="model.Committee" %>
<%@ page import="java.util.List" %>
<%
    int assignmentId = Integer.parseInt(request.getParameter("id"));
    LecturerAssignmentDAO assignmentDAO = new LecturerAssignmentDAO();
    LecturerAssignment assignment = assignmentDAO.getAssignmentById(assignmentId);
    
    LecturerDAO lecturerDAO = new LecturerDAO();
    List<Lecturer> lecturers = lecturerDAO.getAllLecturers();

    CommitteeDAO committeeDAO = new CommitteeDAO();
    List<Committee> committees = committeeDAO.getAllCommittees();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Phân công</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Chỉnh sửa Phân công Giảng viên</h1>
        <form action="updateAssignment" method="post">
            <div class="mb-3">
                <label for="lecturer" class="form-label">Giảng viên</label>
                <select name="lecturerId" class="form-control">
                    <% for (Lecturer lecturer : lecturers) { %>
                    <option value="<%= lecturer.getLecturerId() %>"
                        <%= lecturer.getLecturerId() == assignment.getLecturerId() ? "selected" : "" %>>
                        <%= lecturer.getFullName() %>
                    </option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="committee" class="form-label">Hội đồng</label>
                <select name="committeeId" class="form-control">
                    <% for (Committee committee : committees) { %>
                    <option value="<%= committee.getCommitteeId() %>"
                        <%= committee.getCommitteeId() == assignment.getCommitteeId() ? "selected" : "" %>>
                        <%= committee.getCommitteeName() %>
                    </option>
                    <% } %>
                </select>
            </div>
            <input type="hidden" name="assignmentId" value="<%= assignment.getAssignmentId() %>">
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
    </div>
</body>
</html>
