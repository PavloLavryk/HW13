CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (length(name) >= 3)
);

CREATE TABLE planet (
    id VARCHAR(50) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]+$'),
    name VARCHAR(500) NOT NULL CHECK (length(name) >= 1)
);

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    client_id INT REFERENCES client(id),
    from_planet_id VARCHAR(50) REFERENCES planet(id),
    to_planet_id VARCHAR(50) REFERENCES planet(id)
);
