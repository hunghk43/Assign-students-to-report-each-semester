package Controller;

import dao.CommitteeDAO;
import model.Committee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/committees")
public class CommitteeController extends HttpServlet {
    private CommitteeDAO committeeDAO;

    @Override
    public void init() {
        committeeDAO = new CommitteeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int committeeId = Integer.parseInt(request.getParameter("id"));
            committeeDAO.deleteCommittee(committeeId);
            response.sendRedirect("committees");
        } else if ("edit".equals(action)) {
            int committeeId = Integer.parseInt(request.getParameter("id"));
            Committee committee = committeeDAO.getCommitteeById(committeeId);
            request.setAttribute("committee", committee);
            request.getRequestDispatcher("editCommittee.jsp").forward(request, response);
        } else {
            List<Committee> committees = committeeDAO.getAllCommittees();
            request.setAttribute("committees", committees);
            request.getRequestDispatcher("committees.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String committeeIdParam = request.getParameter("committeeId");
        String committeeName = request.getParameter("committeeName");
        int academicYear = Integer.parseInt(request.getParameter("academicYear"));

        if (committeeIdParam != null && !committeeIdParam.isEmpty()) {
            // Update existing committee
            int committeeId = Integer.parseInt(committeeIdParam);
            Committee committee = new Committee(committeeId, committeeName, academicYear);
            committeeDAO.updateCommittee(committee);
        } else {
            // Add new committee
            Committee committee = new Committee(0, committeeName, academicYear); // Assuming 0 for new entries
            committeeDAO.addCommittee(committee);
        }

        response.sendRedirect("committees");
    }
}