<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="./css/confirm.css">
    <title>Xác nhận đăng nhập</title>
</head>
<body>
    <div class="wrapper">
        <h2>Xác nhận đăng nhập</h2>
    
    <%
        // Lấy session
        HttpSession Session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (username != null) {
    %>
                <p>Đăng nhập thành công! Chào mừng, <strong><%= username %></strong>.</p>
    <%
            } else {
    %>
                <p>Lỗi: Không tìm thấy thông tin người dùng.</p>
    <%
            }
        } else {
    %>
            <p>Lỗi: Phiên làm việc không hợp lệ.</p>
    <%
        }
    %>
    
    <a href="index.jsp">Trang chủ Quản lí </a>
    </div>
</body>
</html>
