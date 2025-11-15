package carrental.model;

public class Car {
    private String CarID;
    private String Model;
    private String Brand;
    private String Color;
    private String Status; //available, rented, maintenance
    private String description;
    private String licensePlate;
    private double Price;
    private int year;
    private int stock;

    public Car(String carID, String model, String brand, String color, String status, String description, String licensePlate, double price, int year, int stock) {
        CarID = carID;
        Model = model;
        Brand = brand;
        Color = color;
        Status = status;
        this.description = description;
        this.licensePlate = licensePlate;
        Price = price;
        this.year = year;
        this.stock = stock;
    }

    /**
     * 比较两个车辆对象是否相等
     * @param o 要比较的对象
     * @return 如果两个车辆的ID相同则返回true，否则返回false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return CarID != null ? CarID.equals(car.CarID) : car.CarID == null;
    }

    /**
     * 检查车辆是否可租用
     * @return 如果车辆状态为可用且库存大于0则返回true，否则返回false
     */
    public boolean isAvailable() {
        return Status.equals("available") && stock > 0;
    }

    /**
     * 租车时减少库存数量
     */
    public void rentCar() {
        if (stock > 0) {
            stock--;
            if (stock == 0) {
                Status = "unavailable";
            }
        }
    }

    // 还车时增加库存数量
    public void returnCar() {
        stock++;
        if (stock > 0) {
            Status = "available";
        }
    }

    /**
     * 根据租赁天数计算租金
     * @param days 租赁天数
     * @return 总租金 = 单价 × 天数
     */
    public double calculateRentalCost(int days) {
        return Price * days;
    }



    //Getter & Setter
    public Car() {
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    //返回车辆的字符串表示形式
    @Override
    public String toString() {
        return "Car{" +
                "CarID='" + CarID + '\'' +
                ", Model='" + Model + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Color='" + Color + '\'' +
                ", Status='" + Status + '\'' +
                ", description='" + description + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", Price=" + Price +
                ", year=" + year +
                ", stock=" + stock +
                '}';
    }

}
