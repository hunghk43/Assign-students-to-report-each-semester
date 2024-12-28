package Controller;

import dao.ReportScoreDAO;
import model.ReportScore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/scores")
public class ScoreController extends HttpServlet {
    private ReportScoreDAO scoreDAO;

    @Override
    public void init() {
        scoreDAO = new ReportScoreDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int reportId = Integer.parseInt(request.getParameter("reportId"));
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            scoreDAO.deleteReportScore(reportId, councilId, lecturerId);
            response.sendRedirect("scores?action=list");
        } else if ("edit".equals(action)) {
            int reportId = Integer.parseInt(request.getParameter("reportId"));
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            ReportScore score = scoreDAO.getReportScoreById(reportId, councilId, lecturerId);
            request.setAttribute("score", score);
            request.getRequestDispatcher("scores/editScore.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<ReportScore> scores = scoreDAO.getAllReportScores();
            request.setAttribute("scores", scores);
            request.getRequestDispatcher("scores/listScores.jsp").forward(request, response);
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
            int reportId = Integer.parseInt(request.getParameter("reportId"));
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            float scoreValue = Float.parseFloat(request.getParameter("score"));
            String comment = request.getParameter("comment");
            ReportScore score = new ReportScore(reportId, councilId, lecturerId, scoreValue, comment);
            scoreDAO.addReportScore(score);
            response.sendRedirect("scores?action=list");
        } else if ("update".equals(action)) {
            int reportId = Integer.parseInt(request.getParameter("reportId"));
            int councilId = Integer.parseInt(request.getParameter("councilId"));
            int lecturerId = Integer.parseInt(request.getParameter("lecturerId"));
            float scoreValue = Float.parseFloat(request.getParameter("score"));
            String comment = request.getParameter("comment");
            ReportScore score = new ReportScore(reportId, councilId, lecturerId, scoreValue, comment);
            scoreDAO.updateReportScore(score);
            response.sendRedirect("scores?action=list");
        } else {
            // Xử lý mặc định
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}