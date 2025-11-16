package carrental.model;

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

    // 更新客户联系信息
    public void updateContactInfo(int phone, String email, String address) {
        this.phone = phone;
        this.email = email;
        this.address = address;
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


}