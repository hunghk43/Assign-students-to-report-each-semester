package Controller;

import dao.SemesterDAO;
import model.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/semesters")
public class SemesterController extends HttpServlet {
    private SemesterDAO semesterDAO;

    @Override
    public void init() {
        semesterDAO = new SemesterDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int semesterId = Integer.parseInt(request.getParameter("id"));
            semesterDAO.deleteSemester(semesterId);
            response.sendRedirect("semesters?action=list");
        } else if ("edit".equals(action)) {
            int semesterId = Integer.parseInt(request.getParameter("id"));
            Semester semester = semesterDAO.getSemesterById(semesterId);
            request.setAttribute("semester", semester);
            request.getRequestDispatcher("semesters/editSemester.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Semester> semesters = semesterDAO.getAllSemesters();
            request.setAttribute("semesters", semesters);
            request.getRequestDispatcher("semesters/listSemesters.jsp").forward(request, response);
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
            String semesterName = request.getParameter("semesterName");
            String academicYear = request.getParameter("academicYear");
            Semester semester = new Semester(0, semesterName, academicYear);
            semesterDAO.addSemester(semester);
            response.sendRedirect("semesters?action=list");
        } else if ("update".equals(action)) {
            int semesterId = Integer.parseInt(request.getParameter("semesterId"));
            String semesterName = request.getParameter("semesterName");
            String academicYear = request.getParameter("academicYear");
            Semester semester = new Semester(semesterId, semesterName, academicYear);
            semesterDAO.updateSemester(semester);
            response.sendRedirect("semesters?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}