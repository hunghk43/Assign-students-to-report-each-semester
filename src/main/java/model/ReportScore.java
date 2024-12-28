package model;

public class ReportScore {
    private int reportId;
    private int councilId;
    private int lecturerId;
    private float score;
    private String comment;

    public ReportScore() {
    }

    public ReportScore(int reportId, int councilId, int lecturerId, float score, String comment) {
        this.reportId = reportId;
        this.councilId = councilId;
        this.lecturerId = lecturerId;
        this.score = score;
        this.comment = comment;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getCouncilId() {
        return councilId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}