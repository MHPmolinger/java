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

create table product
(
   pid int primary key auto_increment,
   name varchar(20),
   price numeric(6,2),
   madeTime date,
   pdesc varchar(50)
   
);

create table idcard
(
   id int primary key auto_increment,
   cardNo varchar(18) unique
);
create table person
(
  id int primary key auto_increment,
  name varchar(15) not null,
  gender boolean ,
  idcard_id int  unique,
  constraint idcard_id_FK foreign key(idcard_id) references idcard(id)
);

--创建身份证表：
  create table idcard
  (
     cid int primary key auto_increment,
     cardNo varchar(18)
  );
  --创建person表
  create table person
  (
    pid int primary key auto_increment,
    name varchar(15) not null,
    gender boolean,
    idcard_cid int unique,
    constraint idcard_cid_FK foreign key(idcard_cid) references idcard(cid)
  );