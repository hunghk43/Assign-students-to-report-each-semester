package dao;

import model.LecturerAssignment;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LecturerAssignmentDAO {

    public List<LecturerAssignment> getAllAssignments() {
        List<LecturerAssignment> assignments = new ArrayList<>();
        String query = "SELECT * FROM Lecturer_Assignments";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                assignments.add(new LecturerAssignment(
                        resultSet.getInt("assignment_id"),
                        resultSet.getInt("lecturer_id"),
                        resultSet.getInt("council_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }

    public LecturerAssignment getAssignmentById(int assignmentId) {
        String query = "SELECT * FROM Lecturer_Assignments WHERE assignment_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, assignmentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new LecturerAssignment(
                            resultSet.getInt("assignment_id"),
                            resultSet.getInt("lecturer_id"),
                            resultSet.getInt("council_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addAssignment(LecturerAssignment assignment) {
        String query = "INSERT INTO Lecturer_Assignments (lecturer_id, council_id) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, assignment.getLecturerId());
            statement.setInt(2, assignment.getCouncilId());
            statement.executeUpdate();

        
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    assignment.setAssignmentId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAssignment(LecturerAssignment assignment) {
        String query = "UPDATE Lecturer_Assignments SET lecturer_id = ?, council_id = ? WHERE assignment_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, assignment.getLecturerId());
            statement.setInt(2, assignment.getCouncilId());
            statement.setInt(3, assignment.getAssignmentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAssignment(int assignmentId) {
        String query = "DELETE FROM Lecturer_Assignments WHERE assignment_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, assignmentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
