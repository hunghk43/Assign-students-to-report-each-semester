package model;
public class Student {
    private int studentId;
    private String fullName;
    private int year;
    private String major;
    private String studentClass;

    public Student(int studentId, String fullName, int year, String major, String studentClass) {
    this.studentId = studentId;
    this.fullName = fullName;
    this.year = year;
    this.major = major;
    this.studentClass = studentClass;
}


    // Getter và Setter đầy đủ
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
}
