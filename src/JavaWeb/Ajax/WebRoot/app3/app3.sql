create table locations (
	id int primary key not null AUTO_INCREMENT,
    city varchar(10) not null default ''
);

create table departments(
	id int primary key not null AUTO_INCREMENT,
    name varchar(20) not null default '',
    location_id int not null,
    foreign key (location_id) references locations(id)
);

create table employees (
	id int primary key not null AUTO_INCREMENT,
	last_name varchar(20) not null default '',
    salary float not null default 0,
    department_id int not null,
    foreign key (department_id) references departments(id)
);

select * from locations;
select * from departments;
select * from employees;

delete from locations where id > 0;

insert into locations (city) values ('洛阳');
insert into locations (city) values ('长安');
insert into locations (city) values ('应天');
insert into locations (city) values ('凉州');

insert into departments (name,location_id) values ('中书省',6);
insert into departments (name,location_id) values ('尚书省',7);
insert into departments (name,location_id) values ('门下省',8);

insert into employees (last_name,salary,department_id) values ('常子欣',10000,2);
insert into employees (last_name,salary,department_id) values ('常子欣',10000,2);
insert into employees (last_name,salary,department_id) values ('常子欣',10000,2);
insert into employees (last_name,salary,department_id) values ('常子欣',10000,2);

select id, last_name as lastName, salary from employees where department_id = 1;