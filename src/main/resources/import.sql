INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 645645, 'standard', 'Jan', 'Kowalski', 'individual');
INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 756756, 'expert', 'Ulrich', 'Jung', 'company');
INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 245477, 'gold', 'Piotr', 'Nowak', 'company');
INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 925436, 'standard', 'John', 'Doe', 'individual');
INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 23548, 'standard', 'Paweł', 'Jantar', 'individual');
INSERT INTO Customer (id, numberIdentification, profileType, name, lastName, customer_type) VALUES (nextval('customer_id_seq'), 365767, 'expert', 'Tadeusz', 'Przybysz', 'company');

INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'Warsaw', 'Poland', 'PERMANENT', 1);
INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'Berlin', 'Germany', 'PERMANENT', 2);
INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'Cracow', 'Poland', 'SHIPPING', 3);
INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'London', 'England', 'SHIPPING', 4);
INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'Radom', 'Poland', 'PERMANENT', 5);
INSERT INTO Address (id, city, country, type, customer_id) VALUES (nextval('address_id_seq'), 'Skawina', 'Poland', 'SHIPPING', 6);

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

INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (1, '13-09-1990', 'IN8687');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (4, '03-10-1996', 'ING3641');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (5, '13-09-1990', 'IN8687');

INSERT INTO company_account (id, companyForm, taxNumber) VALUES (2, 'PUBLIC_CORPORATION', 'DEG364134');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (3, 'LIMITED_JOINT_STOCK', 'PL32423234');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (6, 'PARNERSHIP', 'PL657032');