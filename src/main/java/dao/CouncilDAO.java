package dao;

import model.Council;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouncilDAO {

    public void addCouncil(Council council) {
        String query = "INSERT INTO Councils (council_name, semester_id) VALUES (?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, council.getCouncilName());
            statement.setInt(2, council.getSemesterId());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    council.setCouncilId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCouncil(Council council) {
        String query = "UPDATE Councils SET council_name = ?, semester_id = ? WHERE council_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, council.getCouncilName());
            statement.setInt(2, council.getSemesterId());
            statement.setInt(3, council.getCouncilId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCouncil(int councilId) {
        String query = "DELETE FROM Councils WHERE council_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Council getCouncilById(int councilId) {
        String query = "SELECT * FROM Councils WHERE council_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, councilId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Council(
                            resultSet.getInt("council_id"),
                            resultSet.getString("council_name"),
                            resultSet.getInt("semester_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Council> getAllCouncils() {
        List<Council> councils = new ArrayList<>();
        String query = "SELECT * FROM Councils";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                councils.add(new Council(
                        resultSet.getInt("council_id"),
                        resultSet.getString("council_name"),
                        resultSet.getInt("semester_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return councils;
    }
}