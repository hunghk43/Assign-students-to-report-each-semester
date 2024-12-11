package Controller;

import dao.ReportDAO;
import model.Report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/reports")
public class ReportController extends HttpServlet {
    private ReportDAO reportDAO;

    @Override
    public void init() {
        reportDAO = new ReportDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int reportId = Integer.parseInt(request.getParameter("id"));
            reportDAO.deleteReport(reportId);
            response.sendRedirect("reports");
        } else if ("edit".equals(action)) {
            int reportId = Integer.parseInt(request.getParameter("id"));
            Report report = reportDAO.getReportById(reportId);
            request.setAttribute("report", report);
            request.getRequestDispatcher("editReport.jsp").forward(request, response);
        } else {
            List<Report> reports = reportDAO.getAllReports();
            request.setAttribute("reports", reports);
            request.getRequestDispatcher("reports.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String reportIdParam = request.getParameter("reportId");
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int committeeId = Integer.parseInt(request.getParameter("committeeId"));
        String reportTopic = request.getParameter("reportTopic");
        String dateString = request.getParameter("submissionDate");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date submissionDate = null;
        try {
            submissionDate = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the error appropriately. For instance, you can send an error response.
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
            return;
        }

        if (reportIdParam != null && !reportIdParam.isEmpty()) {
            // Update existing report
            int reportId = Integer.parseInt(reportIdParam);
            Report report = new Report(reportId, studentId, committeeId, reportTopic, submissionDate);
            reportDAO.updateReport(report);
        } else {
            // Add new report
            Report report = new Report(0, studentId, committeeId, reportTopic, submissionDate);
            reportDAO.addReport(report);
        }

        response.sendRedirect("reports");
    }
}