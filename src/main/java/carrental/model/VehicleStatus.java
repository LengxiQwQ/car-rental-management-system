package carrental.model;

import java.time.LocalDateTime;

/**
 * 车辆状态模型类
 */
public class VehicleStatus {
    private int id;
    private String carId;
    private Integer rentalId;
    private String status;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 车辆状态枚举
    public enum Status {
        GOOD("良好"),
        DAMAGED("损坏"),
        NEEDS_MAINTENANCE("需要维护");

        private final String description;

        Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // 默认构造函数
    public VehicleStatus() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 完整构造函数
    public VehicleStatus(String carId, Integer rentalId, String status, String notes) {
        this();
        this.carId = carId;
        this.rentalId = rentalId;
        this.status = status;
        this.notes = notes;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "VehicleStatus{" +
                "id=" + id +
                ", carId='" + carId + ' ' +
                ", rentalId=" + rentalId +
                ", status='" + status + ' ' +
                ", notes='" + notes + ' ' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
