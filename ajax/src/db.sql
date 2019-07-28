create table tb_province
(
 id varchar2(15) primary key,
 name varchar2(15) not null
);

create table tb_city
(
 id varchar2(15) primary key,
 name varchar2(15) not null,
 province_id varchar2(15),
 constraint FK_province_id  foreign key(province_id) references tb_province(id)
);