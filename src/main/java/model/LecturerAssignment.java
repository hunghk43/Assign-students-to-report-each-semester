package model;

import dao.LecturerDAO;
import dao.CouncilDAO;

public class LecturerAssignment {
    private int assignmentId;
    private int lecturerId;
    private int councilId;

   
    public LecturerAssignment() {}

    public LecturerAssignment(int assignmentId, int lecturerId, int councilId) {
        this.assignmentId = assignmentId;
        this.lecturerId = lecturerId;
        this.councilId = councilId;
    }


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

    public int getCouncilId() {
        return councilId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }


    public Lecturer getLecturer() {
        LecturerDAO lecturerDAO = new LecturerDAO();
        return lecturerDAO.getLecturerById(this.lecturerId);  
    }

   
    public Council getCouncil() {
        CouncilDAO councilDAO = new CouncilDAO();
        return councilDAO.getCouncilById(this.councilId);  
    }
}
