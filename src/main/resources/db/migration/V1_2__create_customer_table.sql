CREATE TABLE IF NOT EXISTS Customer (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname varchar(60),
    lastname varchar(60),
    username varchar(60),
    password varchar(60),
    email varchar(70)
);