create table animal(
    id int not null primary key auto_increment,
    idraca int not null,
    nomeanimal varchar(40),
    sexo char(1),
    idade int not null,
    porte varchar(15),
    idcidade int not null
);
