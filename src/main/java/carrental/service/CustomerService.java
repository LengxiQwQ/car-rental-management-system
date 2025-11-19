package carrental.service;

import carrental.dao.CustomerDAO;
import carrental.model.Customer;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    // 依赖注入DAO层（直接使用你已有的CustomerDAO）
    private CustomerDAO customerDAO = new CustomerDAO();
    private final LogService logService = new LogService();

    /**
     * 获取所有客户（从数据库查询）
     */
    public List<Customer> getAllCustomers() throws SQLException {
        return customerDAO.findAll();
    }

    /**
     * 根据关键词搜索客户
     * 搜索范围：客户ID、姓名、电话、邮箱
     */
    public List<Customer> searchCustomers(String keyword) throws SQLException {
        return customerDAO.search(keyword);
    }

    /**
     * 保存客户信息（新增或更新）
     * @param customer 客户对象
     * @return 操作成功返回true，失败返回false
     */
    public boolean saveCustomer(Customer customer) throws SQLException {
        // 数据验证
        if (customer == null ||
                customer.getCustomerID() == null ||
                customer.getCustomerID().trim().isEmpty() ||
                customer.getcustomerName() == null ||
                customer.getcustomerName().trim().isEmpty()) {
            return false;
        }

        boolean isUpdate = customerDAO.findById(customer.getCustomerID()) != null;
        boolean result;

        if (isUpdate) {
            result = customerDAO.update(customer);
            if (result) {
                logService.recordLog("System", "Update Customer", "Successfully updated customer information, Customer ID: " + customer.getCustomerID(), true);
            } else {
                logService.recordLog("System", "Update Customer", "Failed to update customer information, Customer ID: " + customer.getCustomerID(), false);
            }
        } else {
            result = customerDAO.insert(customer);
            if (result) {
                logService.recordLog("System", "Add Customer", "Successfully added new customer, Customer ID: " + customer.getCustomerID(), true);
            } else {
                logService.recordLog("System", "Add Customer", "Failed to add new customer, Customer ID: " + customer.getCustomerID(), false);
            }
        }

        return result;
    }

    /**
     * 根据ID获取客户
     */
    public Customer getCustomerById(String id) throws SQLException {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        return customerDAO.findById(id);
    }
}

