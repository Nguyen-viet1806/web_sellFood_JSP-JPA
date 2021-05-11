Create database Vietnqph11698_Ass
go 
user Vietnqph11698_Ass
go

if OBJECT_ID('tblStatus') is not null 
drop table tblStatus 
go 
create table tblStatus (
idStatus int identity not null primary key ,
nameStatus nvarchar(50) not null
)

if OBJECT_ID('tblCategory') is not null 
drop table tblCategory 
go 
create table tblCategory (
idCategory int identity not null primary key ,
nameCategory nvarchar(100) not null ,
idStatus int not null 
constraint fk_tblStatus_tblCategory foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblUser') is not null 
drop table tblUser 
go 
create table tblUser (
idUser int identity not null primary key ,
nameUser nvarchar(300) not null ,
birthDayUser date not null ,
addressUser nvarchar(300) not null,
phoneNumber varchar(11) not null,
noteUser nvarchar(500) not null,
imgUser nvarchar(1000) not null,
idStatus int not null 

constraint fk_tblStatus_tblUser foreign key (idStatus) references tblStatus 
)



if OBJECT_ID('tblRole') is not null 
drop table tblRole 
go 
create table tblRole (
idRole int identity not null primary key ,
nameRole nvarchar(50) not null ,
idStatus int not null 

constraint fk_tblStatus_tblRole foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblAccount') is not null 
drop table tblAccount 
go 
create table tblAccount (
idAccount int identity not null primary key ,
email nvarchar(50) not null ,
password nvarchar(100) not null,
idUser int not null,
idRole int not null,
idStatus int not null 
constraint fk_tblUser_tblAccount foreign key (idUser) references tblUser ,
constraint fk_tblRole_tblAccount foreign key (idRole) references tblRole ,
constraint fk_tblStatus_tblAccount foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblProduct') is not null 
drop table tblProduct 
go 
create table tblProduct (
idProduct int identity not null primary key ,
nameProduct nvarchar(100) not null ,
imgProduct nvarchar(1000) not null,
moneyProduct float  not null,
noteProduct nvarchar(1000) not null,
idCategory int not null ,
idStatus int not null 
constraint fk_tblCategory_tblProduct foreign key (idCategory) references tblCategory ,
constraint fk_tblStatus_tblProduct foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblCart') is not null 
drop table tblCart 
go 
create table tblCart (
idCart int identity not null primary key ,
idUser int not null ,
idStatus int not null ,
noteCart nvarchar(500) not null
constraint fk_tblUser_tblCart foreign key (idUser) references tblUser ,
constraint fk_tblStatus_tblCart foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblCartDetail') is not null 
drop table tblCartDetail 
go 
create table tblCartDetail (
idCartDetail int identity not null primary key ,
idCart int not null ,
idProduct int not null,
quantityProduct int not null 
constraint fk_tblCart_tblCartDetail foreign key (idCart) references tblCart ,
constraint fk_tblProduct_tblCartDetail foreign key (idProduct) references tblProduct ,
 
)

if OBJECT_ID('tblBill') is not null 
drop table tblBill 
go 
create table tblBill (
idBill int identity not null primary key ,
idUser int not null ,
idStatus int not null ,
dateOrder date not null,
noteBill nvarchar(500) not null 

constraint fk_tblUser_tblBill foreign key (idUser) references tblUser ,
constraint fk_tblStatus_tblBill foreign key (idStatus) references tblStatus 
)

if OBJECT_ID('tblBillDetail') is not null 
drop table tblBillDetail 
go 
create table tblBillDetail (
idBillDetail int identity not null primary key ,
idBill int not null ,
idProduct int not null ,
quantityProduct int not null,


constraint fk_tblBill_tblBillDetail foreign key (idBill) references tblBill ,
constraint fk_tblProduct_tblBillDetail foreign key (idProduct) references tblProduct 
)


select * from tblCartDetail where idCart = 2
select * from tblUser
select * from tblBill
select * from tblStatus


go
create proc spCartDetail(@Id INT)
as
begin 
delete from tblCartDetail where idCartDetail = @Id 
end


go
create proc SPInsertBill(@idUser INT, @idStatus INT, @dateOrder date,@notBill NVARCHAR)
as
begin 
insert into tblBill(idUser, idStatus, dateOrder,noteBill) output inserted.idBill values (@idUser, @idStatus, @dateOrder,@notBill)
end

