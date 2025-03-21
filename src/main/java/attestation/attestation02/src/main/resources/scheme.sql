create table if not exists products
(
    id           bigserial primary key,
    product_name varchar(50),
    price        numeric(12,2),
    count        int
);

COMMENT ON TABLE attestation02.products IS 'Таблица Продукты';
COMMENT ON COLUMN attestation02.products.id is 'Идентификатор продукта';
COMMENT ON COLUMN attestation02.products.product_name is 'Название продукта';
COMMENT ON COLUMN attestation02.products.price is 'Стоимость';
COMMENT ON COLUMN attestation02.products.count is 'Количество';

create table if not exists customers
(
    id         bigserial primary key,
    first_name varchar(50),
    last_name  varchar(50)
);
COMMENT ON TABLE attestation02.customers IS 'Таблица Покупатели';
COMMENT ON COLUMN attestation02.customers.id is 'Идентификатор покупателя';
COMMENT ON COLUMN attestation02.customers.first_name is 'Имя';
COMMENT ON COLUMN attestation02.customers.last_name is 'Фамилия';

create table if not exists orders
(
    id           bigserial primary key,
    product_id   bigint,
    customer_id  bigint,
    order_date   date,
    product_count int,
    foreign key (customer_id) references customers (id),
    foreign key (product_id) references products (id)
);
COMMENT ON TABLE attestation02.orders IS 'Таблица Заказы';
COMMENT ON COLUMN attestation02.orders.product_id is 'Идентификатор продукта';
COMMENT ON COLUMN attestation02.orders.customer_id is 'Идентификатор покупателя';
COMMENT ON COLUMN attestation02.orders.order_date is 'Дата заказа';
COMMENT ON COLUMN attestation02.orders.product_count is 'Количество продукта';