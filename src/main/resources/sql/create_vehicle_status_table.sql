-- 创建车辆状态表
CREATE TABLE IF NOT EXISTS vehicle_status (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_id VARCHAR(50) NOT NULL,
    rental_id INT,
    status VARCHAR(50) NOT NULL COMMENT '车辆状态: good(良好), damaged(损坏), needs_maintenance(需要维护)',
    notes TEXT COMMENT '状态备注',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (car_id) REFERENCES cars(id),
    FOREIGN KEY (rental_id) REFERENCES rentals(id) ON DELETE SET NULL,
    INDEX idx_car_id (car_id),
    INDEX idx_rental_id (rental_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='车辆状态记录表';
