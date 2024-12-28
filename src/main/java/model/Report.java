package model;

import java.util.Date;

public class Report {
    private int reportId;
    private int projectId;
    private Date submissionDate;
    private String reportFilePath;

    public Report() {
    }

    public Report(int reportId, int projectId, Date submissionDate, String reportFilePath) {
        this.reportId = reportId;
        this.projectId = projectId;
        this.submissionDate = submissionDate;
        this.reportFilePath = reportFilePath;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getReportFilePath() {
        return reportFilePath;
    }

    public void setReportFilePath(String reportFilePath) {
        this.reportFilePath = reportFilePath;
    }
}