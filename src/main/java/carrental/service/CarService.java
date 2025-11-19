package carrental.service;

import carrental.dao.CarDAO;
import carrental.model.Car;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * CarService类，提供车辆相关的业务逻辑服务
 */
public class CarService {
    // 依赖CarDAO（需要你创建对应的CarDAO类）
    private CarDAO carDAO = new CarDAO();
    private final LogService logService = new LogService();

    /**
     * 获取所有车辆
     * @return 返回所有车辆的列表
     * @throws SQLException 如果数据库操作出错
     */
    public List<Car> getAllCars() throws SQLException {
        return carDAO.findAll();
    }

    /**
     * 根据状态筛选车辆
     * @param status 车辆状态（Available/Rented/Maintenance）
     * @return 返回符合指定状态的车辆列表，如果状态为空则返回所有车辆
     * @throws SQLException 如果数据库操作出错
     */
    public List<Car> getCarsByStatus(String status) throws SQLException {
        if (status == null || status.trim().isEmpty()) {
            return getAllCars();
        }
        return carDAO.findByStatus(status);
    }

    /**
     * 获取所有可用车辆（状态为Available）
     * @return 返回所有状态为Available的车辆列表
     * @throws SQLException 如果数据库操作出错
     */
    public List<Car> getAvailableCars() throws SQLException {
        return getCarsByStatus("Available");
    }

    /**
     * 根据车辆ID查询
     * @param id 车辆ID
     * @return 返回包含查询结果的列表，如果未找到则返回空列表
     * @throws SQLException 如果数据库操作出错
     */
    // 在 CarService 类中
    public List<Car> getCarById(String id) throws SQLException {
        if (id == null || id.trim().isEmpty()) {
            return Collections.emptyList();
        }
        Car car = carDAO.findById(id); // 调用 DAO 层根据ID查询单辆车
        return car != null ? Collections.singletonList(car) : Collections.emptyList();
    }

    /**
     * 根据车牌号查询
     * @param license 车牌号
     * @return 返回包含查询结果的列表，如果未找到则返回空列表
     * @throws SQLException 如果数据库操作出错
     */
    public List<Car> getCarByLicense(String license) throws SQLException {
        if (license == null || license.trim().isEmpty()) {
            return List.of();
        }
        Car car = carDAO.findByLicense(license);
        return car != null ? List.of(car) : List.of();
    }

    /**
     * 根据车型查询
     * @param model 车型名称
     * @return 返回符合指定车型的车辆列表，如果车型为空则返回空列表
     * @throws SQLException 如果数据库操作出错
     */
    public List<Car> getCarsByModel(String model) throws SQLException {
        if (model == null || model.trim().isEmpty()) {
            return List.of();
        }
        return carDAO.findByModel(model);
    }

    /**
     * 更新车辆状态（用于租车/还车操作）
     * @param carId 车辆ID
     * @param newStatus 新的状态值
     * @return 返回操作是否成功
     * @throws SQLException 如果数据库操作出错
     */
    public boolean updateCarStatus(String carId, String newStatus) throws SQLException {
        if (carId == null || newStatus == null) {
            return false;
        }
        
        boolean result = carDAO.updateStatus(carId, newStatus);
        
        if (result) {
            logService.recordLog("System", "Update Car Status", "Successfully updated car status, Car ID: " + carId + ", New Status: " + newStatus, true);
        } else {
            logService.recordLog("System", "Update Car Status", "Failed to update car status, Car ID: " + carId + ", New Status: " + newStatus, false);
        }
        
        return result;
    }
}
