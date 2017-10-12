select * from CUSTOMERS;

select * from ORDERS;

delete from ORDERS where CUSTOMER_ID = 1;

delete from ORDERS where ORDER_ID > 0;
delete from CUSTOMERS where CUSTOMER_ID > 0;

insert into CUSTOMERS values (1, "AAA");
insert into CUSTOMERS values (2, "BBB");

insert into ORDERS values (1, "aaa", 1);
insert into ORDERS values (2, "bbb", 1);
insert into ORDERS values (3, "ccc", 2);
insert into ORDERS values (4, "ddd", 2);
insert into ORDERS values (5, "eee", 2);
drop table DEPARTMENTS;
drop table MANAGERS;

select * from CUSTOMERS;
select * from MANAGERS;