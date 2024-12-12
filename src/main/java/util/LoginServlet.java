package util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy username và password từ request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra username và password (giả sử username là "admin" và password là "12345")
        if ("hungdeptrai".equals(username) && "1234567890".equals(password)) {
            // Tạo session và lưu username
            HttpSession session = request.getSession(false);
            if (session == null) {
                session = request.getSession();
            }
            session.setAttribute("username", username);

            // Chuyển đến trang xác nhận
            response.sendRedirect("confirm.jsp");
        } else {
            // Nếu đăng nhập thất bại, gửi thông báo lỗi
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
