INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 645645, 'STANDARD', 'Jan', '13-09-1990', 'Kowalski', 'INDIVIDUAL');
INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 756756, 'EXTRA_PREMIUM', 'Ulrich', '03-10-1996', 'Jung', 'COMPANY');
INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 245477, 'GOLD', 'Piotr', '13-09-1990', 'Nowak', 'COMPANY');
INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 925436, 'PREMIUM', 'John', '14-06-1988', 'Doe', 'INDIVIDUAL');
INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 23548, 'STANDARD', 'Paweł', '27-03-2001', 'Jantar', 'INDIVIDUAL');
INSERT INTO Customer (id, numberIdentification, profileType, name, birthDate, lastName, accountType) VALUES (nextval('customer_id_seq'), 365767, 'EXTRA_PREMIUM', 'Tadeusz', '12-10-1979', 'Przybysz', 'COMPANY');

INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'Warsaw', 'Poland', 'PERMANENT', 1);
INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'Berlin', 'Germany', 'PERMANENT', 2);
INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'Cracow', 'Poland', 'SHIPPING', 3);
INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'London', 'England', 'SHIPPING', 4);
INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'Radom', 'Poland', 'PERMANENT', 5);
INSERT INTO Address (id, city, country, addressType, customer_id) VALUES (nextval('address_id_seq'), 'Skawina', 'Poland', 'SHIPPING', 6);

INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 1500.50, 'fridge', 150, 'HOME');
INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 249.99, 'bonsai', 40, 'GARDEN');
INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 28.50, 'tshirt', 23, 'FASHION');
INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 89.99, 'dress', 80, 'FASHION');
INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 20.20, 'roses', 10, 'GARDEN');
INSERT INTO Product (id, price, name, amountinstock, category) VALUES (nextval('product_id_seq'), 120.90, 'tyres', 150, 'MOTORIZATION');

INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '27-06-2023', 'DELIVERED', 1);
INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '29/06/2023', 'IN_DELIVERY', 2);
INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '28/06/2023', 'SORTING_OFFICE', 3);
INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '28/06/2023', 'SORTING_OFFICE', 4);
INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '29/06/2023', 'SUBMIT_FIR_SHIPMENT', 5);
INSERT INTO PurchaseOrder (id, orderDate, status, customer_id) VALUES (nextval('orders_id_seq'), '21-06-2023', 'DELIVERED', 6);

INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 1, 1, 3, 1500.50);
INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 2, 2, 2, 249.99);
INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 3, 3, 1, 28.50);
INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 4, 4, 1, 89.99);
INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 5, 5, 5, 20.20);
INSERT INTO order_product (id, order_id, product_id, amount, priceItem) VALUES (nextval('orders_product_id_seq'), 6, 6, 4, 120.90);