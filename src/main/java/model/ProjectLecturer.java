package model;

public class ProjectLecturer {
    private int projectId;
    private int studentId;
    private int lecturerId;

    public ProjectLecturer() {
    }

    public ProjectLecturer(int projectId, int studentId, int lecturerId) {
        this.projectId = projectId;
        this.studentId = studentId;
        this.lecturerId = lecturerId;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }
}