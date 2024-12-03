package dao;

import model.Student;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Lấy danh sách tất cả sinh viên
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT student_id, full_name, year, major, StudentClass FROM Students";  // Đổi cột 'class' thành 'StudentClass'
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("student_id"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("year"),
                        resultSet.getString("major"),
                        resultSet.getString("StudentClass") // Truy xuất cột StudentClass
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Lấy thông tin sinh viên theo ID
    public Student getStudentById(int studentId) {
        String query = "SELECT student_id, full_name, year, major, StudentClass FROM Students WHERE student_id = ?"; // Đổi cột 'class' thành 'StudentClass'
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("full_name"),
                            resultSet.getInt("year"),
                            resultSet.getString("major"),
                            resultSet.getString("StudentClass") // Truy xuất cột StudentClass
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm mới sinh viên
    public void addStudent(Student student) {
        String query = "INSERT INTO Students (full_name, year, major, StudentClass) VALUES (?, ?, ?, ?)";  // Đổi cột 'class' thành 'StudentClass'
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFullName());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getMajor());
            statement.setString(4, student.getStudentClass());  // Gọi phương thức getStudentClass()
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin sinh viên
    public void updateStudent(Student student) {
        String query = "UPDATE Students SET full_name = ?, year = ?, major = ?, StudentClass = ? WHERE student_id = ?";  // Đổi cột 'class' thành 'StudentClass'
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFullName());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getMajor());
            statement.setString(4, student.getStudentClass());  // Gọi phương thức getStudentClass()
            statement.setInt(5, student.getStudentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE student_id = ?";  // Đổi cột 'class' thành 'StudentClass' không cần thiết ở đây, vì cột ID không thay đổi
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
