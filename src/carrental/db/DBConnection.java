package carrental.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类：提供SQLite连接（无需额外配置）
 */
public class DBConnection {
    // SQLite数据库文件（项目根目录下）
    private static final String URL = "jdbc:sqlite:car_rental.db";

    // 加载SQLite驱动
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite驱动加载失败", e);
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
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
}