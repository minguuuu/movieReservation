create table time(
time_id bigint primary key auto_increment,
room_id bigint not null,
start_time time,
end_time time);