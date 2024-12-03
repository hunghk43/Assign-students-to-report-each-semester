package dao;

import model.Committee;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommitteeDAO {

    public List<Committee> getAllCommittees() {
        List<Committee> committees = new ArrayList<>();
        String query = "SELECT * FROM Committees";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                committees.add(new Committee(
                        resultSet.getInt("committee_id"),
                        resultSet.getString("committee_name"),
                        resultSet.getInt("academic_year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return committees;
    }

    public Committee getCommitteeById(int committeeId) {
        String query = "SELECT * FROM Committees WHERE committee_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, committeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Committee(
                            resultSet.getInt("committee_id"),
                            resultSet.getString("committee_name"),
                            resultSet.getInt("academic_year")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCommittee(Committee committee) {
        String query = "INSERT INTO Committees (committee_name, academic_year) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, committee.getCommitteeName());
            statement.setInt(2, committee.getAcademicYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCommittee(Committee committee) {
        String query = "UPDATE Committees SET committee_name = ?, academic_year = ? WHERE committee_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, committee.getCommitteeName());
            statement.setInt(2, committee.getAcademicYear());
            statement.setInt(3, committee.getCommitteeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommittee(int committeeId) {
        String query = "DELETE FROM Committees WHERE committee_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, committeeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
