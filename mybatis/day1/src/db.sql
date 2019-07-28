create database mybatis;
use mybatis;
create table tb_user
(
  userId varchar(15) primary key,
  name varchar(15) ,
  age int,
  birthday date
);

create table tb_student
(
  stuId varchar(15) primary key,
  name varchar(15) not null,
  birthday date,
  mobile char(11)
);

create table Role
(
   roleId int primary key auto_increment,
   roleName varchar(20),
   roleDesc varchar(50)
);

create table user2(
   id int primary key,
   name varchar(15)
);