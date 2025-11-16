package carrental.dao;

import carrental.db.DBConnection;
import carrental.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    /**
     * 根据客户ID查找客户
     * @param customerID 客户的唯一标识符 (String类型)
     * @return 如果找到，返回Customer对象；否则返回null
     */
    public Customer findById(String customerID) {
        // 假设数据库表名为 'customers'，主键列名为 'customer_id'
        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 使用 setString 设置 String 类型的参数
            pstmt.setString(1, customerID);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();

                    // 从 ResultSet 中读取数据并设置到 Customer 对象中
                    // 注意：这里的列名需要与你的数据库表结构完全一致
                    customer.setCustomerID(rs.getString("customer_id"));
                    customer.setName(rs.getString("name"));

                    // 注意：Customer 类中的 phone, driverLicenseNumber, idCardNumber 是 int 类型
                    // 如果数据库中这些字段可能为 NULL，请使用 rs.wasNull() 进行判断，避免空指针异常
                    // 为简化起见，这里假设这些字段在数据库中是 NOT NULL 的
                    customer.setPhone(rs.getInt("phone"));
                    customer.setEmail(rs.getString("email"));
                    customer.setAddress(rs.getString("address"));
                    customer.setDriverLicenseNumber(rs.getInt("driver_license_number"));
                    customer.setIdCardNumber(rs.getInt("id_card_number"));

                    return customer;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 如果找不到或发生异常，返回null
    }
}