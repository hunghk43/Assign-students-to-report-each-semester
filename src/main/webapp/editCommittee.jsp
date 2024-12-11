<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Committee" %>
<%
    int committeeId = Integer.parseInt(request.getParameter("id"));
    CommitteeDAO committeeDAO = new CommitteeDAO();
    Committee committee = committeeDAO.getCommitteeById(committeeId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa Hội đồng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Chỉnh sửa Hội đồng</h1>
        <form action="committees" method="post" class="mt-4">
            <input type="hidden" name="committeeId" value="<%= committee.getCommitteeId() %>">
            <div class="mb-3">
                <label for="committeeName" class="form-label">Tên Hội đồng</label>
                <input type="text" class="form-control" id="committeeName" name="committeeName" value="<%= committee.getCommitteeName() %>" required>
            </div>
            <div class="mb-3">
                <label for="academicYear" class="form-label">Năm học</label>
                <input type="number" class="form-control" id="academicYear" name="academicYear" value="<%= committee.getAcademicYear() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
            <a href="committees.jsp" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>