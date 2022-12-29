-- cmd에서 mysql -ujavauser -pmysql → show databases;→use javadb;

create table board3(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
content text,
reg_date datetime default current_timestamp,
primary key(bno));