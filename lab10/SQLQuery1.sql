create database univer;
--------------------

USE [univer]
GO
CREATE TABLE Students(
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Phone] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
--------------------

use univer;
go
create procedure CountStudentsByPartName
	@name NVARCHAR(max),
	@count int output
as 
select @name = '%' + RTRIM(@name) + '%';
select @count = count(*) from Students 
where Name like @name;
go

declare @count int;
exec CountStudentsByPartName 'k', @count OUTPUT
print 'count: ' + convert(varchar, @count);
go
--------------------

drop procedure CountStudentsByPartName;
go
--------------------

select * from Students

SELECT * FROM Students where id > 1 and id < 7