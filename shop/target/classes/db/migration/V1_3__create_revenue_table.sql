CREATE TABLE IF NOT EXISTS Revenue (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    location varchar(150),
    date DATE,
    sum DECIMAL
);