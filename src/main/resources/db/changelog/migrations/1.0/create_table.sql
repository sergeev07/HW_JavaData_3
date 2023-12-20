create table netology.customers(
                                   id serial primary key,
                                   name varchar(50),
                                   surname varchar(50),
                                   age int,
                                   phone_number varchar(50)
);

create table netology.orders(
                                id serial primary key,
                                "date" timestamp not null default now(),
                                customer_id int references netology.customers (id),
                                product_name varchar(255),
                                amount int
);

insert
into
    netology.customers(name,surname,age,phone_number)
values
    ('Иван', 'Иванов', 25, '89050020202'),
    ('Сергей', 'Пертров', 21, '89030030202'),
    ('Петр', 'Пертров', 28, '89132584578'),
    ('Александр', 'Сидоров', 30, '89135552233');


insert
into
    netology.orders(date,customer_id,product_name,amount)
values
    (default, 1, 'lego', '200'),
    (default, 1, 'sony', '500'),
    (default, 4, 'apple', '2000'),
    (default, 4, 'lg', '5000');