package carrental.db;

import carrental.util.TimestampUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类：提供MySQL连接
 */
public class DBConnection {
    // MySQL数据库连接参数
    private static final String URL = "jdbc:mysql://localhost:3306/Car_Rental_Management_System_DB?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 加载MySQL驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to load MySQL driver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 关闭连接
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 检查数据库连接是否成功
    public static boolean isConnectionSuccessful() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Database connection failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}