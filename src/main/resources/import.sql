INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'Warsaw', 'Poland', 'PERMANENT');
INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'Berlin', 'Germany', 'PERMANENT');
INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'Cracow', 'Poland', 'SHIPPING');
INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'London', 'England', 'SHIPPING');
INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'Radom', 'Poland', 'PERMANENT');
INSERT INTO Address (id, city, country, type) VALUES (nextval('address_id_seq'), 'Skawina', 'Poland', 'SHIPPING');

INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'Jan', 'Kowalski', 'individual', 1);
INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'Ulrich', 'Jung', 'company', 2);
INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'Piotr', 'Nowak', 'company', 3);
INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'John', 'Doe', 'individual', 4);
INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'Paweł', 'Jantar', 'individual', 5);
INSERT INTO Customer (id, name, lastName, customer_type, address_id) VALUES (nextval('customer_id_seq'), 'Tadeusz', 'Przybysz', 'company', 6);

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
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (2, '28-03-1986', 'IN3641');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (3, '21-04-1982', 'IN32423');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (4, '03-10-1996', 'ING3641');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (5, '13-09-1990', 'IN8687');
INSERT INTO individual_account (id, birthDate, identifierTag) VALUES (6, '01-02-1993', 'IN6570');

INSERT INTO company_account (id, companyForm, taxNumber) VALUES (1, 'SOLE_TRADIER', 'PL8687');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (2, 'PUBLIC_CORPORATION', 'DEG364134');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (3, 'LIMITED_JOINT_STOCK', 'PL32423234');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (4, 'SOLE_TRADIER', 'ENG364143');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (5, 'SOLE_TRADIER', 'PL868743');
INSERT INTO company_account (id, companyForm, taxNumber) VALUES (6, 'PARNERSHIP', 'PL657032');