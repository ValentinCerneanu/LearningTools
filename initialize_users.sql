use wap;
drop table if exists usernames;

create table usernames (
  id integer primary key auto_increment,
  username varchar(255) not null,
  password varchar(255) not null,
  email varchar(255) not null,
  gender char(1), 
  tel varchar(255),
  country varchar(255),
  subscribe bool not null
);
