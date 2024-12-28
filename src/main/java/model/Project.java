package model;

public class Project {
    private int projectId;
    private String projectName;
    private String description;
    private int semesterId;

    public Project() {
    }

    public Project(int projectId, String projectName, String description, int semesterId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.semesterId = semesterId;
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }
}