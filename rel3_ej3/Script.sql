drop database if exists empresa;

create database empresa;

use empresa;

create table Proyecto (
	Nombre varchar(100) primary key,
	FechaInicio date
);

create table Investigador (
	DNI varchar(9) primary key,
	Nombre_pro varchar(100),
	NombreCompleto varchar(100),
	Direccion varchar(50),
	Telefono int,
	Localidad varchar(50),
	foreign key (Nombre_pro) references Proyecto(Nombre)
);

create table Conferencia (
	Nombre varchar(100) primary key,
	FechaHoraInicio datetime,
	Lugar varchar(50),
	NumeroHoras int
);

create table inv_conf (
	dni_inv varchar(9),
	nom_con varchar(100),
	primary key (dni_inv, nom_con),
	foreign key (dni_inv) references Investigador(DNI),
	foreign key (nom_con) references Conferencia(Nombre)
);

INSERT INTO Proyecto (Nombre, FechaInicio) VALUES
('Proyecto 1', '2020-05-05'),
('Proyecto 2', '2020-06-12'),
('Proyecto 3', '2020-08-15'),
('Proyecto 4', '2020-11-01'),
('Proyecto 5', '2020-12-12');

INSERT INTO Investigador (DNI, Nombre_pro, NombreCompleto, Direccion, Telefono, Localidad) VALUES
('30487452M', 'Proyecto 1', 'Juan Pérez Martínez', 'C./ Desengaño 21', 623423523, 'Cádiz'),
('45768434R', 'Proyecto 2', 'Luisa Puertas Soto', 'C./ Falsa 123', 693543252, 'Cádiz'),
('45642323B', 'Proyecto 3', 'María Ruiz Sánchez', 'C./ Almiel 12', 623234523, 'Cádiz'),
('67534312A', 'Proyecto 2', 'Pablo Fernández Feria', 'Avd. Inventada 15', 613442323, 'Cádiz'),
('65342316R', 'Proyecto 1', 'Sofía Luque Conde', 'C/ La Virtud 1', 664123623, 'Cádiz'),
('67323452B', 'Proyecto 4', 'José López', 'C./ Almiel 15', 723234523, 'Cádiz'),
('78953321A', 'Proyecto 3', 'Andrés Fernán Noria', 'Avd. Inventada 11', 713442323, 'Cádiz'),
('98634571R', 'Proyecto 4', 'Sofía Martín Luz', 'C/ La Virtud 4', 764123623, 'Cádiz');

INSERT INTO Conferencia (Nombre, FechaHoraInicio, Lugar, NumeroHoras) VALUES
('Conferencia 1', '2020-11-02 00:00:00', 'San Fernando', 2),
('Conferencia 2', '2021-01-12 00:00:00', 'Sevilla', 4),
('Conferencia 3', '2021-07-01 00:00:00', 'San Fernando', 1),
('Conferencia 4', '2021-11-02 00:00:00', 'Berlín', 3);

INSERT INTO inv_conf VALUES
('30487452M', 'Conferencia 2'),
('45768434R', 'Conferencia 1'),
('45768434R', 'Conferencia 3'),
('45642323B', 'Conferencia 1'),
('45642323B', 'Conferencia 2'),
('45642323B', 'Conferencia 3'),
('45642323B', 'Conferencia 4'),
('67534312A', 'Conferencia 1'),
('65342316R', 'Conferencia 1'),
('65342316R', 'Conferencia 2'),
('65342316R', 'Conferencia 3'),
('65342316R', 'Conferencia 4');
