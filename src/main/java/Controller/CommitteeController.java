package Controller;

import dao.*;
import model.*;
import util.*;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String committeeId = request.getParameter("id");
        if (committeeId != null) {
            Committee committee = committeeDAO.getCommitteeById(Integer.parseInt(committeeId));
            JsonUtil.writeJsonResponse(response, committee);
        } else {
            List<Committee> committees = committeeDAO.getAllCommittees();
            JsonUtil.writeJsonResponse(response, committees);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Committee committee = JsonUtil.readJsonRequest(request, Committee.class);
        committeeDAO.addCommittee(committee);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Committee committee = JsonUtil.readJsonRequest(request, Committee.class);
        committeeDAO.updateCommittee(committee);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int committeeId = Integer.parseInt(request.getParameter("id"));
        committeeDAO.deleteCommittee(committeeId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    protected void updateCommittee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int committeeId = Integer.parseInt(request.getParameter("committeeId"));
        String committeeName = request.getParameter("committeeName");
        int academicYear = Integer.parseInt(request.getParameter("academicYear"));

        Committee committee = new Committee(committeeId, committeeName, academicYear);
        CommitteeDAO committeeDAO = new CommitteeDAO();
        committeeDAO.updateCommittee(committee);

        // Redirect về danh sách hội đồng
        response.sendRedirect("committees.jsp");
    }

}
