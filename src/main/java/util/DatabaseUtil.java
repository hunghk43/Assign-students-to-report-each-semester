package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static  String URL = "jdbc:mysql://localhost:3306/web"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "1234567890";  

    private static Connection connection = null;

   
    public static Connection getConnection() throws SQLException {
        try {
          
            if (connection == null || connection.isClosed()) {
              
                Class.forName("com.mysql.cj.jdbc.Driver");

             
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối thành công tới cơ sở dữ liệu.");
            }
        } catch (ClassNotFoundException e) {
          
            System.err.println("Không tìm thấy driver JDBC: " + e.getMessage());
            throw new SQLException("Không thể nạp driver JDBC.", e);
        } catch (SQLException e) {
        
            System.err.println("Kết nối thất bại: " + e.getMessage());
            throw e;
        }

        return connection;
    }

 
    public static void main(String[] args) {
        try {
           
            Connection conn = DatabaseUtil.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành côngg!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}
