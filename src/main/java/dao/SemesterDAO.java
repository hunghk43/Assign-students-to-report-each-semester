package dao;

import model.Semester;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SemesterDAO {

    public void addSemester(Semester semester) {
        String query = "INSERT INTO Semesters (semester_name, academic_year) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, semester.getSemesterName());
            statement.setString(2, semester.getAcademicYear());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    semester.setSemesterId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSemester(Semester semester) {
        String query = "UPDATE Semesters SET semester_name = ?, academic_year = ? WHERE semester_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, semester.getSemesterName());
            statement.setString(2, semester.getAcademicYear());
            statement.setInt(3, semester.getSemesterId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSemester(int semesterId) {
        String query = "DELETE FROM Semesters WHERE semester_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, semesterId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Semester getSemesterById(int semesterId) {
        String query = "SELECT * FROM Semesters WHERE semester_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, semesterId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Semester(
                            resultSet.getInt("semester_id"),
                            resultSet.getString("semester_name"),
                            resultSet.getString("academic_year")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Semester> getAllSemesters() {
        List<Semester> semesters = new ArrayList<>();
        String query = "SELECT * FROM Semesters";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                semesters.add(new Semester(
                        resultSet.getInt("semester_id"),
                        resultSet.getString("semester_name"),
                        resultSet.getString("academic_year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesters;
    }
}