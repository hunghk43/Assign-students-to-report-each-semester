package Controller;

import dao.LecturerAssignmentDAO;
import model.LecturerAssignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/assignments")
public class AssignmentController extends HttpServlet {
    private LecturerAssignmentDAO assignmentDAO;

    @Override
    public void init() {
        assignmentDAO = new LecturerAssignmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int assignmentId = Integer.parseInt(request.getParameter("id"));
            assignmentDAO.deleteAssignment(assignmentId);
            response.sendRedirect("assignments");
        } else if ("edit".equals(action)) {
            int assignmentId = Integer.parseInt(request.getParameter("id"));
            LecturerAssignment assignment = assignmentDAO.getAssignmentById(assignmentId);
            request.setAttribute("assignment", assignment);
            request.getRequestDispatcher("editAssignment.jsp").forward(request, response);
        } else {
            List<LecturerAssignment> assignments = assignmentDAO.getAllAssignments();
            request.setAttribute("assignments", assignments);
            request.getRequestDispatcher("assignments.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String assignmentIdParam = request.getParameter("assignmentId");
        int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
        int committeeId = Integer.parseInt(request.getParameter("committeeId"));
       

        if (assignmentIdParam != null && !assignmentIdParam.isEmpty()) {
            // Update existing assignment
            int assignmentId = Integer.parseInt(assignmentIdParam);
            LecturerAssignment assignment = new LecturerAssignment(assignmentId, lecturerId, committeeId);
            assignmentDAO.updateAssignment(assignment);
        } else {
            // Add new assignment
            LecturerAssignment assignment = new LecturerAssignment(0, lecturerId, committeeId);
            assignmentDAO.addAssignment(assignment);
        }

        response.sendRedirect("assignments");
    }
}