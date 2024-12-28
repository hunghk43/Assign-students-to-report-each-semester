package model;

public class Student {
    private int studentId;
    private int userId;
    private String fullName;
    private int year;
    private String major;
    private String studentClass;
    private String email;
    private String phone;

    public Student() {
    }

    public Student(int studentId, int userId, String fullName, int year, String major, String studentClass, String email, String phone) {
        this.studentId = studentId;
        this.userId = userId;
        this.fullName = fullName;
        this.year = year;
        this.major = major;
        this.studentClass = studentClass;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
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