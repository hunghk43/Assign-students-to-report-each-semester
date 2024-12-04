package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    // Thông tin kết nối đến cơ sở dữ liệu
    private static  String URL = "jdbc:mysql://localhost:3306/web"; // Đảm bảo đường dẫn đúng
    private static final String USER = "root";  // Tên người dùng (username)
    private static final String PASSWORD = "1234567890";  // Mật khẩu (password)

    // Biến kết nối (Connection) dùng chung
    private static Connection connection = null;

    // Phương thức lấy kết nối đến cơ sở dữ liệu
    public static Connection getConnection() throws SQLException {
        try {
            // Đảm bảo rằng driver JDBC của MySQL được nạp vào
            if (connection == null || connection.isClosed()) {
                // Nạp driver JDBC cho MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Tạo kết nối mới tới cơ sở dữ liệu
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Kết nối thành công tới cơ sở dữ liệu.");
            }
        } catch (ClassNotFoundException e) {
            // Thông báo khi không tìm thấy driver
            System.err.println("Không tìm thấy driver JDBC: " + e.getMessage());
            throw new SQLException("Không thể nạp driver JDBC.", e);
        } catch (SQLException e) {
            // Nếu kết nối thất bại, in ra thông báo lỗi
            System.err.println("Kết nối thất bại: " + e.getMessage());
            throw e;
        }

        return connection;
    }

    // Phương thức kiểm tra kết nối trong phương thức main
    public static void main(String[] args) {
        try {
            // Lấy kết nối tới cơ sở dữ liệu
            Connection conn = DatabaseUtil.getConnection();
            if (conn != null) {
                System.out.println("Kết nối thành côngg!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi nếu có
        }
    }
}
