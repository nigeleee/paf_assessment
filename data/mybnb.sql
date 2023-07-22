create database mybnb;

use mybnb;

create table acc_occupancy (
acc_id 			varchar(10) not null,
vacancy 		int,
constraint ck_vacancy check(vacancy > 0 and vacancy <=100),
constraint pk_acc_occupancy_acc_id primary key (acc_id)
);


create table reservations(
resv_id 		varchar(8) not null unique,
name 			varchar(128) not null,
email 			varchar(128) not null,
arrival_date 	date,
duration 		int,
acc_id 			varchar(10) not null,
constraint pk_reservations_resv_id primary key(resv_id),
constraint fk_reservations_acc_occupancy foreign key(acc_id) references acc_occupancy(acc_id)
);

-- select * from acc_occupancy; 
