package Controller;

import dao.*;
import model.*;
import util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/assignments")
public class AssignmentController extends HttpServlet {
    private LecturerAssignmentDAO lecturerAssignmentDAO;

    @Override
    public void init() {
        lecturerAssignmentDAO = new LecturerAssignmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String assignmentId = request.getParameter("id");
        if (assignmentId != null) {
            LecturerAssignment assignment = lecturerAssignmentDAO.getAssignmentById(Integer.parseInt(assignmentId));
            JsonUtil.writeJsonResponse(response, assignment);
        } else {
            List<LecturerAssignment> assignments = lecturerAssignmentDAO.getAllAssignments();
            JsonUtil.writeJsonResponse(response, assignments);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LecturerAssignment assignment = JsonUtil.readJsonRequest(request, LecturerAssignment.class);
        lecturerAssignmentDAO.addAssignment(assignment);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LecturerAssignment assignment = JsonUtil.readJsonRequest(request, LecturerAssignment.class);
        lecturerAssignmentDAO.updateAssignment(assignment);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int assignmentId = Integer.parseInt(request.getParameter("id"));
        lecturerAssignmentDAO.deleteAssignment(assignmentId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    protected void updateAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
        int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
        int committeeId = Integer.parseInt(request.getParameter("committeeId"));

        LecturerAssignment assignment = new LecturerAssignment(assignmentId, lecturerId, committeeId);
        LecturerAssignmentDAO assignmentDAO = new LecturerAssignmentDAO();
        assignmentDAO.updateAssignment(assignment);

        // Redirect về danh sách phân công
        response.sendRedirect("assignments.jsp");
    }

}
