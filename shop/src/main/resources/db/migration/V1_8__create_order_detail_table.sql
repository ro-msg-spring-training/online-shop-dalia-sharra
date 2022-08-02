CREATE TABLE IF NOT EXISTS OrderDetail (

    orderId int,
    productId int,
    quantity int,
    CONSTRAINT PK_OrderDetail PRIMARY KEY (orderId, productId),
    FOREIGN KEY (orderId) REFERENCES ORDERT(id),
    FOREIGN KEY (productId) REFERENCES Product(id)
);