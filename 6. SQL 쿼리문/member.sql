create table member(
member_id bigint primary key auto_increment,
name varchar(20) not null,
id varchar(20) not null,
pw varchar(20) not null,
email varchar(20) not null,
birthYear int not null,
birthMonth int not null,
birthDate int not null,
cellphone varchar(11) not null,
wTime datetime default current_timestamp,
grade int not null default 0);