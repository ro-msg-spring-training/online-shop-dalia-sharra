CREATE TABLE IF NOT EXISTS Product (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60),
    description varchar(150),
    price decimal,
    weight double,
    categoryId int,
    supplierId int,
    imageUrl varchar(100),
    FOREIGN KEY (categoryId) REFERENCES ProductCategory(id),
    FOREIGN KEY (supplierId) REFERENCES Supplier(id)
);