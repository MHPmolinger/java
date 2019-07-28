create database spring;
use spring;
create table employee(
  empId varchar(15) primary key,
  name varchar(15),
  hireDate date,
  salary numeric(6)
);

create table account(
  id varchar(19) primary key,
  userName varchar(15),
  balance numeric(6)
);

insert into account values('888888','zhangsan',5000);
insert into account values('999999','lisi',5000);