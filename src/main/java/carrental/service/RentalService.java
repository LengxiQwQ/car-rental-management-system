package carrental.service;

import carrental.dao.CarDAO;
import carrental.dao.RentalDAO;
import carrental.db.DBConnection;
import carrental.model.Car;
import carrental.model.Rental;
import carrental.model.User;
import carrental.util.TimestampUtil;
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
    private final LogService logService = new LogService();

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
            throw new IllegalArgumentException("End date cannot be earlier than start date");
        }

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Insert rental record
            boolean rentalSuccess = rentalDAO.insert(rental);
            if (!rentalSuccess) {
                conn.rollback();
                throw new RuntimeException("Rental record creation failed");
            }

            // Update car status to rented
            boolean carStatusSuccess = carDAO.updateStatus(rental.getCar().getCarID(), Car.CarStatus.RENTED);
            if (!carStatusSuccess) {
                conn.rollback();
                throw new RuntimeException("Car status update failed");
            }

            conn.commit();
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Rental successful! Car ID: " + rental.getCar().getCarID());
            
            // Record system log
            logService.recordLog(operator.getUsername(), "Car Rental", "Successfully rented car, Car ID: " + rental.getCar().getCarID() + 
                                ", Customer ID: " + rental.getCustomer().getCustomerID(), true);
            
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
            
            // Record system log
            logService.recordLog(operator.getUsername(), "Car Rental", "Rental failed: " + e.getMessage(), false);
            
            throw new RuntimeException("Rental failed: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }

    // 还车操作（事务控制）
    public BigDecimal returnCar(String rentalId, LocalDate actualReturnDate, User operator) {
        if (operator == null) {
            throw new RuntimeException("Please login first");
        }

        if (actualReturnDate == null) {
            throw new IllegalArgumentException("Actual return date cannot be empty");
        }

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            // Query rental record
            Rental rental = rentalDAO.findAll().stream()
                    .filter(r -> String.valueOf(r.getRentalID()).equals(rentalId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Rental record does not exist"));

            // Check rental record status to prevent duplicate returns
            if (rental.getActualReturnDate() != null) {
                throw new RuntimeException("The car has been returned, cannot return again");
            }

            // Query daily rental rate for the car
            Car car = carDAO.findById(rental.getCar().getCarID());
            if (car == null) {
                conn.rollback();
                throw new RuntimeException("Car does not exist");
            }

            // Set actual return date to correctly calculate fees
            rental.setActualReturnDate(actualReturnDate);

            // Calculate total fee
            double totalCost = rental.calculateTotalCost();
            BigDecimal totalFee = BigDecimal.valueOf(totalCost);

            // Update return record
            boolean rentalUpdateSuccess = rentalDAO.updateReturn(rentalId, actualReturnDate, totalFee);
            if (!rentalUpdateSuccess) {
                conn.rollback();
                throw new RuntimeException("Return record update failed");
            }

            // Update car status to available
            boolean carStatusSuccess = carDAO.updateStatus(rental.getCar().getCarID(), Car.CarStatus.AVAILABLE);
            if (!carStatusSuccess) {
                conn.rollback();
                throw new RuntimeException("Car status update failed");
            }

            conn.commit();
            System.out.println(TimestampUtil.getCurrentTimestamp() + " Return successful! Total fee: " + totalFee);
            
            // Record system log
            logService.recordLog(operator.getUsername(), "Car Return", "Successfully returned car, Rental ID: " + rentalId + 
                                ", Total fee: " + totalFee, true);
            
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
            
            // Record system log
            logService.recordLog(operator.getUsername(), "Car Return", "Return failed: " + e.getMessage(), false);
            
            throw new RuntimeException("Return failed: " + e.getMessage());
        } finally {
            DBConnection.closeConnection(conn);
        }
    }
}