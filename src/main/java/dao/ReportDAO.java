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
                        resultSet.getInt("project_id"),
                        resultSet.getDate("submission_date"),
                        resultSet.getString("report_file_path")
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
                            resultSet.getInt("project_id"),
                            resultSet.getDate("submission_date"),
                            resultSet.getString("report_file_path")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addReport(Report report) {
        String query = "INSERT INTO Reports (project_id, submission_date, report_file_path) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, report.getProjectId());
            statement.setDate(2, new java.sql.Date(report.getSubmissionDate().getTime()));
            statement.setString(3, report.getReportFilePath());
            statement.executeUpdate();

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
        String query = "UPDATE Reports SET project_id = ?, submission_date = ?, report_file_path = ? WHERE report_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, report.getProjectId());
            statement.setDate(2, new java.sql.Date(report.getSubmissionDate().getTime()));
            statement.setString(3, report.getReportFilePath());
            statement.setInt(4, report.getReportId());
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