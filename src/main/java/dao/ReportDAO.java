package dao;

import model.Report;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM Reports";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                reports.add(new Report(
                        resultSet.getInt("report_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("committee_id"),
                        resultSet.getString("report_topic"),
                        resultSet.getDate("submission_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public Report getReportById(int reportId) {
        String query = "SELECT * FROM Reports WHERE report_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Report(
                            resultSet.getInt("report_id"),
                            resultSet.getInt("student_id"),
                            resultSet.getInt("committee_id"),
                            resultSet.getString("report_topic"),
                            resultSet.getDate("submission_date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addReport(Report report) {
        String query = "INSERT INTO Reports (student_id, committee_id, report_topic, submission_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, report.getStudentId());
            statement.setInt(2, report.getCommitteeId());
            statement.setString(3, report.getReportTopic());
            statement.setDate(4, new java.sql.Date(report.getSubmissionDate().getTime())); // Chuyển đổi Date
            statement.executeUpdate();

            // Lấy report_id tự động tạo
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    report.setReportId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReport(Report report) {
        String query = "UPDATE Reports SET student_id = ?, committee_id = ?, report_topic = ?, submission_date = ? WHERE report_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, report.getStudentId());
            statement.setInt(2, report.getCommitteeId());
            statement.setString(3, report.getReportTopic());
            statement.setDate(4, new java.sql.Date(report.getSubmissionDate().getTime())); // Chuyển đổi Date
            statement.setInt(5, report.getReportId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReport(int reportId) {
        String query = "DELETE FROM Reports WHERE report_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
