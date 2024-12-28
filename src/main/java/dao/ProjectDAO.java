package dao;

import model.Project;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    public void addProject(Project project) {
        String query = "INSERT INTO Projects (project_name, description, semester_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getSemesterId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    project.setProjectId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProject(Project project) {
        String query = "UPDATE Projects SET project_name = ?, description = ?, semester_id = ? WHERE project_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getSemesterId());
            statement.setInt(4, project.getProjectId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProject(int projectId) {
        String query = "DELETE FROM Projects WHERE project_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Project getProjectById(int projectId) {
        String query = "SELECT * FROM Projects WHERE project_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Project(
                            resultSet.getInt("project_id"),
                            resultSet.getString("project_name"),
                            resultSet.getString("description"),
                            resultSet.getInt("semester_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM Projects";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("semester_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}