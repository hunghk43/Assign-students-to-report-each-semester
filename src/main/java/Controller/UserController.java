package Controller;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserController extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            userDAO.deleteUser(userId);
            response.sendRedirect("users?action=list");
        } else if ("edit".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("users/editUser.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<User> users = userDAO.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("users/listUsers.jsp").forward(request, response);
        } else if ("login".equals(action)) {
            request.getRequestDispatcher("users/login.jsp").forward(request, response);
        } else if ("register".equals(action)) {
            request.getRequestDispatcher("users/register.jsp").forward(request, response);
        } else {
            // Xử lý mặc định hoặc chuyển hướng đến trang chính
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password"); // Cần mã hóa mật khẩu
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            User user = new User(0, username, password, roleId);
            userDAO.addUser(user);
            response.sendRedirect("users?action=login");
        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Kiểm tra thông tin đăng nhập
            User user = userDAO.checkLogin(username, password); // Cần mã hóa mật khẩu trước khi so sánh
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/"); // Chuyển hướng đến trang chính hoặc trang profile
            } else {
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("users/login.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String username = request.getParameter("username");
            String password = request.getParameter("password"); // Cần mã hóa mật khẩu
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            User user = new User(userId, username, password, roleId);
            userDAO.updateUser(user);
            response.sendRedirect("users?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}