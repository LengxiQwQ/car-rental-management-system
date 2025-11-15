-- 创建数据库
CREATE DATABASE IF NOT EXISTS mydb;

USE mydb;

-- 示例表
CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(50),
    age INT
    );

-- 示例数据
INSERT INTO users (name, age) VALUES ('Alice', 20);
INSERT INTO users (name, age) VALUES ('Bob', 22);