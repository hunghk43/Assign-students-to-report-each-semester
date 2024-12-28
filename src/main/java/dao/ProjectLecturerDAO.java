package dao;

import model.ProjectLecturer;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectLecturerDAO {

    public void addProjectLecturer(ProjectLecturer projectLecturer) {
        String query = "INSERT INTO Project_Lecturers (project_id, student_id, lecturer_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectLecturer.getProjectId());
            statement.setInt(2, projectLecturer.getStudentId());
            statement.setInt(3, projectLecturer.getLecturerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProjectLecturer(ProjectLecturer projectLecturer) {
        String query = "UPDATE Project_Lecturers SET lecturer_id = ? WHERE project_id = ? AND student_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectLecturer.getLecturerId());
            statement.setInt(2, projectLecturer.getProjectId());
            statement.setInt(3, projectLecturer.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProjectLecturer(int projectId, int studentId, int lecturerId) {
        String query = "DELETE FROM Project_Lecturers WHERE project_id = ? AND student_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            statement.setInt(2, studentId);
            statement.setInt(3, lecturerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProjectLecturer getProjectLecturerById(int projectId, int studentId, int lecturerId) {
        String query = "SELECT * FROM Project_Lecturers WHERE project_id = ? AND student_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, projectId);
            statement.setInt(2, studentId);
            statement.setInt(3, lecturerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new ProjectLecturer(
                            resultSet.getInt("project_id"),
                            resultSet.getInt("student_id"),
                            resultSet.getInt("lecturer_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProjectLecturer> getAllProjectLecturers() {
        List<ProjectLecturer> projectLecturers = new ArrayList<>();
        String query = "SELECT * FROM Project_Lecturers";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                projectLecturers.add(new ProjectLecturer(
                        resultSet.getInt("project_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("lecturer_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectLecturers;
    }
}