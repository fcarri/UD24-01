DROP table IF EXISTS trabajador;

create table trabajador(
	id int primary key auto_increment,
	nombre varchar(250),
    trabajo enum ('programador','quimico','biologo','geologo')
);

insert into trabajador (nombre, trabajo) values ('Juan', 'quimico'); 
insert into trabajador (nombre, trabajo) values ('Albert', 'programador'); 
