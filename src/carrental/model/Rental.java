package carrental.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// 租借信息类，表示一次车辆租借记录
public class Rental {
    // 租借记录ID
    private int rentalID;
    // 客户信息
    private Customer customer;
    // 车辆信息
    private Car car;
    // 租借开始日期
    private LocalDate startDate;
    // 预计归还日期
    private LocalDate expectedReturnDate;
    // 实际归还日期
    private LocalDate actualReturnDate;
    // 租借状态 (active, completed, overdue)
    private String status;
    // 总费用
    private double totalCost;

    // 无参构造函数
    public Rental() {
        this.status = "active"; // 默认状态为进行中
    }

    // 基本信息构造函数
    public Rental(int rentalID, Customer customer, Car car, LocalDate startDate, LocalDate expectedReturnDate) {
        this.rentalID = rentalID;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.expectedReturnDate = expectedReturnDate;
        this.status = "active"; // 初始状态为进行中
    }

    // 完整信息构造函数
    public Rental(int rentalID, Customer customer, Car car, LocalDate startDate, LocalDate expectedReturnDate, 
                  LocalDate actualReturnDate, String status, double totalCost) {
        this.rentalID = rentalID;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.expectedReturnDate = expectedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.status = status;
        this.totalCost = totalCost;
    }

    // 计算租借天数
    public long calculateRentalDays() {
        if (actualReturnDate != null) {
            // 如果已归还，计算实际租借天数
            return ChronoUnit.DAYS.between(startDate, actualReturnDate);
        } else {
            // 如果未归还，计算到今天的租借天数
            return ChronoUnit.DAYS.between(startDate, LocalDate.now());
        }
    }

    // 计算总费用
    public double calculateTotalCost() {
        long days = calculateRentalDays();
        return car.getPrice() * days;
    }

    // 完成租借（归还车辆）
    public void completeRental() {
        this.actualReturnDate = LocalDate.now();
        this.status = "completed";
        this.totalCost = calculateTotalCost();
        // 更新车辆状态
        car.returnCar();
    }

    // 检查是否逾期
    public boolean isOverdue() {
        if (actualReturnDate != null) {
            // 如果已归还，比较实际归还日期和预计归还日期
            return actualReturnDate.isAfter(expectedReturnDate);
        } else {
            // 如果未归还，比较今天和预计归还日期
            return LocalDate.now().isAfter(expectedReturnDate);
        }
    }

    // 更新租借状态
    public void updateStatus() {
        if (actualReturnDate != null) {
            this.status = "completed";
        } else if (isOverdue()) {
            this.status = "overdue";
        } else {
            this.status = "active";
        }
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID=" + rentalID +
                ", customer=" + customer.getName() +
                ", car=" + car.getModel() +
                ", startDate=" + startDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", status='" + status + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }


    // Getter和Setter方法
    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


}