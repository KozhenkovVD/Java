select * from products
select * from customers
select * from orders

update products
set price = 100
where product_name = 'Вода'

update customers
set first_name = 'Сергей'
where id = 1

update orders
set product_count = 3
where id = 10

delete from orders
where id = 1

select count(*) from orders

select
  o.order_date
, p.product_name
, concat(c.first_name, ' ', c.last_name)
from orders o
inner join products p
   on p.id = o.product_id
inner join customers c
   on c.id = o.customer_id

truncate customers cascade
truncate products cascade
truncate orders




