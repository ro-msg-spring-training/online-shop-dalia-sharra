CREATE TABLE IF NOT EXISTS Stock (

    productId int,
    locationId int,
    quantity int,
    CONSTRAINT PK_Stock PRIMARY KEY (productId, locationId),
    FOREIGN KEY (productId) REFERENCES Product(id),
    FOREIGN KEY (locationId) REFERENCES Location(id)
);