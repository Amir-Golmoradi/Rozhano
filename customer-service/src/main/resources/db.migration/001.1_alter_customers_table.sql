ALTER TABLE customers DROP COLUMN full_name;
ALTER TABLE customers ADD COLUMN full_name VARCHAR(50) GENERATED ALWAYS AS (first_name || ' ' || last_name) STORED;
