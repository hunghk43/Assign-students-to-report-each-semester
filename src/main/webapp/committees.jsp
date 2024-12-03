<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.CommitteeDAO" %>
<%@ page import="model.Committee" %>
<%
    // Khởi tạo DAO và lấy danh sách hội đồng
    CommitteeDAO committeeDAO = new CommitteeDAO();
    List<Committee> committees = committeeDAO.getAllCommittees();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quản lý Hội đồng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Quản lý Hội đồng</h1>
        <table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên Hội đồng</th>
                    <th>Năm học</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (Committee committee : committees) { %>
                <tr>
                    <td><%= committee.getCommitteeId() %></td>
                    <td><%= committee.getCommitteeName() %></td>
                    <td><%= committee.getAcademicYear() %></td>
                    <td>
                        <a href="editCommittee.jsp?id=<%= committee.getCommitteeId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="deleteCommittee?id=<%= committee.getCommitteeId() %>" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <a href="addCommittee.jsp" class="btn btn-success">Thêm Hội đồng</a>
    </div>
</body>
</html>
    