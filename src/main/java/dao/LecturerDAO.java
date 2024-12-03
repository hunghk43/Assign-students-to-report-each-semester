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
                        resultSet.getString("full_name"),
                        resultSet.getString("department")
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
                            resultSet.getString("full_name"),
                            resultSet.getString("department")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addLecturer(Lecturer lecturer) {
        String query = "INSERT INTO Lecturers (full_name, department) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lecturer.getFullName());
            statement.setString(2, lecturer.getDepartment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLecturer(Lecturer lecturer) {
        String query = "UPDATE Lecturers SET full_name = ?, department = ? WHERE lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lecturer.getFullName());
            statement.setString(2, lecturer.getDepartment());
            statement.setInt(3, lecturer.getLecturerId());
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
