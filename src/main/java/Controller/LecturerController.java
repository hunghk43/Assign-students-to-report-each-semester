package Controller;

import dao.LecturerDAO;
import model.Lecturer;
import util.JsonUtil;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String lecturerId = request.getParameter("id");
        if (lecturerId != null) {
            Lecturer lecturer = lecturerDAO.getLecturerById(Integer.parseInt(lecturerId));
            JsonUtil.writeJsonResponse(response, lecturer);
        } else {
            List<Lecturer> lecturers = lecturerDAO.getAllLecturers();
            JsonUtil.writeJsonResponse(response, lecturers);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Lecturer lecturer = JsonUtil.readJsonRequest(request, Lecturer.class);
        lecturerDAO.addLecturer(lecturer);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Lecturer lecturer = JsonUtil.readJsonRequest(request, Lecturer.class);
        lecturerDAO.updateLecturer(lecturer);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int lecturerId = Integer.parseInt(request.getParameter("id"));
        lecturerDAO.deleteLecturer(lecturerId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    // For redirecting from the JSP update page after successful update
    protected void updateLecturer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
        String fullName = request.getParameter("fullName");
        String department = request.getParameter("department");

        Lecturer lecturer = new Lecturer(lecturerId, fullName, department);
        lecturerDAO.updateLecturer(lecturer);

        // Redirect to the list of lecturers after updating
        response.sendRedirect("lecturers.jsp");
    }
}
