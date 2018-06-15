create dataBase hotel;
创建用户表
create table user(
  id int primary key auto_increment,
  user_name varchar(32) not null,
  account varchar(32) not null,
  password varchar(64) not null,
  mobile varchar(16)  not null,
  status int default 0 not null,
  create_time  timestamp  default current_timestamp
);
创建房间表
create table room(
	id int primary key,
	room_name varchar(16) not null,
	room_type varchar(16) not null,
	room_price int not null,
	remark varchar(128) null
);
创建客户信息表
create table customer(
	id int primary key auto_increment,
	name varchar(32) not null,
	gender varchar(16) not null,
	card varchar(32) not null,
	room_id int not null,
	in_time  timestamp  default current_timestamp,
	pay_price int not null,
	remark varchar(128) null
);

添加外键
alter table customer add constraint fk_room_customer foreign key (room_id) references room(id);