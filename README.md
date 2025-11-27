# 🚗 Car Rental Management System

A desktop rental management application built with Java Swing + MySQL
 PRG2201 Object-Oriented Programming · Group Project
 INTI International University · August 2025 Semester

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
    %% ==========================
    %% 1. Model Layer (模型层)
    %% ==========================
    class Car {
        +int id
        +String brand
        +String model
        +String status
        +BigDecimal price
    }
    class User {
        +int id
        +String username
        +String password
        +String role
    }
    class Rental {
        +int rentalID
        +int customerId
        +int carId
        +LocalDate startDate
        +LocalDate endDate
        +BigDecimal totalCost
    }
    class Customer {
        +String name
        +String licenseNumber
        +String phone
    }
    class SystemLog {
        +String username
        +String operationType
        +LocalDateTime time
        +String result
    }

    %% ==========================
    %% 2. DAO Layer (数据访问层)
    %% ==========================
    class CarDAO {
        +updateStatus(carId, status)
        +updateStock(carId, count)
        +findAllAvailable()
    }
    class UserDAO {
        +findByUsername(username)
        +save(User)
    }
    class RentalDAO {
        +save(Rental)
        +findById(id)
        +updateReturnDate(rentalId)
    }
    class LogDAO {
        +insertLog(SystemLog)
    }

    %% ==========================
    %% 3. Service Layer (业务层)
    %% ==========================
    class AuthService {
        +login(username, password)
        +register(User)
    }
    class RentalService {
        +createRental(customer, car, dates)
        +returnCar(rentalId, status)
        +calculateFee(rental)
    }
    class CarService {
        +getAvailableCars()
        +updateCarInfo(Car)
    }

    %% ==========================
    %% 4. UI Layer (界面层)
    %% ==========================
    class AdminDashboard {
        +showManageCars()
        +showReports()
    }
    class StaffDashboard {
        +showManageRentals()
        +showCarSearch()
    }
    class ManageRentalsPanel {
        +selectCustomer()
        +selectCar()
        +submitRental()
    }

    %% ==========================
    %% Relationships (关系连线)
    %% ==========================
    
    %% UI -> Service
    AdminDashboard ..> CarService : uses
    AdminDashboard ..> AuthService : uses
    StaffDashboard ..> RentalService : uses
    ManageRentalsPanel ..> RentalService : uses
    ManageRentalsPanel ..> CarService : uses

    %% Service -> DAO
    RentalService --> RentalDAO : calls
    RentalService --> CarDAO : calls
    RentalService --> LogDAO : calls
    CarService --> CarDAO : calls
    AuthService --> UserDAO : calls

    %% DAO -> Model (Dependency)
    CarDAO ..> Car : returns/modifies
    UserDAO ..> User : returns/modifies
    RentalDAO ..> Rental : returns/modifies
    RentalDAO ..> Customer : uses

    %% Model Relationships
    Rental "1" -- "1" Car : contains
    Rental "1" -- "1" Customer : associated with
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

| Login Page                 | Registration Page             |
| -------------------------- | ----------------------------- |
| ![img](./images/Login.png) | ![img](./images/Register.png) |

| Staff Page                          | Admin Page                       |
| ----------------------------------- | -------------------------------- |
| ![img](./images/StaffDashboard.png) | ![img](./images/AdminReport.png) |

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
