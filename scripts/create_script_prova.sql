/*Script de População do banco*/

select * from Carrinho;

create table Usuario (
idUser integer not null primary key,
nome varchar(30) not null,
senha varchar(30) not null
);

create table Carrinho(
    idCar integer not null primary key,
    modelo varchar(30) not null,
    marca varchar(30) not null,
    idUsuario integer not null,
    foreign key (idUsuario) references Usuario(idUser)
);