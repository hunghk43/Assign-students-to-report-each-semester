package model;
public class Lecturer {
    private int lecturerId;
    private String fullName;
    private String department;

    // Constructors
    public Lecturer() {}

    public Lecturer(int lecturerId, String fullName, String department) {
        this.lecturerId = lecturerId;
        this.fullName = fullName;
        this.department = department;
    }

    // Getters and Setters
    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
