package Controller;

import dao.*;
import model.*;
import util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/reports")
public class ReportController extends HttpServlet {
    private ReportDAO reportDAO;

    @Override
    public void init() {
        reportDAO = new ReportDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reportId = request.getParameter("id");
        if (reportId != null) {
            Report report = reportDAO.getReportById(Integer.parseInt(reportId));
            JsonUtil.writeJsonResponse(response, report);
        } else {
            List<Report> reports = reportDAO.getAllReports();
            JsonUtil.writeJsonResponse(response, reports);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Report report = JsonUtil.readJsonRequest(request, Report.class);
        reportDAO.addReport(report);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Report report = JsonUtil.readJsonRequest(request, Report.class);
        reportDAO.updateReport(report);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reportId = Integer.parseInt(request.getParameter("id"));
        reportDAO.deleteReport(reportId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
