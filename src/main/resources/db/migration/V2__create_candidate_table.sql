CREATE TABLE candidate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    gender VARCHAR(50) NOT NULL,
    salary_expected DECIMAL(15, 2) NOT NULL,
    process_date DATETIME NOT NULL,
    modification_date DATETIME
);