package model;

import dao.LecturerDAO;
import dao.CommitteeDAO;

public class LecturerAssignment {
    private int assignmentId;
    private int lecturerId;
    private int committeeId;

    // Constructors
    public LecturerAssignment() {}

    public LecturerAssignment(int assignmentId, int lecturerId, int committeeId) {
        this.assignmentId = assignmentId;
        this.lecturerId = lecturerId;
        this.committeeId = committeeId;
    }

    // Getters and Setters
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    // Phương thức getLecturer() để lấy thông tin giảng viên
    public Lecturer getLecturer() {
        LecturerDAO lecturerDAO = new LecturerDAO();
        return lecturerDAO.getLecturerById(this.lecturerId);  // Lấy giảng viên từ lecturerId
    }

    // Phương thức getCommittee() để lấy thông tin hội đồng
    public Committee getCommittee() {
        CommitteeDAO committeeDAO = new CommitteeDAO();
        return committeeDAO.getCommitteeById(this.committeeId);  // Lấy hội đồng từ committeeId
    }
}
