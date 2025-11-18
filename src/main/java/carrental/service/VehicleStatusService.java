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
            throw new RuntimeException("请先登录");
        }

        if (carId == null || carId.isEmpty()) {
            throw new IllegalArgumentException("车辆ID不能为空");
        }

        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("车辆状态不能为空");
        }

        try {
            // 创建车辆状态记录
            VehicleStatus vehicleStatus = new VehicleStatus(carId, rentalId, status, notes);

            // 保存到数据库
            boolean success = vehicleStatusDAO.insert(vehicleStatus);

            if (success) {
                // 记录系统日志
                logService.recordLog(
                    operator.getUsername(),
                    "车辆状态记录",
                    "记录车辆ID: " + carId + 
                    " (租赁ID: " + rentalId + ") 的还车状态为: " + status + 
                    ", 备注: " + (notes != null ? notes : "无"),
                    true
                );

                System.out.println(TimestampUtil.getCurrentTimestamp() + 
                    " 成功记录车辆状态，车辆ID: " + carId + 
                    ", 状态: " + status);
            } else {
                logService.recordLog(
                    operator.getUsername(),
                    "车辆状态记录",
                    "记录车辆ID: " + carId + " 的状态失败",
                    false
                );
            }

            return success;
        } catch (Exception e) {
            logService.recordLog(
                operator.getUsername(),
                "车辆状态记录",
                "记录车辆ID: " + carId + " 的状态时发生异常: " + e.getMessage(),
                false
            );
            throw new RuntimeException("记录车辆状态失败: " + e.getMessage());
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
            throw new RuntimeException("获取车辆状态失败: " + e.getMessage());
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
            throw new RuntimeException("获取租赁状态记录失败: " + e.getMessage());
        }
    }
}
