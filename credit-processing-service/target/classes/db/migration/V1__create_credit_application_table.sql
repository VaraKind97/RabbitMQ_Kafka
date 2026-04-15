CREATE TABLE IF NOT EXISTS credits (
                                       id BIGSERIAL PRIMARY KEY,
                                       amount NUMERIC(15, 2) NOT NULL,
    term_month INTEGER NOT NULL,
    monthly_income NUMERIC(15, 2) NOT NULL,
    loan_payments NUMERIC(15, 2) NOT NULL,
    credit_score INTEGER NOT NULL,
    created_at TIMESTAMP,
    status VARCHAR(50)
    );