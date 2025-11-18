package carrental.dao;

import carrental.db.DBConnection;
import carrental.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * 获取所有客户
     * @return 客户列表
     * @throws SQLException 数据库访问错误时抛出
     */
    public List<Customer> findAll() throws SQLException {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getString("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getInt("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                customer.setDriverLicenseNumber(rs.getInt("driver_license_number"));
                customer.setIdCardNumber(rs.getInt("id_card_number"));
                customers.add(customer);
            }
        }
        return customers;
    }

    /**
     * 新增客户
     * @param customer 要新增的客户对象
     * @return 操作是否成功
     * @throws SQLException 数据库访问错误时抛出
     */
    public boolean insert(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (customer_id, name, phone, email, address, driver_license_number, id_card_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getCustomerID());
            pstmt.setString(2, customer.getcustomerName());
            pstmt.setInt(3, customer.getPhone());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getAddress());
            pstmt.setInt(6, customer.getDriverLicenseNumber());
            pstmt.setInt(7, customer.getIdCardNumber());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * 更新客户信息
     * @param customer 要更新的客户对象
     * @return 操作是否成功
     * @throws SQLException 数据库访问错误时抛出
     */
    public boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE customers SET name = ?, phone = ?, email = ?, address = ?, driver_license_number = ?, id_card_number = ? WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getcustomerName());
            pstmt.setInt(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            pstmt.setInt(5, customer.getDriverLicenseNumber());
            pstmt.setInt(6, customer.getIdCardNumber());
            pstmt.setString(7, customer.getCustomerID());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    /**
     * 搜索客户（根据关键词）
     * @param keyword 搜索关键词
     * @return 匹配的客户列表
     * @throws SQLException 数据库访问错误时抛出
     */
    public List<Customer> search(String keyword) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customer_id LIKE ? OR name LIKE ? OR email LIKE ?";
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerID(rs.getString("customer_id"));
                    customer.setName(rs.getString("name"));
                    customer.setPhone(rs.getInt("phone"));
                    customer.setEmail(rs.getString("email"));
                    customer.setAddress(rs.getString("address"));
                    customer.setDriverLicenseNumber(rs.getInt("driver_license_number"));
                    customer.setIdCardNumber(rs.getInt("id_card_number"));
                    customers.add(customer);
                }
            }
        }
        return customers;
    }
}