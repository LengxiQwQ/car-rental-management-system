DROP DATABASE IF EXISTS Car_Rental_Management_System_DB;



CREATE DATABASE Car_Rental_Management_System_DB;
USE Car_Rental_Management_System_DB;

-- -------------------------------
-- 1. Users Table (users)
-- -------------------------------
CREATE TABLE IF NOT EXISTS users (
                                     id INT PRIMARY KEY AUTO_INCREMENT,
                                     username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'STAFF') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO users (username, password, role) VALUES
                                                 ('admin', 'admin123', 'ADMIN'),
                                                 ('system_admin', 'sys2024', 'ADMIN'),
                                                 ('staff_li', 'li123456', 'STAFF'),
                                                 ('staff_wang', 'wang654321', 'STAFF'),
                                                 ('staff_zhang', 'zhang789', 'STAFF'),
                                                 ('staff_chen', 'chen2024', 'STAFF'),
                                                 ('staff_zhao', 'zhao5678', 'STAFF'),
                                                 ('staff_qian', 'qian8765', 'STAFF'),
                                                 ('staff_sun', 'sun1357', 'STAFF'),
                                                 ('staff_zhou', 'zhou2468', 'STAFF'),
                                                 ('staff_wu', 'wu9876', 'STAFF'),
                                                 ('staff_hu', 'hu5432', 'STAFF'),
                                                 ('staff_guo', 'guo1122', 'STAFF'),
                                                 ('staff_he', 'he3344', 'STAFF'),
                                                 ('staff_gao', 'gao5566', 'STAFF'),
                                                 ('staff_lin', 'lin7788', 'STAFF'),
                                                 ('staff_ma', 'ma9900', 'STAFF'),
                                                 ('staff_yang', 'yang4455', 'STAFF'),
                                                 ('staff_huang', 'huang6677', 'STAFF'),
                                                 ('staff_xu', 'xu8899', 'STAFF'),
                                                 ('staff_new', 'temp001', 'STAFF'); -- 对应 logs 里的 id=21


-- -------------------------------
-- 2. Cars Table (cars)
-- -------------------------------
CREATE TABLE IF NOT EXISTS cars (
                                    id VARCHAR(20) PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    license_plate VARCHAR(20) NOT NULL UNIQUE,
    color VARCHAR(30),
    status ENUM('AVAILABLE', 'RENTED', 'MAINTENANCE') NOT NULL DEFAULT 'AVAILABLE',
    daily_fee DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 1
    );

INSERT INTO cars (id, brand, model, year, license_plate, color, status, daily_fee, stock) VALUES
                                                                                              ('C001', 'Toyota', 'Corolla', 2022, 'CA12345', 'White', 'AVAILABLE', 180.00, 2),
                                                                                              ('C002', 'Honda', 'Civic', 2023, 'CA67890', 'Black', 'AVAILABLE', 200.00, 1),
                                                                                              ('C003', 'Volkswagen', 'Jetta', 2021, 'NY11223', 'Silver', 'RENTED', 160.00, 1),
                                                                                              ('C004', 'Nissan', 'Sylphy', 2023, 'NY44556A', 'Blue', 'AVAILABLE', 190.00, 3),
                                                                                              ('C005', 'Hyundai', 'Elantra', 2022, 'TX77889', 'Gray', 'MAINTENANCE', 170.00, 1),
                                                                                              ('C006', 'Toyota', 'Camry', 2023, 'TX99001', 'White', 'AVAILABLE', 300.00, 2),
                                                                                              ('C007', 'Honda', 'Accord', 2022, 'IL22334', 'Black', 'RENTED', 320.00, 1),
                                                                                              ('C008', 'Audi', 'A4L', 2023, 'IL55667', 'Silver', 'AVAILABLE', 450.00, 1),
                                                                                              ('C009', 'BMW', '3 Series', 2022, 'MI88990', 'Blue', 'AVAILABLE', 480.00, 1),
                                                                                              ('C010', 'Mercedes-Benz', 'C-Class', 2023, 'MI11223', 'White', 'MAINTENANCE', 500.00, 1),
                                                                                              ('C011', 'Toyota', 'RAV4', 2022, 'OH33445', 'Black', 'AVAILABLE', 350.00, 2),
                                                                                              ('C012', 'Honda', 'CR-V', 2023, 'OH66778', 'White', 'RENTED', 380.00, 1),
                                                                                              ('C013', 'Volkswagen', 'Tiguan', 2021, 'TX99002', 'Gray', 'AVAILABLE', 330.00, 1),
                                                                                              ('C014', 'Ford', 'Escape', 2023, 'CA22334', 'Red', 'AVAILABLE', 340.00, 2),
                                                                                              ('C015', 'Jeep', 'Cherokee', 2022, 'AZ55667', 'Green', 'MAINTENANCE', 360.00, 1),
                                                                                              ('C016', 'Audi', 'A6L', 2023, 'AZ88990', 'Black', 'AVAILABLE', 600.00, 1),
                                                                                              ('C017', 'BMW', '5 Series', 2022, 'CA11223', 'White', 'RENTED', 650.00, 1),
                                                                                              ('C018', 'Mercedes-Benz', 'E-Class', 2023, 'NY44556B', 'Silver', 'AVAILABLE', 680.00, 1),
                                                                                              ('C019', 'Lexus', 'ES', 2022, 'IL77889', 'Blue', 'AVAILABLE', 580.00, 2),
                                                                                              ('C020', 'Cadillac', 'CT6', 2023, 'MI99001', 'Black', 'MAINTENANCE', 550.00, 1);


-- -------------------------------
-- 3. 客户表 (customers)
-- -------------------------------
CREATE TABLE IF NOT EXISTS customers (
                                         customer_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    address VARCHAR(255),
    driver_license_number VARCHAR(50) NOT NULL UNIQUE,
    id_card_number VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
    );

INSERT INTO customers VALUES
                          ('CUS001', 'Zhang San', '13800138000', 'zhangsan@example.com', 'Beijing ...', '12365678', '110101199001011234', 'zhangsan123'),
                          ('CUS002', 'Li Si', '13900139000', 'lisi@example.com', 'Shanghai ...', '87684321', '310101199205123456', 'lisi456'),
                          ('CUS003', 'Wang Wu', '13700137000', 'wangwu@example.com', 'Guangzhou ...', '11223744', '440101198803256789', 'wangwu789'),
                          ('CUS004', 'Zhao Liu', '13600136000', 'zhaoliu@example.com', 'Shenzhen ...', '44332211', '440301199507189012', 'zhaoliu2024'),
                          ('CUS005', 'Qian Qi', '13500135000', 'qianqi@example.com', 'Hangzhou ...', '55663788', '330101199309054321', 'qianqi333'),
                          ('CUS006', 'Sun Ba', '13400134000', 'sunba@example.com', 'Nanjing ...', '88776355', '320101199102178901', 'sunba444'),
                          ('CUS007', 'Zhou Jiu', '13300133000', 'zhoujiu@example.com', 'Chengdu ...', '93001122', '510101198906234567', 'zhoujiu555'),
                          ('CUS008', 'Wu Shi', '13200132000', 'wushi@example.com', 'Wuhan ...', '22334455', '420101199404156789', 'wushi666'),
                          ('CUS009', 'Zheng Shiyi', '13100131000', 'zheng@example.com', 'Xi’an ...', '55423322', '610101199008213456', 'zheng777'),
                          ('CUS010', 'Wang Shier', '13000130000', 'wang12@example.com', 'Chongqing ...', '66773899', '500101198711056789', 'wang888'),
                          ('CUS011', 'Li Shisan', '18900189000', 'lishi13@example.com', 'Tianjin ...', '77886900', '120101199203145678', 'li999'),
                          ('CUS012', 'Zhao Shisi', '18800188000', 'zhao@example.com', 'Suzhou ...', '33445566', '320501199501234567', 'zhao000'),
                          ('CUS013', 'Qian Shiwu', '18700187000', 'qian@example.com', 'Wuxi ...', '44556677', '320201199305167890', 'qian111'),
                          ('CUS014', 'Sun Shiliu', '18600186000', 'sun@example.com', 'Ningbo ...', '55667788', '330201199107289012', 'sun222'),
                          ('CUS015', 'Zhou Shiqi', '18500185000', 'zhou@example.com', 'Qingdao ...', '66778899', '370201198809154321', 'zhou333'),
                          ('CUS016', 'Beijing XX Technology Co.', '01088888888', 'contact@xxtech.com', 'Beijing ...', '99006122', '911101199503012345', 'company123'),
                          ('CUS017', 'Shanghai XX Trading Co.', '02166666666', 'trade@xxgroup.com', 'Shanghai ...', '88773655', '913101199205123456', 'company456'),
                          ('CUS018', 'Guangzhou XX Auto Service', '02099999999', 'service@xxauto.com', 'Guangzhou ...', '77665544', '914401199007234567', 'company789'),
                          ('CUS019', 'Shenzhen XX Logistics', '075577777777', 'logistics@xxwl.com', 'Shenzhen ...', '66553433', '914403199309156789', 'company2024'),
                          ('CUS020', 'Hangzhou XX Tourism', '057155555555', 'travel@xxtour.com', 'Hangzhou ...', '55443622', '913301198904267890', 'company333');


-- -------------------------------
-- 4. 租赁记录表 (rentals)
-- -------------------------------
CREATE TABLE IF NOT EXISTS rentals (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       car_id VARCHAR(20) NOT NULL,
    customer_id VARCHAR(20) NOT NULL,
    staff_id INT NOT NULL,
    start_date DATE NOT NULL,
    due_date DATE NOT NULL,
    actual_return_date DATE,
    total_fee DECIMAL(10, 2),
    FOREIGN KEY (car_id) REFERENCES cars(id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (staff_id) REFERENCES users(id)
    );

INSERT INTO rentals (car_id, customer_id, staff_id, start_date, due_date, actual_return_date, total_fee) VALUES
                                                                                                             ('C001', 'CUS001', 3, '2024-01-05', '2024-01-10', '2024-01-10', 900.00),


-- -------------------------------
-- 5. 系统日志表 (system_logs)
-- -------------------------------
-- 创建系统日志表
CREATE TABLE IF NOT EXISTS system_logs (
                                           log_id INT PRIMARY KEY AUTO_INCREMENT,
                                           username VARCHAR(50) NOT NULL,
    operation_type VARCHAR(50) NOT NULL,
    operation_details TEXT NOT NULL,
    operation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    result VARCHAR(20) NOT NULL
    );


-- -------------------------------
-- 6. 车辆状态表 (vehicle_status)
-- -------------------------------
CREATE TABLE IF NOT EXISTS vehicle_status (
    id INT AUTO_INCREMENT PRIMARY KEY,
    car_id VARCHAR(50) NOT NULL,
    rental_id INT,
    status VARCHAR(50) NOT NULL COMMENT 'Vehicle status: good, damaged, needs_maintenance',
    notes TEXT COMMENT 'Status notes',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (car_id) REFERENCES cars(id),
    FOREIGN KEY (rental_id) REFERENCES rentals(id) ON DELETE SET NULL,
    INDEX idx_car_id (car_id),
    INDEX idx_rental_id (rental_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Vehicle status record table';
