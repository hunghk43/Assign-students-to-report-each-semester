package dao;

import model.ReportScore;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportScoreDAO {

    public void addReportScore(ReportScore reportScore) {
        String query = "INSERT INTO Report_Scores (report_id, council_id, lecturer_id, score, comment) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportScore.getReportId());
            statement.setInt(2, reportScore.getCouncilId());
            statement.setInt(3, reportScore.getLecturerId());
            statement.setFloat(4, reportScore.getScore());
            statement.setString(5, reportScore.getComment());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReportScore(ReportScore reportScore) {
        String query = "UPDATE Report_Scores SET score = ?, comment = ? WHERE report_id = ? AND council_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setFloat(1, reportScore.getScore());
            statement.setString(2, reportScore.getComment());
            statement.setInt(3, reportScore.getReportId());
            statement.setInt(4, reportScore.getCouncilId());
            statement.setInt(5, reportScore.getLecturerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReportScore(int reportId, int councilId, int lecturerId) {
        String query = "DELETE FROM Report_Scores WHERE report_id = ? AND council_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportId);
            statement.setInt(2, councilId);
            statement.setInt(3, lecturerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ReportScore getReportScoreById(int reportId, int councilId, int lecturerId) {
        String query = "SELECT * FROM Report_Scores WHERE report_id = ? AND council_id = ? AND lecturer_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reportId);
            statement.setInt(2, councilId);
            statement.setInt(3, lecturerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new ReportScore(
                            resultSet.getInt("report_id"),
                            resultSet.getInt("council_id"),
                            resultSet.getInt("lecturer_id"),
                            resultSet.getFloat("score"),
                            resultSet.getString("comment")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ReportScore> getAllReportScores() {
        List<ReportScore> reportScores = new ArrayList<>();
        String query = "SELECT * FROM Report_Scores";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                reportScores.add(new ReportScore(
                        resultSet.getInt("report_id"),
                        resultSet.getInt("council_id"),
                        resultSet.getInt("lecturer_id"),
                        resultSet.getFloat("score"),
                        resultSet.getString("comment")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportScores;
    }
}