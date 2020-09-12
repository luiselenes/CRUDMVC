create database Crud
go

use Crud
go

create table Clientes(
RFC varchar(10) NOT NULL PRIMARY KEY,
Nombre varchar(50) not null,
Edad int not null,
IdCiudad int not null
)
go

insert into Clientes (RFC,Nombre,Edad,IdCiudad) 
values ('LOFM980412','Maria Guadalupe Lopez Felix',22,1)
go

insert into Clientes(RFC,Nombre,Edad,IdCiudad) 
values ('CESE900919','Emilo Cervantes Sanchez',29,2)
go

insert into Clientes(RFC,Nombre,Edad,IdCiudad) 
values ('PACJ811003','Jonathan Saul Pachecho Cisneros',38,1)
go

insert into Clientes(RFC,Nombre,Edad,IdCiudad) 
values ('ESZR730527','Rosa Espinoza Zazueta',47,3)
go

insert into Clientes(RFC,Nombre,Edad,IdCiudad) 	
values ('IRRD600114','Daniel Iribe Romero',60,3)
go 

select * from Clientes


create login tec with password = '123'
GO
sp_addsrvrolemember tec , sysadmin
Go
