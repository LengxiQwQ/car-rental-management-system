# 🚗 Car Rental Management System

A desktop rental management application built with Java Swing + MySQL
 PRG2201 Object-Oriented Programming · Group Project
 INTI International University · August 2025 Semester

 [![Project Status](https://img.shields.io/badge/Status-Complete-brightgreen)](https://github.com/LengxiQwQ/Car-Rental-Management-System)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![GUI](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=flat)](https://www.java.com/)
[![Theme](https://img.shields.io/badge/UI%20Theme-FlatLaf-3c5b96?style=flat&logo=eclipse&logoColor=white)](https://www.formdev.com/flatlaf/)

[![GitHub Repository](https://img.shields.io/badge/Repo-LengxiQwQ%2FCar--Rental--Management--System-5441A5?style=flat&logo=github&logoColor=white)](https://github.com/LengxiQwQ/Car-Rental-Management-System)
[![Authors](https://img.shields.io/badge/Authors-LengxiQwQ%20%26%20Awei63-B83E58?style=flat)](https://github.com/LengxiQwQ/Car-Rental-Management-System#%E5%B7%A8%E5%B3%B0%E6%8A%80%E6%9C%AF)

📘 **English | [简体中文](README_CN.md)** 

------

## 📌 1. Project Introduction

The Car Rental Management System is a complete desktop application built using **Java Swing + JDBC + MySQL**, designed to help car rental companies digitize their operations.

The system includes:

- **Admin functionalities**
- **Staff functionalities**
- Full **rental lifecycle management**
- Modern Swing-based GUI
- Complete database support and logging system

Originally created as the final assignment for **PRG2201 — Object-Oriented Programming**, this project is now released as an open-source reference suitable for:

- Java beginners
- Swing GUI development learners
- JDBC + MySQL learning
- Layered architecture demonstration

------

## ✨ 2. Key System Features

### 👑 Admin

- Staff account management (create, update, delete, view)
- Vehicle inventory management (brand/model/plate/rate/status)
- View all rental records
- View reports and statistics (rental count, vehicle availability, revenue)
- View system logs (filter by user or operation type)
- Search vehicles (brand/model/license plate)

### 👨‍💼 Staff

- Handle rental creation (automatic fee calculation)
- Process vehicle returns (including condition reports)
- Update vehicle availability status
- Manage customer information
- View available vehicles in real time
- Quickly search vehicles and customers

------

## 📂 3. Basic Project Structure

```
src/main/java/carrental/
 ├── model/         # Data model classes (Car/User/Rental)
 ├── db/            # Database connection
 ├── dao/           # Database CRUD operations
 ├── service/       # Business logic
 ├── ui/            # Swing GUI & Main entry point
 ├── util/          # Utility classes
database/init.sql   # Database initialization script
```

------

------

## 🏗️ 4. System Architecture (UML Class Diagram)

The following diagram illustrates the interaction between the **Model**, **DAO**, **Service**, and **UI** layers, demonstrating the standard layered architecture pattern used in this project.

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
### Simplified Core Logic Architecture (UML Class Diagram)

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


## 🛠️ 5. Tech Stack

- **Java - JDK 21**
- **Swing + FlatLaf UI**
- **MySQL**
- **JDBC**
- **IntelliJ IDEA**
- **Cross-platform support (Windows / macOS / Linux)**

------

## 📸 6. System Screenshots

| Login Page                                                   | Registration Page                                            |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![img](https://raw.githubusercontent.com/LengxiQwQ/Car-Rental-Management-System/main/images/Login.png) | ![img](https://raw.githubusercontent.com/LengxiQwQ/Car-Rental-Management-System/main/images/Register.png) |

| Staff Page                                                   | Admin Page                                                   |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![img](https://raw.githubusercontent.com/LengxiQwQ/Car-Rental-Management-System/main/images/StaffDashboard.png) | ![img](https://raw.githubusercontent.com/LengxiQwQ/Car-Rental-Management-System/main/images/AdminReport.png) |

------

## 🗄️ 7. Database Design (MySQL)

Core tables:

| Table Name       | Description                           |
| ---------------- | ------------------------------------- |
| `users`          | Admin and staff accounts              |
| `cars`           | Vehicle information & availability    |
| `customers`      | Customer records                      |
| `rentals`        | Rental transaction records            |
| `vehicle_status` | Vehicle condition details upon return |
| `system_logs`    | System operation logs                 |

### ER Diagram

```mermaid
erDiagram
    %% ---------------------------------------------------------
    %% 1. USERS TABLE (Admin & Staff)
    %% ---------------------------------------------------------
    users {
        INT id PK "Primary Key"
        VARCHAR username "Username (Unique)"
        VARCHAR password "Password (Encrypted)"
        ENUM role "Role (ADMIN, STAFF)"
        TIMESTAMP created_at "Creation Timestamp"
    }

    %% ---------------------------------------------------------
    %% 2. CARS TABLE (Inventory)
    %% ---------------------------------------------------------
    cars {
        VARCHAR id PK "Car ID (e.g., C001)"
        VARCHAR brand "Brand"
        VARCHAR model "Model"
        INT year "Year"
        VARCHAR license_plate "License Plate (Unique)"
        VARCHAR color "Color"
        ENUM status "Status (AVAILABLE, RENTED, MAINTENANCE)"
        DECIMAL daily_fee "Daily Rental Fee"
        INT stock "Stock Quantity"
    }

    %% ---------------------------------------------------------
    %% 3. CUSTOMERS TABLE
    %% ---------------------------------------------------------
    customers {
        VARCHAR customer_id PK "Customer ID"
        VARCHAR name "Full Name"
        VARCHAR phone "Phone Number"
        VARCHAR email "Email Address"
        VARCHAR address "Residential Address"
        VARCHAR driver_license_number "Driver License (Unique)"
        VARCHAR id_card_number "ID Card No. (Unique)"
        VARCHAR password "Login Password"
    }

    %% ---------------------------------------------------------
    %% 4. RENTALS TABLE (Core Transactions)
    %% ---------------------------------------------------------
    rentals {
        INT id PK "Rental ID"
        VARCHAR car_id FK "Car Reference"
        VARCHAR customer_id FK "Customer Reference"
        INT staff_id FK "Staff Reference"
        DATE start_date "Start Date"
        DATE due_date "Expected Return Date"
        DATE actual_return_date "Actual Return Date"
        DECIMAL total_fee "Total Cost"
    }

    %% ---------------------------------------------------------
    %% 5. VEHICLE_STATUS TABLE (Return Conditions)
    %% ---------------------------------------------------------
    vehicle_status {
        INT id PK "Status Record ID"
        VARCHAR car_id FK "Car Reference"
        INT rental_id FK "Rental Reference"
        VARCHAR status "Condition (e.g., Damaged)"
        TEXT notes "Description / Notes"
        TIMESTAMP created_at "Created At"
        TIMESTAMP updated_at "Last Updated"
    }

    %% ---------------------------------------------------------
    %% 6. SYSTEM_LOGS TABLE (Audit Trail)
    %% ---------------------------------------------------------
    system_logs {
        INT log_id PK "Log ID"
        VARCHAR username "Operator Username"
        VARCHAR operation_type "Type (Login, Rent, etc.)"
        TEXT operation_details "Operation Details"
        TIMESTAMP operation_time "Timestamp"
        VARCHAR result "Result (Success/Fail)"
    }

    %% =========================================================
    %% RELATIONSHIPS
    %% =========================================================

    %% 1. A staff member processes multiple rentals
    users ||--o{ rentals : "processes (staff_id)"

    %% 2. A customer places multiple rental orders
    customers ||--o{ rentals : "places (customer_id)"

    %% 3. A car can appear in multiple rental records
    cars ||--o{ rentals : "is_rented_in (car_id)"

    %% 4. A car can have multiple status history records
    cars ||--o{ vehicle_status : "has_history (car_id)"

    %% 5. A rental record generates one return status report
    rentals ||--o| vehicle_status : "generates (rental_id)"
```



### Key Design Features

- Foreign key constraints
- State machine (available / unavailable / maintenance)
- Secure SQL using PreparedStatement
- Logging of all critical operations

------

## 🚀 8. Getting Started

### ✔ Step 1 — Clone the repository

```
git clone https://github.com/LengxiQwQ/Car-Rental-Management-System.git
```

------

### ✔ Step 2 — Create the database

```
CREATE DATABASE Car_Rental_Management_System_DB;
```

Import the SQL file afterward.

------

### ✔ Step 3 — Configure database connection

Edit `DBConnection.java`:

```
private static final String URL = "jdbc:mysql://localhost:3306/Car_Rental_Management_System_DB";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

------

### ✔ Step 4 — Run the program

Run:

```
src/main/java/carrental/ui/Main.java
```

------

## 📂 9. Full Project Directory Explanation

```
└─src
   └─main
       ├─java
       │  └─carrental
       │      │
       │      ├─dao                     # Data Access Layer — handles database CRUD operations
       │      │      CarDAO.java        # CRUD operations for car data (update stock, change status…)
       │      │      CustomerDAO.java   # Handles customer info (add, update, search)
       │      │      LogDAO.java        # Insert/query system logs
       │      │      RentalDAO.java     # CRUD for rental transactions
       │      │      UserDAO.java       # CRUD for user accounts, login validation
       │      │      VehicleStatusDAO.java # Operations for vehicle condition upon return
       │      │
       │      ├─db                      # Database configuration layer
       │      │      DBConnection.java  # JDBC connection manager (getConnection + close)
       │      │      Information.java   # Stores DB configuration constants (URL, username, password)
       │      │
       │      ├─model                   # Model Layer — Java POJOs mapping database tables
       │      │      Car.java           # Entity for car records (cars table)
       │      │      Customer.java      # Entity for customers (customers table)
       │      │      Rental.java        # Entity for rental transactions (rentals table)
       │      │      SystemLog.java     # Entity for log records (system_logs table)
       │      │      User.java          # Entity for system users (users table)
       │      │      userRole.java      # Enum/constant defining user roles
       │      │      VehicleStatus.java # Entity for vehicle return condition (vehicle_status table)
       │      │
       │      ├─service                 # Business Logic Layer
       │      │      AuthService.java   # Authentication (login validation, registration logic)
       │      │      CarService.java    # Vehicle availability checks, filtering logic
       │      │      CustomerService.java # Validating and maintaining customer data
       │      │      LogService.java    # Centralized log writing logic
       │      │      RentalService.java # Core rental workflow (create order, update stock, etc.)
       │      │      VehicleStatusService.java # Handles vehicle condition during return
       │      │
       │      ├─ui                      # User Interface Layer (Swing)
       │      │  │   Main.java          # Program entry point
       │      │  │
       │      │  ├─Admin                # Admin module components
       │      │  │      AddCarFrame.java
       │      │  │      AddStaffFrame.java
       │      │  │      AdminDashboardFrame.java
       │      │  │      ManageCars.java
       │      │  │      ManageStaff.java
       │      │  │      Reports.java
       │      │  │      SystemLogs.java
       │      │  │
       │      │  ├─LoginRegister        # Login & Registration module
       │      │  │      LoginPanel.java
       │      │  │      LoginRegisterFrame.java
       │      │  │      RegisterPanel.java
       │      │  │
       │      │  └─Staff                # Staff module components
       │      │         AvailabilityPanel.java
       │      │         CustomerPanel.java
       │      │         ManageRentalsPanel.java
       │      │         ReTurnCarFrame.java
       │      │         SearchCarsPanel.java
       │      │         StaffDashboardFrame.java
       │      │
       │      └─util                    # Utility Layer
       │             DateUtil.java
       │             DBUtil.java
       │             TimestampUtil.java
       │             Validator.java
       │
       └─resources
```

------

## 👥 10. Collaborators

| Member         | Responsibilities                                             |
| -------------- | ------------------------------------------------------------ |
| **Qiu Zixun**  | Project initialization, UI design & implementation, admin module logic, GitHub management |
| **Yu Chongqi** | Database design & connection, DAO/Service/Model implementation, staff module logic |
