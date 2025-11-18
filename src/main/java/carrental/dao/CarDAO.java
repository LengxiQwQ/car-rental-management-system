package carrental.dao;

import carrental.model.Car;
import carrental.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆DAO
 */
public class CarDAO {
    // 查询所有车辆
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getString("id"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setLicensePlate(rs.getString("license_plate"));
                car.setColor(rs.getString("color"));
                car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                car.setPrice(rs.getDouble("daily_fee"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // 搜索车辆（品牌/型号/车牌号）
    public List<Car> search(String keyword) {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE make LIKE ? OR model LIKE ? OR license_plate LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String likeKeyword = "%" + keyword + "%";
            pstmt.setString(1, likeKeyword);
            pstmt.setString(2, likeKeyword);
            pstmt.setString(3, likeKeyword);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getString("id"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setLicensePlate(rs.getString("license_plate"));
                car.setColor(rs.getString("color"));
                car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                car.setPrice(rs.getDouble("Price"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // 根据状态查找
    public List<Car> findByStatus(String status) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE status = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("Brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    // 根据ID查找
    public Car findById(String id) throws SQLException {
        String sql = "SELECT * FROM cars WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("Brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    return car;
                }
            }
        }
        return null;
    }

    // 根据车牌号查找
    public Car findByLicense(String license) throws SQLException {
        String sql = "SELECT * FROM cars WHERE license_plate = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, license);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("Brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    return car;
                }
            }
        }
        return null;
    }

    // 根据车型查找
    public List<Car> findByModel(String model) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars WHERE model LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + model + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Car car = new Car();
                    car.setCarID(rs.getString("id"));
                    car.setBrand(rs.getString("Brand"));
                    car.setModel(rs.getString("model"));
                    car.setYear(rs.getInt("year"));
                    car.setLicensePlate(rs.getString("license_plate"));
                    car.setColor(rs.getString("color"));
                    car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                    car.setPrice(rs.getDouble("daily_fee"));
                    cars.add(car);
                }
            }
        }
        return cars;
    }

    // 更新车辆状态
    public boolean updateStatus(String carId, Car.CarStatus status) {
        String sql = "UPDATE cars SET status = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status.name());
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // 更新车辆状态（重载方法，用于CarService中的字符串状态）
    public boolean updateStatus(String carId, String status) {
        try {
            return updateStatus(carId, Car.CarStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新车辆品牌
    public boolean updateBrand(String carId, String brand) {
        String sql = "UPDATE cars SET brand = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, brand);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新车辆型号
    public boolean updateModel(String carId, String model) {
        String sql = "UPDATE cars SET model = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, model);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新车辆年份
    public boolean updateYear(String carId, int year) {
        String sql = "UPDATE cars SET year = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, year);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新车牌号
    public boolean updateLicensePlate(String carId, String licensePlate) {
        String sql = "UPDATE cars SET license_plate = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, licensePlate);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新车辆颜色
    public boolean updateColor(String carId, String color) {
        String sql = "UPDATE cars SET color = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, color);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新日租金
    public boolean updateDailyFee(String carId, double dailyFee) {
        String sql = "UPDATE cars SET daily_fee = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, dailyFee);
            pstmt.setString(2, carId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 添加车辆
    public boolean insert(Car car) {
        String sql = "INSERT INTO cars (id, brand, model, year, license_plate, color, status, daily_fee, stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, car.getCarID());
            pstmt.setString(2, car.getBrand());
            pstmt.setString(3, car.getModel());
            pstmt.setInt(4, car.getYear());
            pstmt.setString(5, car.getLicensePlate());
            pstmt.setString(6, car.getColor());
            pstmt.setString(7, car.getStatus());
            pstmt.setDouble(8, car.getPrice());
            pstmt.setInt(9, car.getStock());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}