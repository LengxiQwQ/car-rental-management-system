package carrental.service;

import carrental.dao.CarDAO;
import carrental.dao.RentalDAO;
import carrental.db.DBConnection;
import carrental.model.Car;
import carrental.model.Rental;
import carrental.model.User;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 * 租车服务：核心业务逻辑
 */
public class RentalService {
    private final RentalDAO rentalDAO = new RentalDAO();
    private final CarDAO carDAO = new CarDAO();

    // 获取所有租赁记录
    public List<Rental> getAllRentals() throws SQLException {
        return rentalDAO.findAll();
    }

    // 添加租赁记录
    public boolean addRental(Rental rental) throws SQLException {
        return rentalDAO.insert(rental);
    }

    // 租车操作（事务控制）
    public boolean checkoutCar(Rental rental, User operator) {
        if (operator == null) {
            throw new RuntimeException("请先登录");
        }

        if (rental.getStartDate().isAfter(rental.getExpectedReturnDate())){
            throw new IllegalArgumentException("结束日期不能早于开始日期");
        }

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // 开启事务

            // 插入租车记录
            boolean rentalSuccess = rentalDAO.insert(rental);
            if (!rentalSuccess) {
                conn.rollback();
                throw new RuntimeException("租车记录创建失败");
            }

            // 更新车辆状态为已租
            boolean carStatusSuccess = carDAO.updateStatus(rental.getCar().getCarID(), Car.CarStatus.RENTED);
            if (!carStatusSuccess) {
                conn.rollback();
                throw new RuntimeException("车辆状态更新失败");
            }

            conn.commit();
            System.out.println("租车成功！车辆ID：" + rental.getCar().getCarID());
            return true;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new RuntimeException("租车失败：" + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    // 还车操作（事务控制）
    public BigDecimal returnCar(String rentalId, LocalDate actualReturnDate, User operator) {
        if (operator == null) {
            throw new RuntimeException("请先登录");
        }

        if (actualReturnDate == null) {
            throw new IllegalArgumentException("实际归还日期不能为空");
        }

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // 查询租车记录
            Rental rental = rentalDAO.findAll().stream()
                    .filter(r -> r.getCar().getCarID() == rentalId)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("租车记录不存在"));

            // 查询车辆日租金
            Car car = carDAO.findById(rental.getCar().getCarID());
            if (car == null) {
                conn.rollback();
                throw new RuntimeException("车辆不存在");
            }

            // 计算总费用
            double totalCost = rental.calculateTotalCost();
            BigDecimal totalFee = BigDecimal.valueOf(totalCost);

            // 更新还车记录
            boolean rentalUpdateSuccess = rentalDAO.updateReturn(rentalId, actualReturnDate, totalFee);
            if (!rentalUpdateSuccess) {
                conn.rollback();
                throw new RuntimeException("还车记录更新失败");
            }

            // 更新车辆状态为可用
            boolean carStatusSuccess = carDAO.updateStatus(rental.getCar().getCarID(), Car.CarStatus.AVAILABLE);
            if (!carStatusSuccess) {
                conn.rollback();
                throw new RuntimeException("车辆状态更新失败");
            }

            conn.commit();
            System.out.println("还车成功！总费用：" + totalFee);
            return totalFee;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            throw new RuntimeException("还车失败：" + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}