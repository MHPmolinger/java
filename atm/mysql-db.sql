create database atm;
use atm;

create table tb_user
(
     id varchar(50) primary key,
     name varchar(15) not null,
     sex int check(sex=0 or sex=1),
     mobile char(11),
     idcard varchar(18)
);
	
create table tb_account
(
   id int primary key auto_increment ,
   cardNo varchar(19) not null unique,
   loginPwd varchar(15) not null,
   bankName varchar(25),
   cardType int default 0,
   balance numeric(8,2),
   bankStatus default 0,
   user_id varchar(50),
   constraint user_id_FK foreign key(user_id) references tb_user(id)
);
