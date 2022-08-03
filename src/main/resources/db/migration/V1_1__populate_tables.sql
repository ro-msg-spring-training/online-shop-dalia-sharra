INSERT INTO product_category (name, description)
VALUES ('ProductCategory1', 'Description1');

INSERT INTO supplier (name)
VALUES ('Supplier1');

INSERT INTO product (name, description, price, weight, category_id, supplier_id, image_url)
VALUES ('Product1', 'Description1', 1979.9, 10, 1, 1, 'imageUrl1');

INSERT INTO product (name, description, price, weight, category_id, supplier_id, image_url)
VALUES ('Product2', 'Description2', 587.9, 4, 1, 1, 'imageUrl2');

INSERT INTO product (name, description, price, weight, category_id, supplier_id, image_url)
VALUES ('Product3', 'Description3', 134.5, 3, 1, 1, 'imageUrl3');

INSERT INTO product (name, description, price, weight, category_id, supplier_id, image_url)
VALUES ('Product4', 'Description4', 645.2, 1, 1, 1, 'imageUrl4');

INSERT INTO location (name, address_country, address_city, address_county, address_street_address)
VALUES ('Location1', 'Romania', 'Cluj-Napoca', 'Cluj', 'Strada Croitorilor 5');

INSERT INTO location (name, address_country, address_city, address_county, address_street_address)
VALUES ('Location2', 'Romania', 'Brasov', 'Brasov', 'Strada Fagului 15');

INSERT INTO location (name, address_country, address_city, address_county, address_street_address)
VALUES ('Location3', 'Romania', 'Cluj-Napoca', 'Cluj', 'Strada Observatorului 45');

INSERT INTO stock (product_id, location_id, quantity)
VALUES (1, 1, 5);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (2, 1, 1);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (3, 1, 3);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (1, 2, 3);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (2, 2, 2);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (3, 2, 8);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (1, 3, 8);

INSERT INTO stock (product_id, location_id, quantity)
VALUES (2, 3, 1);