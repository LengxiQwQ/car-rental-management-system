package carrental.service;

import carrental.dao.VehicleStatusDAO;
import carrental.model.VehicleStatus;
import carrental.model.User;
import carrental.util.TimestampUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * 车辆状态服务类
 */
public class VehicleStatusService {
    private final VehicleStatusDAO vehicleStatusDAO = new VehicleStatusDAO();
    private final LogService logService = new LogService();

    /**
     * 记录车辆还车时的状态
     * @param carId 车辆ID
     * @param rentalId 租赁ID
     * @param status 车辆状态
     * @param notes 备注
     * @param operator 操作员
     * @return 是否记录成功
     */
    public boolean recordReturnStatus(String carId, Integer rentalId, String status, String notes, User operator) {
        if (operator == null) {
            throw new RuntimeException("Please login first");
        }

        if (carId == null || carId.isEmpty()) {
            throw new IllegalArgumentException("Car ID cannot be empty");
        }

        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Car status cannot be empty");
        }

        try {
            // Create vehicle status record
            VehicleStatus vehicleStatus = new VehicleStatus(carId, rentalId, status, notes);

            // Save to database
            boolean success = vehicleStatusDAO.insert(vehicleStatus);

            if (success) {
                // Record system log
                logService.recordLog(
                    operator.getUsername(),
                    "Vehicle Status Record",
                    "Recorded return status for Car ID: " + carId + 
                    " (Rental ID: " + rentalId + ") as: " + status + 
                    ", Notes: " + (notes != null ? notes : "None"),
                    true
                );

                System.out.println(TimestampUtil.getCurrentTimestamp() + 
                    " Successfully recorded vehicle status, Car ID: " + carId + 
                    ", Status: " + status);
            } else {
                logService.recordLog(
                    operator.getUsername(),
                    "Vehicle Status Record",
                    "Failed to record status for Car ID: " + carId,
                    false
                );
            }

            return success;
        } catch (Exception e) {
            logService.recordLog(
                operator.getUsername(),
                "Vehicle Status Record",
                "Exception occurred while recording status for Car ID: " + carId + ": " + e.getMessage(),
                false
            );
            throw new RuntimeException("Failed to record vehicle status: " + e.getMessage());
        }
    }

    /**
     * 获取车辆最新的状态记录
     * @param carId 车辆ID
     * @return 最新的车辆状态记录
     */
    public VehicleStatus getLatestStatus(String carId) {
        try {
            return vehicleStatusDAO.findLatestByCarId(carId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get vehicle status: " + e.getMessage());
        }
    }

    /**
     * 获取指定租赁的所有状态记录
     * @param rentalId 租赁ID
     * @return 状态记录列表
     */
    public List<VehicleStatus> getStatusByRentalId(int rentalId) {
        try {
            return vehicleStatusDAO.findByRentalId(rentalId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get rental status records: " + e.getMessage());
        }
    }
}
