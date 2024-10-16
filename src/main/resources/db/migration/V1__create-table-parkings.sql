create table parkings(

    id bigint not null auto_increment,
    name varchar(100) not null,
    cnpj varchar(100) not null unique,
    street varchar(100) not null,
    district varchar(100) not null,
    cep varchar(9) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    number varchar(20) not null,
    phone varchar(100) not null,
    bike_space varchar(100) not null,
    car_space varchar(100) not null,

    primary key(id)

);