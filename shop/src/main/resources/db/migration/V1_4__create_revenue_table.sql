CREATE TABLE IF NOT EXISTS Revenue (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    locationId int,
    date DATE,
    sum DECIMAL,
    FOREIGN KEY (locationId) REFERENCES Location(id)
    );