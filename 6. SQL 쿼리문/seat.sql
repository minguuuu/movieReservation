create table seat(
seat_id bigint primary key auto_increment,
time_id bigint not null,
number_id varchar(20),
row int,
column int,
area int,
type int);