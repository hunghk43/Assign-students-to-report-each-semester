package Controller;

import dao.CouncilDAO;
import model.Council;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/councils") // Sửa URL mapping
public class CouncilController extends HttpServlet { // Đổi tên class
    private CouncilDAO councilDAO;

    @Override
    public void init() {
        councilDAO = new CouncilDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("id"));
            councilDAO.deleteCouncil(councilId);
            response.sendRedirect("councils");
        } else if ("edit".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("id"));
            Council council = councilDAO.getCouncilById(councilId);
            request.setAttribute("council", council);
            request.getRequestDispatcher("councils/editCouncil.jsp").forward(request, response); // Sửa đường dẫn JSP
        } else if("list".equals(action)){
            List<Council> councils = councilDAO.getAllCouncils();
            request.setAttribute("councils", councils);
            request.getRequestDispatcher("councils/listCouncils.jsp").forward(request, response); // Sửa đường dẫn JSP
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

         if ("add".equals(action)) {
            String councilName = request.getParameter("councilName");
            int semesterId = Integer.parseInt(request.getParameter("semesterId"));
             Council council = new Council(0, councilName, semesterId);
             councilDAO.addCouncil(council);
             response.sendRedirect("councils?action=list");
        } else if ("update".equals(action)) {
             int councilId = Integer.parseInt(request.getParameter("councilId"));
             String councilName = request.getParameter("councilName");
             int semesterId = Integer.parseInt(request.getParameter("semesterId"));
             Council council = new Council(councilId, councilName, semesterId);
             councilDAO.updateCouncil(council);
             response.sendRedirect("councils?action=list");
        } else {
             // Xử lí mặc định
             response.sendRedirect(request.getContextPath() + "/");
        }
    }
}