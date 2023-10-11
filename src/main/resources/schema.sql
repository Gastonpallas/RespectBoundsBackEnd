DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
    -- Other fields and constraints as needed
);