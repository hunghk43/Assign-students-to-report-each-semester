package Controller;

import dao.ProjectLecturerDAO;
import model.ProjectLecturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/project-lecturers") // Đổi URL mapping
public class AssignmentController extends HttpServlet {
    private ProjectLecturerDAO projectLecturerDAO;

    @Override
    public void init() {
        projectLecturerDAO = new ProjectLecturerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            projectLecturerDAO.deleteProjectLecturer(projectId, studentId, lecturerId);
            response.sendRedirect("project-lecturers");
        } else if ("edit".equals(action)) {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            ProjectLecturer projectLecturer = projectLecturerDAO.getProjectLecturerById(projectId, studentId, lecturerId);
            request.setAttribute("projectLecturer", projectLecturer);
            request.getRequestDispatcher("editAssignment.jsp").forward(request, response); // Sửa đường dẫn JSP
        } else if ("list".equals(action)) {
            List<ProjectLecturer> projectLecturers = projectLecturerDAO.getAllProjectLecturers();
            request.setAttribute("projectLecturers", projectLecturers);
            request.getRequestDispatcher("assignments.jsp").forward(request, response); // Sửa đường dẫn JSP
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
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            ProjectLecturer projectLecturer = new ProjectLecturer(projectId, studentId, lecturerId);
            projectLecturerDAO.addProjectLecturer(projectLecturer);
            response.sendRedirect("project-lecturers?action=list");
        } else if ("update".equals(action)) {
            // Assuming you might want to update the lecturer for a project-student pair
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            ProjectLecturer projectLecturer = new ProjectLecturer(projectId, studentId, lecturerId);
            projectLecturerDAO.updateProjectLecturer(projectLecturer);
            response.sendRedirect("project-lecturers?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}