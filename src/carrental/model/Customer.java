package carrental.model;

import java.util.Objects;

// Customer类表示汽车租赁系统中的客户，包含客户信息和相关功能
public class Customer {
    
    private int customerID;
    private int phone;
    private int driverLicenseNumber;
    private int idCardNumber;
    private String name;
    private String email;
    private String address;

    // 无参构造函数
    public Customer() {
    }

    // 基本信息构造函数
    public Customer(int customerID, String name, int phone, String email, String address) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // 完整客户信息构造函数
    public Customer(int customerID, String name, int phone, String email, String address, 
                   int driverLicenseNumber, int idCardNumber) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.driverLicenseNumber = driverLicenseNumber;
        this.idCardNumber = idCardNumber;
    }

    // Getter & setter
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(int driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public int getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(int idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    // 验证客户是否拥有所有必需的信息
    // @return 如果客户拥有所有必需信息则返回true，否则返回false
    public boolean isValid() {
        return name != null && !name.isEmpty();
    }

    // 更新客户联系信息
    // @param phone 新的电话号码
    // @param email 新的电子邮件地址
    // @param address 新的地址
    public void updateContactInfo(int phone, String email, String address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", phone=" + phone +
                ", driverLicenseNumber=" + driverLicenseNumber +
                ", idCardNumber=" + idCardNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}