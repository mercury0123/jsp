-- 2022-11-29
use javadb;
create table member(
id varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
age int,
primary key(id));