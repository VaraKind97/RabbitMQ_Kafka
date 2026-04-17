
CREATE TABLE credit_applications (
                                     id BIGSERIAL PRIMARY KEY,
                                     amount DECIMAL(15,2) NOT NULL,
                                     term_months INTEGER NOT NULL,
                                     income DECIMAL(15,2) NOT NULL,
                                     current_debt_load DECIMAL(15,2) NOT NULL,
                                     credit_score INTEGER NOT NULL,
                                     status VARCHAR(20) DEFAULT 'PROCESSING'
);