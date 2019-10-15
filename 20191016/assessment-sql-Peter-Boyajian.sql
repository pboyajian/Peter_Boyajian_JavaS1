use car_lot;
/*
Add the following cars to inventory:
    1. 2012 Red Honda Accord
    1. 2017 Black Chevy Impala
    1. 2019 Siver Ford F-150
    1. 2020 White Subaru Outback
    1. 2015 Silver Ford Mustang
    1. 2018 Blue Honda Ridgeline
    1. 2017 Gray Chevy Silverado
    */
insert into car (id, model_year, color, make , model) values
	(1, '2012', 'Red', 'Honda ','Accord'), 
    (2, '2017',' Black' ,'Chevy',' Impala'), 
    (3, '2019',' Siver ','Ford ','F-150'),
    (4, '2020', 'White', 'Subaru', 'Outback'),
    (5, '2015', 'Silver', 'Ford' ,'Mustang'), 
    (6,'2018', 'Blue', 'Honda', 'Ridgeline'),
    (7, '2017', 'Gray', 'Chevy', 'Silverado');
    
    --  Make the following updates to the database:
    --     1. Change all Hondas to Black
    update car set color = 'Black' where make='Honda';
    -- Change 'Chevy' to 'Chevrolet'
    update car set make = 'Chevrolet' where make='Chevy';
    --  Change all 2020 model years to 2019
    update car set model_year = '2019' where model_year='Honda';
    
    -- Delete all blue inventory
    delete from car where color='Blue';
    -- delete all Fords
    delete from car where make='Ford';
    -- Delete all cars from 2012 and 2017
    delete from car where model_year in ('2012','2017');
    
    
    
    -- ------------------------------------------------------------------------- car stuff^^^^^^^^^^^^^^^^^
    use northwind;
    -- What are the categories of products in the database?
-- Camera, Laptop, Tablet, Phone
select distinct category from products;

-- What products are made by Dell? 
-- Dell Inspirion Laptop
select * from products where product_name like 'Dell%';

-- List all the orders shipped to Pennsylvania. 
-- 4126 and 4587
select * from orders where ship_state='Pennsylvania';

--  List the first name and last name of all employees with last names that start with w
select first_name, last_name from employees where last_name like 'w%';

-- List all customers from zipcodes that start with 55 
select * from customers where postal_code like '55%';
-- List all customers from zipcodes that end with 0 
select * from customers where postal_code like '%0';
-- List the first name, last name, and email for all customers with a .org email address  
select first_name, last_name, email from customers where email  like '%.org';
-- List the first name, last name, and phone number for all customers from the 202 area code 
select first_name, last_name, phone from customers where phone like '%(202)%';
-- List the order id for each order placed by George Wilson 
select orders.id 
from orders 
inner join customers 
on customer_id=customers.id 
where 
customers.first_name='george' and customers.last_name='wilson';

-- List all the products and quantities associated with order 4003
select products.product_name, products.quantity_per_unit
from orders inner join order_details on id=order_details.order_id
inner join products on order_details.product_id=products.id
where orders.id='4003';