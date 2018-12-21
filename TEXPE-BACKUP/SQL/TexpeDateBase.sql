drop table income;
drop table expense;
drop table calendar;
drop table Users;

use ismgroup35;

create table Users(
	userid int auto_increment,
	name varchar(45),
    surname varchar(45),
    username varchar(45),
    email varchar(45),
    password varchar(45),
	primary key (userid)
);

create table income(
    incomeDate date,
    incomeAmount int,
    incomeCategory varchar(45),
    incomeDescription varchar(45),
    iduser int,
    foreign key (iduser) references Users(userid)
);

create table expense(
    expDate date,
    expAmount int,
    expCategory varchar(45),
    expDescription varchar(45),
    iduser int,
    foreign key (iduser) references Users(userid)
);

create table calendar(
	calendarDate date,
    iduser int,
    foreign key (iduser) references Users(userid)
);

insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Teo','Boufis','tboufis','teodore_boufis@gmail.com','11111');
insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Dionisis','Fioravantes','dfior','dfioravantes@gmail.com','22222');
insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Giannis','Kokkosis','jkok','gkokkosis1998@gmail.com','33333');

select*from users;