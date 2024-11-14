CREATE TABLE customers
(
    id           UUID                     NOT NULL,
    first_name   VARCHAR(70)              NOT NULL,
    last_name    VARCHAR(70)              NOT NULL,
    phone_number VARCHAR(15)              NOT NULL,
    address      VARCHAR(120)             NOT NULL,
    created_at   TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted      BOOLEAN                  NOT NULL,
    deleted_at   TIMESTAMP WITH TIME ZONE          DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);
