package Controller;

import dao.CouncilAssignmentDAO;
import model.CouncilAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/council-assignments")
public class CouncilAssignmentController extends HttpServlet {
    private CouncilAssignmentDAO councilAssignmentDAO;

    @Override
    public void init() {
        councilAssignmentDAO = new CouncilAssignmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            councilAssignmentDAO.deleteCouncilAssignment(councilId, projectId, lecturerId);
            response.sendRedirect("council-assignments?action=list");
        } else if ("edit".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            CouncilAssignment councilAssignment = councilAssignmentDAO.getCouncilAssignmentById(councilId, projectId, lecturerId);
            request.setAttribute("councilAssignment", councilAssignment);
            request.getRequestDispatcher("councils/assignProjectToCouncil.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<CouncilAssignment> councilAssignments = councilAssignmentDAO.getAllCouncilAssignments();
            request.setAttribute("councilAssignments", councilAssignments);
            request.getRequestDispatcher("councils/listCouncilAssignments.jsp").forward(request, response);
        } else {
            // Xử lý mặc định hoặc chuyển hướng đến trang chính
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            CouncilAssignment councilAssignment = new CouncilAssignment(councilId, projectId, lecturerId);
            councilAssignmentDAO.addCouncilAssignment(councilAssignment);
            response.sendRedirect("council-assignments?action=list");
        } else if ("update".equals(action)) {
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            CouncilAssignment councilAssignment = new CouncilAssignment(councilId, projectId, lecturerId);
            councilAssignmentDAO.updateCouncilAssignment(councilAssignment);
            response.sendRedirect("council-assignments?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}