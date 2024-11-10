ALTER TABLE customers
    ADD full_name VARCHAR(60);

ALTER TABLE customers
    ALTER COLUMN full_name SET NOT NULL;

ALTER TABLE customers
    ALTER COLUMN phone_number TYPE VARCHAR(20) USING (phone_number::VARCHAR(20));

ALTER TABLE customers
    ALTER COLUMN zip_code TYPE VARCHAR(15) USING (zip_code::VARCHAR(15));

