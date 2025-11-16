-- Create tables for Car Rental Management System

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Customers table
CREATE TABLE IF NOT EXISTS customers (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customer_id VARCHAR(50) UNIQUE NOT NULL,
    driver_license_number VARCHAR(50),
    phone_number VARCHAR(20),
    email VARCHAR(100),
    address TEXT
);

-- Cars table
CREATE TABLE IF NOT EXISTS cars (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INTEGER NOT NULL,
    license_plate VARCHAR(20) UNIQUE NOT NULL,
    color VARCHAR(30),
    status VARCHAR(20) NOT NULL DEFAULT 'available'
);

-- Rentals table
CREATE TABLE IF NOT EXISTS rentals (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customer_id VARCHAR(50) NOT NULL,
    car_id INTEGER NOT NULL,
    rental_start_date DATE NOT NULL,
    rental_end_date DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'active',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);

-- Insert default admin user
INSERT INTO users (username, password, role) VALUES 
    ('admin', 'admin123', 'admin'),
    ('staff', 'staff123', 'staff');