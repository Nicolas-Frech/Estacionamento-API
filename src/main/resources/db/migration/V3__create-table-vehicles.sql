create table vehicles(

    id bigint not null auto_increment,
    brand varchar(100) not null,
    model varchar(100) not null,
    color varchar(100) not null,
    plate varchar(15) not null unique,
    type varchar(10) not null,
    active tinyint,

    primary key(id)

);