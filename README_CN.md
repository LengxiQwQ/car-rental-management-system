# 🚗 汽车租赁管理系统 (Car Rental Management System)

基于 Java Swing + MySQL 构建的桌面端租赁管理应用
PRG2201 面向对象编程 · 小组作业
英迪国际大学 (INTI International University) · 2025年8月学期

[![Project Status](https://img.shields.io/badge/Status-Complete-brightgreen)](https://github.com/LengxiQwQ/Car-Rental-Management-System)
[![GitHub Actions CI](https://github.com/LengxiQwQ/Car-Rental-Management-System/actions/workflows/maven.yml/badge.svg)](https://github.com/LengxiQwQ/Car-Rental-Management-System/actions/workflows/maven.yml)
[![JDK Version](https://img.shields.io/badge/JDK-21+-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk21-index.html)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![GUI](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=flat)](https://www.java.com/)
[![Theme](https://img.shields.io/badge/UI%20Theme-FlatLaf-3c5b96?style=flat&logo=eclipse&logoColor=white)](https://www.formdev.com/flatlaf/)

📘 **[English](README.md) | 简体中文**

------

## 📌 1. 项目简介

本汽车租赁管理系统是一个基于 **Java Swing + JDBC + MySQL** 开发的完整桌面应用程序，旨在帮助汽车租赁公司实现业务运营的数字化。

系统包含以下核心内容：
- **管理员功能模块**
- **员工功能模块**
- 完整的**租赁生命周期管理**
- 现代化的 Swing 图形用户界面 (GUI)
- 完整的数据库支持与日志记录系统

本项目最初是 **PRG2201 — 面向对象编程** 课程的期末大作业，现在作为开源参考项目发布，特别适合：
- Java 初学者
- Swing GUI 开发的学习者
- JDBC + MySQL 整合的学习者
- 分层架构设计的演示案例

------

## ✨ 2. 系统核心功能

### 👑 管理员 (Admin)

- 员工账号管理（创建、更新、删除、查看）
- 车辆库存管理（品牌/型号/车牌/费率/状态维护）
- 查看所有租赁历史记录
- 查看统计报表（租赁数量、车辆可用率、营收统计）
- 查看系统日志（支持按用户或操作类型筛选）
- 车辆搜索（按品牌/型号/车牌）

### 👨‍💼 员工 (Staff)

- 办理租车业务（自动计算费用）
- 处理还车流程（包含车况检查报告录入）
- 更新车辆可用状态
- 客户信息管理
- 实时查看可用车辆
- 快速搜索车辆与客户

------

## 📂 3. 项目基础结构

```text
src/main/java/carrental/
 ├── model/         # 数据模型类 (Car/User/Rental)
 ├── db/            # 数据库连接配置
 ├── dao/           # 数据库 CRUD 操作 (数据访问层)
 ├── service/       # 业务逻辑层
 ├── ui/            # Swing 图形界面 & 程序入口
 ├── util/          # 通用工具类
database/init.sql   # 数据库初始化脚本
````

-----

## 🏗️ 4. 系统架构 (UML 类图)

下图展示了 **Model (模型层)**、**DAO (数据访问层)**、**Service (业务层)** 和 **UI (界面层)** 之间的交互关系，体现了本项目采用的标准分层架构模式。

```mermaid
classDiagram
    direction TB

    %% =============================================
    %% 1. UI Layer (界面层)
    %% =============================================
    class LoginRegisterFrame {
        -LoginPanel loginPanel
        -RegisterPanel registerPanel
    }
    class AdminDashboardFrame {
        -ManageCars manageCars
        -ManageStaff manageStaff
        -Reports reports
        -SystemLogs systemLogs
    }
    class StaffDashboardFrame {
        -ManageRentalsPanel rentalPanel
        -AvailabilityPanel availabilityPanel
        -CustomerPanel customerPanel
        -SearchCarsPanel searchPanel
    }

    %% UI 组件/弹窗
    class ManageRentalsPanel {
        +addRental()
        +loadRentals()
    }
    class ReTurnCarFrame {
        +processReturn()
    }
    class ManageCars {
        +loadCarData()
        +addCar()
        +deleteSelectedCar()
    }
    class AddCarFrame {
        +addCar()
    }
    class AddStaffFrame {
        +addStaff()
    }
    class Reports {
        +generateReport()
    }
    class LoginPanel {
        +performLogin()
    }

    %% =============================================
    %% 2. Service Layer (业务逻辑层)
    %% =============================================
    class AuthService {
        +login(username, password) User
        +register(User) boolean
        +isAdmin(User) boolean
    }
    class RentalService {
        +getAllRentals() List~Rental~
        +checkoutCar(Rental, User) boolean
        +returnCar(rentalId, returnDate, User) BigDecimal
    }
    class CarService {
        +getAllCars() List~Car~
        +getAvailableCars() List~Car~
        +getCarById(id) Car
        +getCarsByStatus(status) List~Car~
        +updateCarStatus(id, status) boolean
    }
    class CustomerService {
        +getAllCustomers() List~Customer~
        +searchCustomers(keyword) List~Customer~
        +saveCustomer(Customer) boolean
    }
    class VehicleStatusService {
        +recordReturnStatus(carId, status, notes) boolean
        +getLatestStatus(carId) VehicleStatus
    }
    class LogService {
        +recordLog(user, type, details, success) void
    }

    %% =============================================
    %% 3. DAO Layer (数据层)
    %% =============================================
    class UserDAO {
        +findByUsername(username) User
        +login(username, password) User
        +register(User) boolean
        +insert(User) boolean
        +updateRole(userId, role) boolean
    }
    class RentalDAO {
        +findAll() List~Rental~
        +findById(id) Rental
        +insert(Rental) boolean
        +updateReturn(id, date, fee) boolean
    }
    class CarDAO {
        +findAll() List~Car~
        +search(keyword) List~Car~
        +findByStatus(status) List~Car~
        +findById(id) Car
        +updateStatus(id, status) boolean
        +insert(Car) boolean
        +updateBrand(id, brand) boolean
    }
    class CustomerDAO {
        +findAll() List~Customer~
        +findById(id) Customer
        +search(keyword) List~Customer~
        +insert(Customer) boolean
        +update(Customer) boolean
    }
    class VehicleStatusDAO {
        +insert(VehicleStatus) boolean
        +findLatestByCarId(carId) VehicleStatus
    }
    class LogDAO {
        +insert(SystemLog) boolean
        +getAllLogs() List~SystemLog~
    }

    %% =============================================
    %% 4. Model Layer (模型层)
    %% =============================================
    class User {
        -String UserID
        -String username
        -String Password
        -userRole Role
        +toString() String
    }
    class Rental {
        -int rentalID
        -Customer customer
        -Car car
        -int staffId
        -LocalDate startDate
        -LocalDate expectedReturnDate
        -LocalDate actualReturnDate
        -double totalCost
        +calculateRentalDays() long
        +calculateTotalCost() double
        +completeRental() void
        +isOverdue() boolean
    }
    class Car {
        -String CarID
        -String Model
        -String Brand
        -String Color
        -String Status
        -String licensePlate
        -double Price
        -int stock
        +isAvailable() boolean
        +rentCar() void
        +returnCar() void
        +calculateRentalCost(int days) double
    }
    class Customer {
        -String customerID
        -String customerName
        -String phone
        -String driverLicenseNumber
        +updateContactInfo(phone, email, addr) void
    }
    class SystemLog {
        -String username
        -String operationType
        -String result
    }
    class VehicleStatus {
        -String carId
        -Integer rentalId
        -String status
        -String notes
    }
    %% 枚举类
    class userRole {
        <<enumeration>>
        admin
        staff
    }
    class CarStatus {
        <<enumeration>>
        AVAILABLE
        RENTED
        MAINTENANCE
    }

    %% =============================================
    %% 关系连线 (Relationships)
    %% =============================================

    %% UI 包含关系 (Composition)
    LoginRegisterFrame *-- LoginPanel
    AdminDashboardFrame *-- ManageCars
    AdminDashboardFrame *-- Reports
    AdminDashboardFrame *-- SystemLogs
    StaffDashboardFrame *-- ManageRentalsPanel
    StaffDashboardFrame *-- AvailabilityPanel

    %% UI 弹窗依赖 (Dependency)
    ManageRentalsPanel ..> ReTurnCarFrame : opens
    ManageCars ..> AddCarFrame : opens
    AdminDashboardFrame ..> AddStaffFrame : opens

    %% UI 调用 Service / DAO
    LoginPanel ..> AuthService : uses
    ManageRentalsPanel ..> RentalService : uses
    ManageRentalsPanel ..> CarService : uses
    ManageRentalsPanel ..> CustomerService : uses
    ReTurnCarFrame ..> RentalService : uses
    ReTurnCarFrame ..> VehicleStatusService : uses
    ManageCars ..> CarDAO : uses (Direct)
    ManageCars ..> LogService : uses
    Reports ..> RentalService : uses
    AvailabilityPanel ..> CarService : uses

    %% Service 调用 DAO
    AuthService --> UserDAO : calls
    AuthService ..> LogService : logs

    RentalService --> RentalDAO : calls
    RentalService --> CarDAO : calls
    RentalService ..> LogService : logs

    CarService --> CarDAO : calls
    CarService ..> LogService : logs

    CustomerService --> CustomerDAO : calls
    CustomerService ..> LogService : logs

    VehicleStatusService --> VehicleStatusDAO : calls
    VehicleStatusService ..> LogService : logs

    LogService --> LogDAO : calls

    %% DAO 返回 Model
    UserDAO ..> User : returns
    RentalDAO ..> Rental : returns
    CarDAO ..> Car : returns
    CustomerDAO ..> Customer : returns
    LogDAO ..> SystemLog : returns
    VehicleStatusDAO ..> VehicleStatus : returns

    %% Model 内部关联
    Rental --> Car : has
    Rental --> Customer : has
    User --> userRole : type
    Car ..> CarStatus : status type

```


### 精简版核心逻辑架构（UML类图）

```mermaid
classDiagram
    direction TB
    %% Layout Direction: Top to Bottom

    %% =============================================
    %% 1. UI Layer (Presentation)
    %% =============================================
    class LoginPanel {
        +performLogin()
    }
    class AdminDashboard {
        +manageCars()
        +viewReports()
    }
    class StaffDashboard {
        +rentCar()
        +returnCar()
        +searchCars()
    }

    %% =============================================
    %% 2. Service Layer (Business Logic)
    %% =============================================
    class AuthService {
        +login(username, password)
        +register(user)
        +isAdmin(user)
    }
    class RentalService {
        +checkoutCar(rental, staff)
        +returnCar(rentalId, date)
        +calculateFee()
    }
    class CarService {
        +getAvailableCars()
        +updateCarStatus(id, status)
    }
    class CustomerService {
        +saveCustomer(customer)
        +searchCustomers(keyword)
    }

    %% =============================================
    %% 3. DAO Layer (Data Access)
    %% =============================================
    class UserDAO {
        +findByUsername()
        +insert()
    }
    class RentalDAO {
        +insert()
        +updateReturn()
    }
    class CarDAO {
        +findAll()
        +updateStatus()
    }
    class CustomerDAO {
        +insert()
        +update()
    }

    %% =============================================
    %% 4. Model Layer (Core Entities)
    %% Populated with key attributes from your code
    %% =============================================
    class User {
        -String userID
        -String username
        -String password
        -userRole role
    }
    class Rental {
        -int rentalID
        -Car car
        -Customer customer
        -LocalDate startDate
        -double totalCost
        +calculateTotalCost()
    }
    class Car {
        -String carID
        -String brand
        -String model
        -String status
        -double price
        -int stock
        +isAvailable()
    }
    class Customer {
        -String customerID
        -String name
        -String phone
        -String driverLicense
        +updateContactInfo()
    }

    %% =============================================
    %% Core Relationships & Call Flow
    %% =============================================

    %% 1. Login Flow
    LoginPanel ..> AuthService : calls
    AuthService --> UserDAO : calls
    UserDAO ..> User : returns

    %% 2. Admin Flow
    AdminDashboard ..> CarService : manages cars
    AdminDashboard ..> RentalService : views reports

    %% 3. Staff Flow (Rent/Return)
    StaffDashboard ..> RentalService : processes rental
    StaffDashboard ..> CarService : checks availability
    StaffDashboard ..> CustomerService : manages customers

    %% 4. Service -> DAO
    RentalService --> RentalDAO : saves order
    RentalService --> CarDAO : updates stock
    CarService --> CarDAO : queries info
    CustomerService --> CustomerDAO : persists info

    %% 5. DAO -> Model
    RentalDAO ..> Rental : returns
    CarDAO ..> Car : returns
    CustomerDAO ..> Customer : returns

    %% 6. Model Associations
    Rental --> Car : contains
    Rental --> Customer : contains
```



-----

## 🛠️ 5. 技术栈

  - **Java - JDK 21**
  - **Swing + FlatLaf UI** (现代化主题库)
  - **MySQL**
  - **JDBC**
  - **IntelliJ IDEA**
  - **跨平台支持 (Windows / macOS / Linux)**

-----

## 📸 6. 系统截图

| 登录界面 | 注册界面 |
| :---: | :---: |
| ![img](./images/Login.png) | ![img](./images/Register.png) |

| 员工工作台 | 管理员报表 |
| :---: | :---: |
| ![img](./images/StaffDashboard.png) | ![img](./images/AdminReport.png) |

-----

## 🗄️ 7. 数据库设计 (MySQL)

核心数据表说明：

| 表名 | 描述 |
| :--- | :--- |
| `users` | 存储管理员和员工的账户信息 |
| `cars` | 车辆详细信息及库存可用性 |
| `customers` | 客户档案信息 |
| `rentals` | 租赁交易流水记录 |
| `vehicle_status` | 还车时的车况检查详情 |
| `system_logs` | 系统关键操作审计日志 |

### ER 图 (实体关系图)

```mermaid
erDiagram
    %% ---------------------------------------------------------
    %% 1. 用户表 (管理员 & 员工)
    %% ---------------------------------------------------------
    users {
        INT id PK "主键"
        VARCHAR username "用户名 (唯一)"
        VARCHAR password "密码 (加密)"
        ENUM role "角色 (ADMIN, STAFF)"
        TIMESTAMP created_at "创建时间"
    }

    %% ---------------------------------------------------------
    %% 2. 车辆表 (库存)
    %% ---------------------------------------------------------
    cars {
        VARCHAR id PK "车辆ID (如 C001)"
        VARCHAR brand "品牌"
        VARCHAR model "型号"
        INT year "年份"
        VARCHAR license_plate "车牌号 (唯一)"
        VARCHAR color "颜色"
        ENUM status "状态 (AVAILABLE, RENTED, MAINTENANCE)"
        DECIMAL daily_fee "日租金"
        INT stock "库存数量"
    }

    %% ---------------------------------------------------------
    %% 3. 客户表
    %% ---------------------------------------------------------
    customers {
        VARCHAR customer_id PK "客户ID"
        VARCHAR name "姓名"
        VARCHAR phone "电话"
        VARCHAR email "邮箱"
        VARCHAR address "地址"
        VARCHAR driver_license_number "驾照号 (唯一)"
        VARCHAR id_card_number "身份证号 (唯一)"
        VARCHAR password "登录密码"
    }

    %% ---------------------------------------------------------
    %% 4. 租赁表 (核心交易)
    %% ---------------------------------------------------------
    rentals {
        INT id PK "租赁ID"
        VARCHAR car_id FK "关联车辆"
        VARCHAR customer_id FK "关联客户"
        INT staff_id FK "经办员工"
        DATE start_date "开始日期"
        DATE due_date "预计还车日期"
        DATE actual_return_date "实际还车日期"
        DECIMAL total_fee "总费用"
    }

    %% ---------------------------------------------------------
    %% 5. 车辆状态表 (还车记录)
    %% ---------------------------------------------------------
    vehicle_status {
        INT id PK "状态记录ID"
        VARCHAR car_id FK "关联车辆"
        INT rental_id FK "关联租赁"
        VARCHAR status "车况 (如 Damaged)"
        TEXT notes "详细描述/备注"
        TIMESTAMP created_at "创建时间"
        TIMESTAMP updated_at "更新时间"
    }

    %% ---------------------------------------------------------
    %% 6. 系统日志表 (审计)
    %% ---------------------------------------------------------
    system_logs {
        INT log_id PK "日志ID"
        VARCHAR username "操作人"
        VARCHAR operation_type "类型 (登录, 租车等)"
        TEXT operation_details "操作详情"
        TIMESTAMP operation_time "时间戳"
        VARCHAR result "结果 (成功/失败)"
    }

    %% =========================================================
    %% 关系定义
    %% =========================================================

    users ||--o{ rentals : "处理 (staff_id)"
    customers ||--o{ rentals : "下单 (customer_id)"
    cars ||--o{ rentals : "被租赁 (car_id)"
    cars ||--o{ vehicle_status : "拥有历史记录 (car_id)"
    rentals ||--o| vehicle_status : "生成 (rental_id)"
```

### 关键设计特性

  - **完整的外键约束**：确保数据一致性。
  - **状态机机制**：管理车辆状态流转 (Available ↔ Rented ↔ Maintenance)。
  - **安全性**：使用 `PreparedStatement` 防止 SQL 注入。
  - **审计追踪**：记录所有关键的增删改查操作。

-----

## 🚀 8. 快速开始 (Getting Started)

### ✔ 第一步 — 克隆仓库

```bash
git clone [https://github.com/LengxiQwQ/Car-Rental-Management-System.git](https://github.com/LengxiQwQ/Car-Rental-Management-System.git)
```

### ✔ 第二步 — 创建数据库

```sql
CREATE DATABASE Car_Rental_Management_System_DB;
```

随后请导入项目提供的 SQL 初始化文件。

### ✔ 第三步 — 配置数据库连接

编辑 `src/main/java/carrental/db/DBConnection.java` (或相应路径)：

```java
private static final String URL = "jdbc:mysql://localhost:3306/Car_Rental_Management_System_DB";
private static final String USER = "root"; // 你的数据库用户名
private static final String PASSWORD = "your_password"; // 你的数据库密码
```

### ✔ 第四步 — 运行程序

运行主程序入口：

```text
src/main/java/carrental/ui/Main.java
```

-----

## 📂 9. 完整项目目录解析

```text
└─src
   └─main
       ├─java
       │  └─carrental
       │      │
       │      ├─dao                     # [数据访问层] 处理所有数据库 CRUD 操作
       │      │      CarDAO.java        # 车辆数据操作 (更新库存、修改状态等)
       │      │      CustomerDAO.java   # 客户信息操作 (添加、更新、搜索)
       │      │      LogDAO.java        # 系统日志写入与查询
       │      │      RentalDAO.java     # 租赁交易处理
       │      │      UserDAO.java       # 用户账户操作、登录验证
       │      │      VehicleStatusDAO.java # 车辆还车状况记录
       │      │
       │      ├─db                      # [数据库配置层]
       │      │      DBConnection.java  # JDBC 连接管理器 (获取连接与释放资源)
       │      │      Information.java   # 存储数据库配置常量 (URL, 账号, 密码)
       │      │
       │      ├─model                   # [模型层] 映射数据库表的 Java 实体类 (POJO)
       │      │      Car.java           # 车辆实体 (对应 cars 表)
       │      │      Customer.java      # 客户实体 (对应 customers 表)
       │      │      Rental.java        # 租赁订单实体 (对应 rentals 表)
       │      │      SystemLog.java     # 日志实体 (对应 system_logs 表)
       │      │      User.java          # 用户实体 (对应 users 表)
       │      │      userRole.java      # 定义用户角色的枚举/常量
       │      │      VehicleStatus.java # 车况实体 (对应 vehicle_status 表)
       │      │
       │      ├─service                 # [业务逻辑层]
       │      │      AuthService.java   # 认证服务 (登录校验、注册逻辑)
       │      │      CarService.java    # 车辆服务 (可用性检查、筛选逻辑)
       │      │      CustomerService.java # 客户数据验证与维护
       │      │      LogService.java    # 集中式日志记录逻辑
       │      │      RentalService.java # 核心租赁流程 (创建订单+扣减库存事务处理)
       │      │      VehicleStatusService.java # 还车时的车况处理
       │      │
       │      ├─ui                      # [用户界面层] Swing 组件
       │      │  │   Main.java          # 程序启动入口
       │      │  │
       │      │  ├─Admin                # 管理员模块组件
       │      │  │      AddCarFrame.java
       │      │  │      AddStaffFrame.java
       │      │  │      AdminDashboardFrame.java
       │      │  │      ManageCars.java
       │      │  │      ManageStaff.java
       │      │  │      Reports.java
       │      │  │      SystemLogs.java
       │      │  │
       │      │  ├─LoginRegister        # 登录注册模块
       │      │  │      LoginPanel.java
       │      │  │      LoginRegisterFrame.java
       │      │  │      RegisterPanel.java
       │      │  │
       │      │  └─Staff                # 员工模块组件
       │      │         AvailabilityPanel.java
       │      │         CustomerPanel.java
       │      │         ManageRentalsPanel.java
       │      │         ReTurnCarFrame.java
       │      │         SearchCarsPanel.java
       │      │         StaffDashboardFrame.java
       │      │
       │      └─util                    # [工具层]
       │             DateUtil.java
       │             DBUtil.java
       │             TimestampUtil.java
       │             Validator.java
       │
       └─resources
```

-----

## 👥 10. 贡献者

| 成员 | 主要职责 |
| :--- | :--- |
| **邱子迅** | 项目初始化、UI 设计与实现、管理员模块逻辑、GitHub 协作管理 |
| **瑜翀祺** | 数据库设计与连接、DAO/Service/Model 层实现、员工模块逻辑 |

```
```