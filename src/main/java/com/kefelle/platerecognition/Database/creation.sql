use crs;

CREATE TABLE admin (
    login varchar(30),
    password varchar(30)
);

CREATE TABLE users (
    id int PRIMARY KEY unique auto_increment,
    fname varchar(30),
    lname varchar(30),
    username varchar(30) unique,
    password varchar(30),
    email varchar(50),
    inscription_date date,
    avatar blob
);
drop table users;
CREATE TABLE usersinrequests (
    fname varchar(30),
    lname varchar(30),
    username varchar(30),
    password varchar(30),
    email varchar(50),
    userconfirm blob
);

CREATE TABLE plate (
    licence_number varchar(15) PRIMARY KEY,
    plate_owner int,
    FOREIGN KEY (plate_owner) REFERENCES users(id)
);
drop table plate;

create table userentry(
	user_id int,
    licence_number varchar(15),
    entry_date date,
    foreign key (user_id) references users(id),
    foreign key (licence_number) references plate(licence_number)
);

select * from users;