package model;

public class Council {
    private int councilId;
    private String councilName;
    private int semesterId;

    public Council() {
    }

    public Council(int councilId, String councilName, int semesterId) {
        this.councilId = councilId;
        this.councilName = councilName;
        this.semesterId = semesterId;
    }

    // Getters and Setters
    public int getCouncilId() {
        return councilId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}
