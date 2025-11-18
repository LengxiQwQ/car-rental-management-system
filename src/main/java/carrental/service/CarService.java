package carrental.service;

import carrental.dao.CarDAO;
import carrental.model.Car;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CarService {
    // 依赖CarDAO（需要你创建对应的CarDAO类）
    private CarDAO carDAO = new CarDAO();

    /**
     * 获取所有车辆
     */
    public List<Car> getAllCars() throws SQLException {
        return carDAO.findAll();
    }

    /**
     * 根据状态筛选车辆
     * @param status 车辆状态（Available/Rented/Maintenance）
     */
    public List<Car> getCarsByStatus(String status) throws SQLException {
        if (status == null || status.trim().isEmpty()) {
            return getAllCars();
        }
        return carDAO.findByStatus(status);
    }

    /**
     * 获取所有可用车辆（状态为Available）
     */
    public List<Car> getAvailableCars() throws SQLException {
        return getCarsByStatus("Available");
    }

    /**
     * 根据车辆ID查询
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
     */
    public List<Car> getCarsByModel(String model) throws SQLException {
        if (model == null || model.trim().isEmpty()) {
            return List.of();
        }
        return carDAO.findByModel(model);
    }

    /**
     * 更新车辆状态（用于租车/还车操作）
     */
    public boolean updateCarStatus(String carId, String newStatus) throws SQLException {
        if (carId == null || newStatus == null) {
            return false;
        }
        return carDAO.updateStatus(carId, newStatus);
    }
}
