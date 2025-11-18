package carrental.dao;

import carrental.db.DBConnection;
import carrental.model.SystemLog;
import carrental.db.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogDAO {
    // 插入日志记录
    public boolean insert(SystemLog log) {
        String sql = "INSERT INTO system_logs " +
                "(username, operation_type, operation_details, operation_time, ip_address, result) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, log.getUsername());
            pstmt.setString(2, log.getOperationType());
            pstmt.setString(3, log.getOperationDetails());
            pstmt.setTimestamp(4, Timestamp.valueOf(log.getOperationTime()));
            pstmt.setString(5, log.getIpAddress());
            pstmt.setString(6, log.getResult());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 查询所有日志
    public List<SystemLog> getAllLogs() {
        List<SystemLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM system_logs ORDER BY operation_time DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                SystemLog log = new SystemLog(
                        rs.getString("username"),
                        rs.getString("operation_type"),
                        rs.getString("operation_details"),
                        rs.getString("ip_address"),
                        rs.getString("result")
                );
                log.setLogId(rs.getInt("log_id"));
                log.setOperationTime(rs.getTimestamp("operation_time").toLocalDateTime());
                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    // 按条件筛选日志
    public List<SystemLog> getLogsByFilter(String username, LocalDateTime startDate, LocalDateTime endDate) {
        List<SystemLog> logs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM system_logs WHERE 1=1");

        if (username != null && !username.isEmpty()) {
            sql.append(" AND username = ?");
        }
        if (startDate != null) {
            sql.append(" AND operation_time >= ?");
        }
        if (endDate != null) {
            sql.append(" AND operation_time <= ?");
        }
        sql.append(" ORDER BY operation_time DESC");

        DBConnection DBConnection = new DBConnection();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;
            if (username != null && !username.isEmpty()) {
                pstmt.setString(paramIndex++, username);
            }
            if (startDate != null) {
                pstmt.setTimestamp(paramIndex++, Timestamp.valueOf(startDate));
            }
            if (endDate != null) {
                pstmt.setTimestamp(paramIndex++, Timestamp.valueOf(endDate));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SystemLog log = new SystemLog(
                            rs.getString("username"),
                            rs.getString("operation_type"),
                            rs.getString("operation_details"),
                            rs.getString("ip_address"),
                            rs.getString("result")
                    );
                    log.setLogId(rs.getInt("log_id"));
                    log.setOperationTime(rs.getTimestamp("operation_time").toLocalDateTime());
                    logs.add(log);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }
}
