package model;

public class Lecturer {
    private int lecturerId;
    private int userId;
    private String fullName;
    private String department;
    private String email;
    private String phone;

    public Lecturer() {
    }

    public Lecturer(int lecturerId, int userId, String fullName, String department, String email, String phone) {
        this.lecturerId = lecturerId;
        this.userId = userId;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}