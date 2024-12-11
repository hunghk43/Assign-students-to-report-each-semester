package Controller;

import dao.LecturerDAO;
import model.Lecturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/lecturers")
public class LecturerController extends HttpServlet {
    private LecturerDAO lecturerDAO;

    @Override
    public void init() {
        lecturerDAO = new LecturerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            lecturerDAO.deleteLecturer(lecturerId);
            response.sendRedirect("lecturers");
        } else if ("edit".equals(action)) {
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            Lecturer lecturer = lecturerDAO.getLecturerById(lecturerId);
            request.setAttribute("lecturer", lecturer);
            request.getRequestDispatcher("editLecturer.jsp").forward(request, response);
        } else {
            List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
            request.setAttribute("lecturers", lecturers);
            request.getRequestDispatcher("lecturers.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        String lecturerIdParam = request.getParameter("lecturerId");
        String fullName = request.getParameter("fullName");
        String department = request.getParameter("department");

        // Check if lecturerId is present and not empty to decide whether to update or add
        if (lecturerIdParam != null && !lecturerIdParam.isEmpty()) {
            // Update existing lecturer
            int lecturerId = Integer.parseInt(lecturerIdParam);
            Lecturer lecturer = new Lecturer(lecturerId, fullName, department);
            lecturerDAO.updateLecturer(lecturer);
        } else {
            // Add new lecturer
            Lecturer lecturer = new Lecturer(0, fullName, department); // Assuming 0 or any non-valid ID for new entries
            lecturerDAO.addLecturer(lecturer);
        }

        response.sendRedirect("lecturers");
    }
}