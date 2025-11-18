package carrental.dao;

import carrental.model.VehicleStatus;
import carrental.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆状态DAO类
 */
public class VehicleStatusDAO {

    /**
     * 插入新的车辆状态记录
     * @param vehicleStatus 车辆状态对象
     * @return 是否插入成功
     */
    public boolean insert(VehicleStatus vehicleStatus) {
        String sql = "INSERT INTO vehicle_status (car_id, rental_id, status, notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicleStatus.getCarId());
            if (vehicleStatus.getRentalId() != null) {
                pstmt.setInt(2, vehicleStatus.getRentalId());
            } else {
                pstmt.setNull(2, java.sql.Types.INTEGER);
            }
            pstmt.setString(3, vehicleStatus.getStatus());
            pstmt.setString(4, vehicleStatus.getNotes());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据车辆ID查询最新的状态记录
     * @param carId 车辆ID
     * @return 最新的车辆状态记录
     */
    public VehicleStatus findLatestByCarId(String carId) {
        String sql = "SELECT * FROM vehicle_status WHERE car_id = ? ORDER BY updated_at DESC LIMIT 1";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, carId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractVehicleStatusFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据租赁ID查询状态记录
     * @param rentalId 租赁ID
     * @return 状态记录列表
     */
    public List<VehicleStatus> findByRentalId(int rentalId) {
        List<VehicleStatus> statusList = new ArrayList<>();
        String sql = "SELECT * FROM vehicle_status WHERE rental_id = ? ORDER BY updated_at DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rentalId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    statusList.add(extractVehicleStatusFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusList;
    }

    /**
     * 更新车辆状态记录
     * @param vehicleStatus 车辆状态对象
     * @return 是否更新成功
     */
    public boolean update(VehicleStatus vehicleStatus) {
        String sql = "UPDATE vehicle_status SET status = ?, notes = ?, updated_at = NOW() WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicleStatus.getStatus());
            pstmt.setString(2, vehicleStatus.getNotes());
            pstmt.setInt(3, vehicleStatus.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从ResultSet中提取VehicleStatus对象
     * @param rs ResultSet对象
     * @return VehicleStatus对象
     * @throws SQLException
     */
    private VehicleStatus extractVehicleStatusFromResultSet(ResultSet rs) throws SQLException {
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setId(rs.getInt("id"));
        vehicleStatus.setCarId(rs.getString("car_id"));

        // 正确的空值检查方式
        rs.getInt("rental_id");
        if (!rs.wasNull()) {
            vehicleStatus.setRentalId(rs.getInt("rental_id"));
        }

        vehicleStatus.setStatus(rs.getString("status"));
        vehicleStatus.setNotes(rs.getString("notes"));

        // 处理时间戳
        java.sql.Timestamp createdTimestamp = rs.getTimestamp("created_at");
        if (createdTimestamp != null) {
            vehicleStatus.setCreatedAt(createdTimestamp.toLocalDateTime());
        }

        java.sql.Timestamp updatedTimestamp = rs.getTimestamp("updated_at");
        if (updatedTimestamp != null) {
            vehicleStatus.setUpdatedAt(updatedTimestamp.toLocalDateTime());
        }

        return vehicleStatus;
    }
}
