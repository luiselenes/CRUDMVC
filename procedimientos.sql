--mostar un cliente con el rfc
CREATE PROCEDURE sp_selectcliente @rfc nvarchar(13)
AS
BEGIN
	select nombre,edad,idciudad from [Crud].[dbo].[Clientes]
	where rfc = @rfc
	;
end
go
--mostrar todos los clientes 

CREATE PROCEDURE sp_selectclientes
AS
BEGIN
	select RFC,Nombre,Edad,IdCiudad from [Crud].[dbo].[Clientes];
end

go
--eliminar un cliente mandando el rfc
CREATE PROCEDURE sp_eliminarcliente @rfc nvarchar(13)
AS
BEGIN
	delete from [Crud].[dbo].[Clientes] where rfc=@rfc;
end
go
--modificar a un cliente
CREATE PROCEDURE sp_modificarcliente @rfc varchar(13), @nombre nvarchar(50), @edad int, @idciudad int
AS 
BEGIN 
	UPDATE [Crud].[dbo].[Clientes]
	SET nombre = @nombre, Edad = @edad,IdCiudad=@idciudad
	WHERE RFC=@rfc;
end
go

CREATE PROCEDURE sp_registrarcliente @rfc varchar(13), @nombre nvarchar(50), @edad int, @idciudad int
AS
BEGIN
	insert into [Crud].[dbo].[Clientes] ([RFC],[Nombre],[Edad],[IdCiudad])
	values (@rfc,@nombre,@edad,@idciudad)
end
go

--blablablabla