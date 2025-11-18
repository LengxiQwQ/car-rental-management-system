package carrental.dao;

import carrental.db.DBConnection;
import carrental.model.Car;
import carrental.model.Customer;
import carrental.model.Rental;
import carrental.util.TimestampUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO {

    // DAO 依赖，用于根据ID查询关联对象
    private final CarDAO carDAO;
    private final CustomerDAO customerDAO;

    public RentalDAO() {
        this.carDAO = new CarDAO();
        this.customerDAO = new CustomerDAO();
    }

    /**
     * 添加租车记录
     * @param rental 包含完整信息的 Rental 对象
     * @return 是否添加成功
     */
    public boolean insert(Rental rental) {
        // 插入租赁记录到数据库
        String sql = "INSERT INTO rentals (car_id, customer_id, staff_id, start_date, due_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rental.getCar().getCarID());
            pstmt.setString(2, rental.getCustomer().getCustomerID());
            pstmt.setInt(3, rental.getStaffId()); // 从 Rental 对象获取员工 ID
            pstmt.setString(4, rental.getStartDate().toString());
            pstmt.setString(5, rental.getExpectedReturnDate().toString());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("成功插入租赁记录，车辆ID: " + rental.getCar().getCarID() + 
                                  ", 客户ID: " + rental.getCustomer().getCustomerID());
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println("插入租赁记录失败: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新还车记录
     * @param rentalId 租车记录ID
     * @param actualReturnDate 实际归还日期
     * @param totalFee 总费用
     * @return 是否更新成功
     */
    public boolean updateReturn(String rentalId, LocalDate actualReturnDate, BigDecimal totalFee) {
        String sql = "UPDATE rentals SET actual_return_date = ?, total_fee = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, actualReturnDate.toString());
            pstmt.setBigDecimal(2, totalFee);
            pstmt.setString(3, rentalId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询所有租车记录
     * @return 包含完整 Car 和 Customer 对象的 Rental 列表
     */
    public List<Rental> findAll() {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT * FROM rentals";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // 1. 从数据库结果集中获取基本数据
                int rentalId = rs.getInt("id"); // 数据库列名为 id
                String carId = rs.getString("car_id");
                String customerId = rs.getString("customer_id");
                int staffId = rs.getInt("staff_id"); // 可忽略，或在Rental类中添加
                LocalDate startDate = LocalDate.parse(rs.getString("start_date"));
                LocalDate expectedReturnDate = LocalDate.parse(rs.getString("due_date")); // 数据库列名为 due_date
                String actualReturnDateStr = rs.getString("actual_return_date");
                LocalDate actualReturnDate = (actualReturnDateStr != null) ? LocalDate.parse(actualReturnDateStr) : null;
                BigDecimal totalFee = rs.getBigDecimal("total_fee");

                // 2. 通过 ID 查找关联的完整对象
                Car car = carDAO.findById(carId);
                Customer customer = customerDAO.findById(customerId);

                // 如果关联对象不存在，进行错误处理或跳过
                if (car == null || customer == null) {
                    System.err.println(TimestampUtil.getCurrentTimestamp() + " 警告：租赁记录ID " + rentalId + " 关联的车辆或客户不存在，已跳过。");
                    continue;
                }

                // 3. 构建并填充 Rental 对象
                Rental rental = new Rental();
                rental.setRentalID(rentalId); // 设置ID
                rental.setCar(car);
                rental.setCustomer(customer);
                rental.setStartDate(startDate);
                rental.setExpectedReturnDate(expectedReturnDate);
                rental.setActualReturnDate(actualReturnDate);

                // 如果数据库中有总费用，则设置它
                if (totalFee != null) {
                    rental.setTotalCost(totalFee.doubleValue());
                }

                // 4. 调用业务方法更新状态
                rental.updateStatus();

                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    // 推荐添加：根据ID查询单个租赁记录
    public Rental findById(int rentalId) {
        String sql = "SELECT * FROM rentals WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 这里的逻辑与 findAll 中的 while 循环内的逻辑基本一致
                    String carId = rs.getString("car_id");
                    String customerId = rs.getString("customer_id");
                    LocalDate startDate = LocalDate.parse(rs.getString("start_date"));
                    LocalDate expectedReturnDate = LocalDate.parse(rs.getString("due_date"));
                    String actualReturnDateStr = rs.getString("actual_return_date");
                    LocalDate actualReturnDate = (actualReturnDateStr != null) ? LocalDate.parse(actualReturnDateStr) : null;
                    BigDecimal totalFee = rs.getBigDecimal("total_fee");

                    Car car = carDAO.findById(carId);
                    Customer customer = customerDAO.findById(customerId);

                    if (car == null || customer == null) {
                        System.err.println(TimestampUtil.getCurrentTimestamp() + " 警告：租赁记录ID " + rentalId + " 关联的车辆或客户不存在。");
                        return null;
                    }

                    Rental rental = new Rental();
                    rental.setRentalID(rentalId);
                    rental.setCar(car);
                    rental.setCustomer(customer);
                    rental.setStartDate(startDate);
                    rental.setExpectedReturnDate(expectedReturnDate);
                    rental.setActualReturnDate(actualReturnDate);
                    if (totalFee != null) {
                        rental.setTotalCost(totalFee.doubleValue());
                    }
                    rental.updateStatus();

                    return rental;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}