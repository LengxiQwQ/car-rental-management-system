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

    // 根据ID查询车辆
    public Car findById(String carId) {
        String sql = "SELECT * FROM cars WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, carId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Car car = new Car();
                car.setCarID(rs.getString("id"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("model"));
                car.setYear(rs.getInt("year"));
                car.setLicensePlate(rs.getString("license_plate"));
                car.setColor(rs.getString("color"));
                car.setStatus(Car.CarStatus.valueOf(rs.getString("status")));
                car.setPrice(rs.getDouble("Price"));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}