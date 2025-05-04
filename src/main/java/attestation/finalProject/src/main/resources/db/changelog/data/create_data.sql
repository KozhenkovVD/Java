insert into customers (login, password, name, email, in_date_time)
values   ('vlad@mail.ru', '12345','Владимир', 'vlad@mail.ru', now())
        ,('anton@mail.ru', '56488','Антон', 'anton@mail.ru', now())
        ,('andrey@mail.ru', '56488', 'Андрей', 'andrey@mail.ru', now());

insert into products (type, name, price, in_date_time)
values   (0,'Шиномонтаж на дисках R 17', 3500, now())
        ,(0,'Шиномонтаж на дисках R 18', 4000, now())
        ,(0,'Шиномонтаж на дисках R 19', 5000, now())
        ,(0,'Шиномонтаж на дисках R 20', 8000, now())
        ,(0,'Посомотреть как работает сотрудник',  5000, now())
        ,(0,'Дать совет',  15000, now())
        ,(0,'Балансировка', 1000, now())
        ,(0,'Подкачка колес', 300, now())
        ,(1,'Груз 5г',  30, now())
        ,(1,'Груз 10г', 40, now())
        ,(1,'Груз 15г', 50, now());

insert into cart_products_list (customer_id, product_id, quantity, in_date_time)
values (1 ,2, 1, now())
	  ,(1 ,5, 1, now())
	  ,(1 ,11, 7, now())
	  ,(2 ,7, 1, now())
	  ,(2 ,6, 1, now())
	  ,(2 ,10, 9, now());

insert into orders (order_date, customer_id, in_date_time)
values ('20250101', 2, now())

--insert into order_product_list (order_id, product_id, price, quantity)
--values (1 ,2, 3000, 1)