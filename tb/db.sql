create database taobao;
use taobao;
create table tb_product
(
  pno varchar(15) primary key,
  pname varchar(20) not null,
  price int,
  pdesc varchar(200),
  imagePath varchar(20)
);