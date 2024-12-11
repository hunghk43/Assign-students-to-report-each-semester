<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ReportDAO" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Report" %>
<%@ page import="model.Student" %>
<%@ page import="model.Committee" %>
<%@ page import="java.util.List" %>
<%
    int reportId = Integer.parseInt(request.getParameter("id"));
    ReportDAO reportDAO = new ReportDAO();
    Report report = reportDAO.getReportById(reportId);

    StudentDAO studentDAO = new StudentDAO();
    List<Student> students = studentDAO.getAllStudents();

    CommitteeDAO committeeDAO = new CommitteeDAO();
    List<Committee> committees = committeeDAO.getAllCommittees();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Báo cáo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Chỉnh sửa Báo cáo Sinh viên</h1>
        <form action="reports" method="post" class="mt-4">
            <input type="hidden" name="reportId" value="<%= report.getReportId() %>">
            <div class="mb-3">
                <label for="studentId" class="form-label">Sinh viên</label>
                <select id="studentId" name="studentId" class="form-control" required>
                    <% for (Student student : students) { %>
                        <option value="<%= student.getStudentId() %>" 
                            <%= student.getStudentId() == report.getStudent().getStudentId() ? "selected" : "" %> >
                            <%= student.getFullName() %>
                        </option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="committeeId" class="form-label">Hội đồng</label>
                <select id="committeeId" name="committeeId" class="form-control" required>
                    <% for (Committee committee : committees) { %>
                        <option value="<%= committee.getCommitteeId() %>" 
                            <%= committee.getCommitteeId() == report.getCommittee().getCommitteeId() ? "selected" : "" %> >
                            <%= committee.getCommitteeName() %>
                        </option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label for="reportTopic" class="form-label">Chủ đề Báo cáo</label>
                <input type="text" id="reportTopic" name="reportTopic" class="form-control" value="<%= report.getReportTopic() %>" required>
            </div>
            <div class="mb-3">
                <label for="submissionDate" class="form-label">Ngày nộp</label>
                <input type="date" id="submissionDate" name="submissionDate" class="form-control" value="<%= new java.sql.Date(report.getSubmissionDate().getTime()) %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật Báo cáo</button>
            <a href="reports.jsp" class="btn btn-secondary">Quay lại</a>
        </form>
    </div>
</body>
</html>