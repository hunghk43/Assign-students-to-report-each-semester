package model;

public class CouncilAssignment {
    private int councilId;
    private int projectId;
    private int lecturerId;

    public CouncilAssignment() {
    }

    public CouncilAssignment(int councilId, int projectId, int lecturerId) {
        this.councilId = councilId;
        this.projectId = projectId;
        this.lecturerId = lecturerId;
    }

    // Getters and Setters
    public int getCouncilId() {
        return councilId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }
}