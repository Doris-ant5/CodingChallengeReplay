DELETE FROM public.purchaseorder;

DELETE FROM public.companyaccount;

DELETE FROM public.individualaccount;

DELETE FROM public.customer;

DELETE FROM public.address;

DELETE FROM public.product;

DELETE FROM public.order_product;

INSERT INTO public.address(
    id, type, city, country)
VALUES (1, 'PERMANENT', 'Warsaw', 'Poland'),
       (2, 'PERMANENT', 'Berlin', 'Germany'),
       (3, 'SHIPPING', 'Cracow', 'Poland'),
       (4, 'SHIPPING', 'London', 'England'),
       (5, 'PERMANENT', 'Radom', 'Poland'),
       (6, 'SHIPPING', 'Skawina', 'Poland');

INSERT INTO public.customer(
    address_id, id, customer_type, lastname, name)
VALUES (1, 1, 'individual', 'Kowalski', 'Jan'),
       (2, 2, 'company', 'Jungingen', 'Ulrich'),
       (3, 3, 'company', 'Nowak', 'Piotr'),
       (4, 4, 'individual', 'Doe', 'John'),
       (5, 5, 'individual', 'Jantar', 'Paweł'),
       (6, 6, 'company', 'Przybysz', 'Tadeusz');

INSERT INTO public.individualaccount(
    birthdate, id, identifiertag)
VALUES ('13/09/1990', 1, 'PL8687'),
       ('28/03/1986', 2, 'IN3641'),
       ('21/04/1982', 3, 'IN32423'),
       ('03/10/1996', 4, 'ING3641'),
       ('13/09/1990', 5, 'IN8687'),
       ('01/02/1993', 6, 'IN6570');

INSERT INTO public.companyaccount(
    id, companyform, taxnumber)
VALUES (1, 'SOLE_TRADIER', 'PL8687'),
       (2, 'PUBLIC_CORPORATION', 'DEG364134'),
       (3, 'LIMITED_JOINT_STOCK', 'PL32423234'),
       (4, 'SOLE_TRADIER', 'ENG364143'),
       (5, 'SOLE_TRADIER', 'PL868743'),
       (6, 'PARNERSHIP', 'PL657032');

INSERT INTO public.product(
    amountinstock, category, id, price, name)
VALUES (150, 'HOME', 1, 1500.50, 'fridge'),
       (40, 'GARDEN', 2, 249.99, 'bonsai'),
       (23, 'FASHION', 3, 28.50, 'tshirt'),
       (80, 'FASHION', 4, 89.99, 'dress'),
       (10, 'GARDEN', 5, 20.20, 'roses'),
       (150, 'MOTORIZATION', 6, 120.90, 'tyres');

INSERT INTO public.purchaseorder(
    customer_id, id, status, orderdate)
VALUES (1, 1, 'DELIVERED', '27/06/2023'),
       (2, 2, 'IN_DELIVERY', '29/06/2023'),
       (3, 3, 'SORTING_OFFICE', '28/06/2023'),
       (4, 4, 'SORTING_OFFICE', '28/06/2023'),
       (5, 5, 'SUBMIT_FIR_SHIPMENT', '29/06/2023'),
       (6, 6, 'DELIVERED', '21/06/2023');

INSERT INTO public.order_product(
    amount, id, order_id, priceitem, product_id)
VALUES (1, 1, 1, 1500.50, 1),
       (3, 2, 2, 249.99, 2),
       (2, 3, 3, 28.50, 3),
       (1, 4, 4, 89.99, 4),
       (5, 5, 5, 20.20, 5),
       (4, 6, 6, 120.90, 6);
