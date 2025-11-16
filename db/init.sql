-- Create database
CREATE DATABASE IF NOT EXISTS car_rental_db;

USE car_rental_db;

-- Create User table
CREATE TABLE IF NOT EXISTS Users (
    UserID VARCHAR(50) PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    Role ENUM('admin', 'staff') NOT NULL,
    details TEXT
);

-- Create Cars table
CREATE TABLE IF NOT EXISTS Cars (
    CarID VARCHAR(50) PRIMARY KEY,
    Model VARCHAR(100) NOT NULL,
    Brand VARCHAR(100) NOT NULL,
    Color VARCHAR(50),
    Status ENUM('available', 'unavailable', 'rented', 'maintenance') NOT NULL,
    description TEXT,
    licensePlate VARCHAR(20) UNIQUE,
    Price DECIMAL(10, 2) NOT NULL,
    year INT,
    stock INT DEFAULT 0
);

-- Insert sample data
INSERT INTO Users (UserID, username, Password, Role, details) VALUES 
('U001', 'Alice', 'password123', 'admin', 'System administrator'),
('U002', 'Bob', 'password456', 'staff', 'Sales representative');

INSERT INTO Cars (CarID, Model, Brand, Color, Status, description, licensePlate, Price, year, stock) VALUES 
('C001', 'Camry', 'Toyota', 'White', 'available', 'Sedan with great fuel economy', 'ABC123', 50.00, 2022, 2),
('C002', 'Civic', 'Honda', 'Red', 'rented', 'Compact car', 'XYZ789', 40.00, 2021, 0);