package carrental.dao;

import carrental.db.DBConnection;
import carrental.model.User;
import carrental.model.userRole;
import carrental.util.DBUtil;
import carrental.util.TimestampUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户DAO：负责users表的CRUD操作
 */
public class UserDAO {
    // 根据用户名查询用户（登录核心方法）
    public User findByUsername(String username) {
        String sql = "SELECT id, username, password, role FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection(); // 使用静态方法获取连接
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) { // 显式声明 ResultSet 关闭
                if (rs.next()) {
                    User user = new User();
                    user.setUserID(String.valueOf(rs.getInt("id")));       // 改正字段名匹配
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    String roleName = rs.getString("role");
                    try {
                        user.setRole(userRole.valueOf(roleName.toLowerCase()));
                    } catch (IllegalArgumentException ex) {
                        throw new SQLException("Invalid user role: " + roleName, ex);
                    }
                    return user;
                }
            }
        } catch (SQLException e) {
            // 替换 printStackTrace 为更安全的日志记录方式（假设已有 logger）
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Database error occurred while finding user by username.");
            e.printStackTrace(); // 生产环境应替换为 logger.error(e.getMessage(), e);
        }
        return null; // 未找到用户
    }

    // 添加用户（管理员功能）
    public boolean insert(User user) {
        String sql = "INSERT INTO users (id, username, password, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole().name());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to insert user into database.");
            e.printStackTrace(); // 同样建议替换为日志记录
            return false;
        }
    }

    // 删除用户（管理员功能）
    public boolean delete(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to delete user from database.");
            e.printStackTrace(); // 同样建议替换为日志记录
            return false;
        }
    }
    
    public boolean register(User user) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (id, username, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserID());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole().name());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(userRole.valueOf(rs.getString("role").toLowerCase()));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 更新员工ID
    public boolean updateStaffId(int userId, String newId) {
        String sql = "UPDATE users SET id = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newId);
            pstmt.setInt(2, userId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to update staff ID.");
            e.printStackTrace();
            return false;
        }
    }

    // 更新用户名
    public boolean updateUsername(int userId, String newUsername) {
        String sql = "UPDATE users SET username = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newUsername);
            pstmt.setInt(2, userId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to update username.");
            e.printStackTrace();
            return false;
        }
    }

    // 更新角色
    public boolean updateRole(int userId, String newRole) {
        String sql = "UPDATE users SET role = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newRole.toUpperCase());
            pstmt.setInt(2, userId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(TimestampUtil.getCurrentTimestamp() + " Failed to update role.");
            e.printStackTrace();
            return false;
        }
    }
}