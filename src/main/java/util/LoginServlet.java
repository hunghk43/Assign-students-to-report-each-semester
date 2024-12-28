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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

      
        if ("hungdeptrai".equals(username) && "1234567890".equals(password)) {
         
            HttpSession session = request.getSession(false);
            if (session == null) {
                session = request.getSession();
            }
            session.setAttribute("username", username);

          
            response.sendRedirect("confirm.jsp");
        } else {
         
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
