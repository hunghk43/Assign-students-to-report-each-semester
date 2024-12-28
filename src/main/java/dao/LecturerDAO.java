package dao;

import model.Lecturer;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LecturerDAO {

    public List<Lecturer> getAllLecturers() {
        List<Lecturer> lecturers = new ArrayList<>();
        String query = "SELECT * FROM Lecturers";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                lecturers.add(new Lecturer(
                        resultSet.getInt("lecturer_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("department"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturers;
    }

    public Lecturer getLecturerById(int lecturerId) {
        String query = "SELECT * FROM Lecturers WHERE lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lecturerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Lecturer(
                            resultSet.getInt("lecturer_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("full_name"),
                            resultSet.getString("department"),
                            resultSet.getString("email"),
                            resultSet.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addLecturer(Lecturer lecturer) {
        String query = "INSERT INTO Lecturers (user_id, full_name, department, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, lecturer.getUserId());
            statement.setString(2, lecturer.getFullName());
            statement.setString(3, lecturer.getDepartment());
            statement.setString(4, lecturer.getEmail());
            statement.setString(5, lecturer.getPhone());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    lecturer.setLecturerId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLecturer(Lecturer lecturer) {
        String query = "UPDATE Lecturers SET user_id = ?, full_name = ?, department = ?, email = ?, phone = ? WHERE lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lecturer.getUserId());
            statement.setString(2, lecturer.getFullName());
            statement.setString(3, lecturer.getDepartment());
            statement.setString(4, lecturer.getEmail());
            statement.setString(5, lecturer.getPhone());
            statement.setInt(6, lecturer.getLecturerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLecturer(int lecturerId) {
        String query = "DELETE FROM Lecturers WHERE lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lecturerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}