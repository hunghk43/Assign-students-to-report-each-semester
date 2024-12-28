package dao;

import model.Student;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("year"),
                        resultSet.getString("major"),
                        resultSet.getString("class"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentById(int studentId) {
        String query = "SELECT * FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("full_name"),
                            resultSet.getInt("year"),
                            resultSet.getString("major"),
                            resultSet.getString("class"),
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

    public void addStudent(Student student) {
        String query = "INSERT INTO Students (user_id, full_name, year, major, class, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, student.getUserId());
            statement.setString(2, student.getFullName());
            statement.setInt(3, student.getYear());
            statement.setString(4, student.getMajor());
            statement.setString(5, student.getStudentClass());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getPhone());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    student.setStudentId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String query = "UPDATE Students SET user_id = ?, full_name = ?, year = ?, major = ?, class = ?, email = ?, phone = ? WHERE student_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, student.getUserId());
            statement.setString(2, student.getFullName());
            statement.setInt(3, student.getYear());
            statement.setString(4, student.getMajor());
            statement.setString(5, student.getStudentClass());
            statement.setString(6, student.getEmail());
            statement.setString(7, student.getPhone());
            statement.setInt(8, student.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}