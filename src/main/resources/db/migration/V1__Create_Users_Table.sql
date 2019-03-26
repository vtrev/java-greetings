create table USERS (
    ID int SERIAL,
    NAME varchar(100) not null unique,
    GREET_COUNT int not null
);