DROP TABLE IF EXISTS full_animal_records;
DROP TABLE IF EXISTS shelters;
DROP TABLE IF EXISTS location_history;

CREATE TABLE full_animal_records (
    animal_id INTEGER PRIMARY key,
    category VARCHAR(255) NOT NULL,
    breed VARCHAR(255),
    weight INTEGER,
    gender VARCHAR(255),
    color VARCHAR(255),
    status VARCHAR(255),
    found_time TIMESTAMP NOT NULL ,
    update_time TIMESTAMP NOT NULL ,
    found_location_long DOUBLE PRECISION NOT NULL ,
    found_location_lat DOUBLE PRECISION NOT NULL ,
    current_location_long DOUBLE PRECISION NOT NULL ,
    current_location_lat DOUBLE PRECISION NOT NULL ,
    shelter_id INTEGER
);

CREATE TABLE shelters (
    shelter_id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    capacity INTEGER NOT NULL ,
    availability INTEGER NOT NULL ,
    location_long DOUBLE PRECISION NOT NULL ,
    location_lat DOUBLE PRECISION NOT NULL
);

CREATE TABLE location_history (
    animal_time VARCHAR(255) PRIMARY KEY,
    animal_id INTEGER NOT NULL ,
    update_time TIMESTAMP NOT NULL ,
    location_long DOUBLE PRECISION NOT NULL ,
    location_lat DOUBLE PRECISION NOT NULL
);

