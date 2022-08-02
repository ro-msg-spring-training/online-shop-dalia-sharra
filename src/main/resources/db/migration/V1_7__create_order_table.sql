CREATE TABLE IF NOT EXISTS ORDERT (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shippedFrom int,
    customerId int,
    createdAt DATETIME,
    addressCountry varchar(70),
    addressCity varchar(70),
    addressCounty varchar(70),
    addressStreetAddress varchar(70),
    FOREIGN KEY (shippedFrom) REFERENCES LOCATION(id),
    FOREIGN KEY (customerId) REFERENCES CUSTOMER(id)

);