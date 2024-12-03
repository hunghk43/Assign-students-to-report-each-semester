package model;
public class Committee {
    private int committeeId;
    private String committeeName;
    private int academicYear;

    // Constructors
    public Committee() {}

    public Committee(int committeeId, String committeeName, int academicYear) {
        this.committeeId = committeeId;
        this.committeeName = committeeName;
        this.academicYear = academicYear;
    }

    // Getters and Setters
    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }
}
