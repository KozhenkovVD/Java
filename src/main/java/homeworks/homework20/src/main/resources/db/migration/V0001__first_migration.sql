create table if not exists customers
(
    id         bigserial primary key,
    first_name varchar(50),
    last_name  varchar(50)
);

create table if not exists orders
(
    id           bigserial primary key,
    customer_id  bigint,
    order_date   date,
    orders_count int,
    discount     smallint,
    foreign key (customer_id) references customers (id)
);


insert into customers (first_name, last_name)
values   ('Иванов', 'Иван')
        ,('Брэд', 'Пит')
        ,('Кортни', 'Кокс')
        ,('Данила', 'Козловский')
        ,('Юля', 'Снигирь')
        ,('Анджелина', 'Джоли')








