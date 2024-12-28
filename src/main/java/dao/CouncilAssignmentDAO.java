package dao;

import model.CouncilAssignment;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouncilAssignmentDAO {

    public void addCouncilAssignment(CouncilAssignment councilAssignment) {
        String query = "INSERT INTO Council_Assignments (council_id, project_id, lecturer_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilAssignment.getCouncilId());
            statement.setInt(2, councilAssignment.getProjectId());
            statement.setInt(3, councilAssignment.getLecturerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCouncilAssignment(CouncilAssignment councilAssignment) {
        String query = "UPDATE Council_Assignments SET project_id = ?, lecturer_id = ? WHERE council_id = ? AND project_id = ? AND lecturer_id=?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilAssignment.getProjectId());
            statement.setInt(2, councilAssignment.getLecturerId());
            statement.setInt(3, councilAssignment.getCouncilId());
            statement.setInt(4, councilAssignment.getProjectId());
            statement.setInt(5, councilAssignment.getLecturerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCouncilAssignment(int councilId, int projectId, int lecturerId) {
        String query = "DELETE FROM Council_Assignments WHERE council_id = ? AND project_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilId);
            statement.setInt(2, projectId);
            statement.setInt(3, lecturerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CouncilAssignment getCouncilAssignmentById(int councilId, int projectId, int lecturerId) {
        String query = "SELECT * FROM Council_Assignments WHERE council_id = ? AND project_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilId);
            statement.setInt(2, projectId);
            statement.setInt(3, lecturerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new CouncilAssignment(
                            resultSet.getInt("council_id"),
                            resultSet.getInt("project_id"),
                            resultSet.getInt("lecturer_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CouncilAssignment> getAllCouncilAssignments() {
        List<CouncilAssignment> councilAssignments = new ArrayList<>();
        String query = "SELECT * FROM Council_Assignments";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                councilAssignments.add(new CouncilAssignment(
                        resultSet.getInt("council_id"),
                        resultSet.getInt("project_id"),
                        resultSet.getInt("lecturer_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return councilAssignments;
    }
}