CREATE TABLE IF NOT EXISTS product_category (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60),
    description varchar(150)
);

CREATE TABLE IF NOT EXISTS supplier (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60)
);

CREATE TABLE IF NOT EXISTS customer (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname varchar(60),
    lastname varchar(60),
    username varchar(60),
    password varchar(60),
    email varchar(70)
);

CREATE TABLE IF NOT EXISTS location (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60),
    address_country varchar(70),
    address_city varchar(70),
    address_county varchar(70),
    address_street_address varchar(70)
);

CREATE TABLE IF NOT EXISTS revenue (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    location_id int,
    date DATE,
    sum DECIMAL,
    FOREIGN KEY (location_id) REFERENCES Location(id)
);

CREATE TABLE IF NOT EXISTS product (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(60),
    description varchar(150),
    price decimal,
    weight double,
    category_id int,
    supplier_id int,
    image_url varchar(100),
    FOREIGN KEY (category_id) REFERENCES product_category(id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);

CREATE TABLE IF NOT EXISTS stock (
    product_id int,
    location_id int,
    quantity int,
    CONSTRAINT PK_Stock PRIMARY KEY (product_id, location_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS orders (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shipped_from int,
    customer_id int,
    created_at DATETIME,
    address_country varchar(70),
    address_city varchar(70),
    address_county varchar(70),
    address_street_address varchar(70),
    FOREIGN KEY (shipped_from) REFERENCES location(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS order_detail (
    order_id int,
    product_id int,
    quantity int,
    CONSTRAINT PK_OrderDetail PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);