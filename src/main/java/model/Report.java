package model;

import dao.StudentDAO;
import dao.CommitteeDAO;

import java.util.Date;

public class Report {
    private int reportId;
    private int studentId;
    private int committeeId;
    private String reportTopic;
    private Date submissionDate;

    // Constructor
    public Report() {}

    public Report(int reportId, int studentId, int committeeId, String reportTopic, Date submissionDate) {
        this.reportId = reportId;
        this.studentId = studentId;
        this.committeeId = committeeId;
        this.reportTopic = reportTopic;
        this.submissionDate = submissionDate;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public String getReportTopic() {
        return reportTopic;
    }

    public void setReportTopic(String reportTopic) {
        this.reportTopic = reportTopic;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    // Phương thức lấy thông tin sinh viên
    public Student getStudent() {
        StudentDAO studentDAO = new StudentDAO();
        return studentDAO.getStudentById(this.studentId);  // Giả sử bạn có phương thức getStudentById trong StudentDAO
    }

    // Phương thức lấy thông tin hội đồng
    public Committee getCommittee() {
        CommitteeDAO committeeDAO = new CommitteeDAO();
        return committeeDAO.getCommitteeById(this.committeeId);  // Giả sử bạn có phương thức getCommitteeById trong CommitteeDAO
    }
}
