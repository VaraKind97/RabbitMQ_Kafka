CREATE TABLE IF NOT EXISTS credit_applications (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     amount DECIMAL(15,2) NOT NULL,
                                     term_months INT NOT NULL,
                                     income DECIMAL(15,2) NOT NULL,
                                     current_debt_load DECIMAL(15,2) NOT NULL,
                                     credit_score INT NOT NULL,
                                     status VARCHAR(20) DEFAULT 'IN_PROCESS'
);