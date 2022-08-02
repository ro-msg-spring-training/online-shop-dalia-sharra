CREATE TABLE IF NOT EXISTS Location (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60),
    addressCountry varchar(70),
    addressCity varchar(70),
    addressCounty varchar(70),
    addressStreetAddress varchar(70)
);