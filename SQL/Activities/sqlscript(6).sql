REM   Script: SQL_Activity6
REM   SQL Activity6

CREATE TABLE salesman (salesman_id int, salesman_name varchar2(20), salesman_city varchar2(20), commission int);

DESCRIBE salesman


DESCRIBE salesman


INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

-- Get all salesman ids without any repeated values
select distinct salesman_id from orders;

-- Display the order number ordered by date in ascending order
select order_no, order_date from orders order by order_date;

-- Display the order number ordered by purchase amount in descending order
select order_no, purchase_amount from orders order by purchase_amount DESC;

-- Display the full data of orders that have purchase amount less than 500.
select * from orders where purchase_amount < 500;

-- Display the full data of orders that have purchase amount between 1000 and 2000.
select * from orders where purchase_amount between 1000 and 2000;


