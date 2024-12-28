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
            request.getRequestDispatcher("reports/editReport.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Report> reports = reportDAO.getAllReports();
            request.setAttribute("reports", reports);
            request.getRequestDispatcher("reports/listReports.jsp").forward(request, response);
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
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            String reportTopic = request.getParameter("reportTopic");
            String dateString = request.getParameter("submissionDate");
            String reportFilePath = request.getParameter("reportFilePath");

             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             Date submissionDate = null;
             try {
                 submissionDate = formatter.parse(dateString);
             } catch (ParseException e) {
                 e.printStackTrace();
                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
                 return;
             }

             Report report = new Report(0, projectId, submissionDate, reportFilePath);
             reportDAO.addReport(report);
             response.sendRedirect("reports?action=list");
        } else if ("update".equals(action)) {
             int reportId = Integer.parseInt(request.getParameter("reportId"));
             int projectId = Integer.parseInt(request.getParameter("projectId"));
             String reportTopic = request.getParameter("reportTopic");
             String dateString = request.getParameter("submissionDate");
             String reportFilePath = request.getParameter("reportFilePath");

             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             Date submissionDate = null;
             try {
                 submissionDate = formatter.parse(dateString);
             } catch (ParseException e) {
                 e.printStackTrace();
                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
                 return;
             }

             Report report = new Report(reportId, projectId, submissionDate, reportFilePath);
             reportDAO.updateReport(report);
             response.sendRedirect("reports?action=list");
        } else {
             // Xử lí mặc định
             response.sendRedirect(request.getContextPath() + "/");
        }
    }
}