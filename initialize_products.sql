use wap;
drop table if exists products;

create table products (
  id integer primary key auto_increment,
  name varchar(255) not null,
  type varchar(255) not null,
  description varchar(255) not null,
  unitprice double not null
);



insert into products values (default, 'Macbook', 'Computer', 'Expensive Laptop', 2000);
insert into products values (default, 'Sony Vaio', 'Computer', 'Moderately expensive Laptop', 1500);
insert into products values (default, 'Asus EEE PC', 'Computer', 'Cheap Netbook', 500);
