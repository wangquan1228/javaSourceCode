create database mybatis;

use mybatis;

create table  student(

  id int not null auto_increment,
  name varchar(32) not null,
  age int not null,
  create_time datetime null,
  primary key(id)
);
 
(大型项目中一般不是使用数据自带的主键,拒绝数据库方法)
mysql:select * from student;