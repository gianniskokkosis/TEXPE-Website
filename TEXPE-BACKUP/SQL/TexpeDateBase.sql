use ismgroup35;

drop table calendar;
drop table expense;
drop table income;
drop table users;

create table Users(
	name varchar(45),
    surname varchar(45),
    username varchar(45),
    email varchar(45),
    password varchar(45),
	primary key (username)
);

create table income(
    incomeDate varchar(45),
    incomeAmount int,
    incomeCategory varchar(45),
    incomeDescription varchar(45),
    username varchar(45),
    foreign key (username) references Users(username)
);

create table expense(
    expDate varchar(45),
    expAmount int,
    expCategory varchar(45),
    expDescription varchar(45),
    username varchar(45),
    foreign key (username) references Users(username)
);

create table calendar(
	calendarDate varchar(45),
    username varchar(45),
    foreign key (username) references Users(username)
);

insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Teo','Boufis','tboufis','teodore_boufis@gmail.com','11111');
insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Dionisis','Fioravantes','dfior','dfioravantes@gmail.com','22222');
insert into users (users.name,users.surname,users.username,users.email,users.password) values ('Giannis','Kokkosis','jkok','gkokkosis1998@gmail.com','33333');

select * from users;