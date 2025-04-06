create table if not exists customers
(
    id         bigserial primary key,
    first_name varchar(50),
    last_name  varchar(50)
);

create table if not exists orders
(
    id           bigserial primary key,
    consumer_id  bigint,
    order_date   date,
    orders_count int,
    discount     smallint,
    foreign key (consumer_id) references customers (id)
);
