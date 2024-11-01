CREATE TABLE customers
(
    id           SERIAL PRIMARY KEY,
    full_name    VARCHAR(50)  NOT NULL,
    phone_number VARCHAR(20)  NOT NULL,
    city         VARCHAR(255) NOT NULL,
    street       VARCHAR(255) NOT NULL,
    alley        VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(15)  NOT NULL,
    CONSTRAINT unique_phone_number UNIQUE (phone_number)
);
