package carrental.model;

public class Customer {

    private int phone;
    private int driverLicenseNumber;
    private int idCardNumber;
    private String customerID;
    private String customerName;
    private String email;
    private String address;
    private String password;

    // 无参构造函数
    public Customer() {
    }

    // 基本信息构造函数
    public Customer(String customerID, String name, int phone, String email, String address, String password) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    // 完整客户信息构造函数
    public Customer(String customerID, String customerName, int phone, String email, String address, String password, int driverLicenseNumber, int idCardNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
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
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    // Getter & Setter
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getcustomerName() {
        return customerName;
    }

    public void setName(String customerName) {
        this.customerName = customerName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}