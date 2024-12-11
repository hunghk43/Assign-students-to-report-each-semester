<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Student" %>
<%@ page import="model.Committee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Báo cáo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Thêm Báo cáo Sinh viên</h1>
        
        <% 
            // Khởi tạo DAO để lấy sinh viên và hội đồng
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();

            CommitteeDAO committeeDAO = new CommitteeDAO();
            List<Committee> committees = committeeDAO.getAllCommittees();
        %>
        
        <form action="reports" method="post" class="mt-4">
            <div class="mb-3">
                <label for="studentId" class="form-label">Sinh viên</label>
                <select id="studentId" name="studentId" class="form-control" required>
                    <option value="">Chọn Sinh viên</option>
                    <% for (Student student : students) { %>
                    <option value="<%= student.getStudentId() %>"><%= student.getFullName() %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="committeeId" class="form-label">Hội đồng</label>
                <select id="committeeId" name="committeeId" class="form-control" required>
                    <option value="">Chọn Hội đồng</option>
                    <% for (Committee committee : committees) { %>
                    <option value="<%= committee.getCommitteeId() %>"><%= committee.getCommitteeName() %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="reportTopic" class="form-label">Chủ đề Báo cáo</label>
                <input type="text" id="reportTopic" name="reportTopic" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="submissionDate" class="form-label">Ngày nộp</label>
                <input type="date" id="submissionDate" name="submissionDate" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm Báo cáo</button>
            <a href="reports.jsp" class="btn btn-secondary">Quay lại</a>
        </form>
    </div>
</body>
</html>