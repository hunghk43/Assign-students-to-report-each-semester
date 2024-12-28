package Controller;

import dao.ProjectDAO;
import model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/projects")
public class ProjectController extends HttpServlet {
    private ProjectDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int projectId = Integer.parseInt(request.getParameter("id"));
            projectDAO.deleteProject(projectId);
            response.sendRedirect("projects?action=list");
        } else if ("edit".equals(action)) {
            int projectId = Integer.parseInt(request.getParameter("id"));
            Project project = projectDAO.getProjectById(projectId);
            request.setAttribute("project", project);
            request.getRequestDispatcher("projects/editProject.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Project> projects = projectDAO.getAllProjects();
            request.setAttribute("projects", projects);
            request.getRequestDispatcher("projects/listProjects.jsp").forward(request, response);
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
            String projectName = request.getParameter("projectName");
            String description = request.getParameter("description");
            int semesterId = Integer.parseInt(request.getParameter("semesterId"));
            Project project = new Project(0, projectName, description, semesterId);
            projectDAO.addProject(project);
            response.sendRedirect("projects?action=list");
        } else if ("update".equals(action)) {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            String projectName = request.getParameter("projectName");
            String description = request.getParameter("description");
            int semesterId = Integer.parseInt(request.getParameter("semesterId"));
            Project project = new Project(projectId, projectName, description, semesterId);
            projectDAO.updateProject(project);
            response.sendRedirect("projects?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}