use booksoftware
create database booksoftware
drop database booksoftware  --creating tables
create table Author(
auth_id int primary key,
Auth_name varchar(100) not null,
Auth_country varchar(100) not null,
created_date datetime,
);
--creating books
create table Books(
book_id int primary key,
booktitle varchar(100)  not null,
category varchar(100) not null,
book_price money not null,
auth_id int foreign key references author(auth_id),
created_date datetime not null,
imglink text
);

 

--creating inventory
create table Inventory(
Inventory_id int identity(301,1) primary key,
Book_id int  foreign key references Books(book_id),

 

stock_level_used int not null ,
stock_level_new int not null,
createdat datetime not null
);
--creating customers 
create table customers(
cust_id int identity(501,1) primary key,
cust_name varchar(100) not null,
cust_mobile  bigint unique  not null check(cust_mobile>=1000000000 and cust_mobile<=9999999999),
emailId varchar(100) unique not null,
postal_code int not null,
state varchar(100) not null,
password varchar(100) not null,
createdat date
);

 

--creating the admin table
create table admins(
admin_id int identity(1,1) primary key,
email varchar(100) unique not null,
name varchar(100) not null,
phone_number bigint unique  not null check(phone_number>=1000000000 and phone_number<=9999999999),
address text not null,
password varchar(100) not null,
createdAt datetime 
)

 

-----CREATION  OF BUCKET TABLE----------
create table bucket(
bucket_id int identity(1001,1) primary key,
cust_id int foreign key references customers(cust_id),
book_id int  foreign key references Books(book_id),
quantity int,
price money,
);

 

-----CREATION OF PAYMENT------
create table payment(
pay_id int identity(601,1) primary key,
cust_id int foreign key references customers(cust_id),
order_date datetime,
tax money,
total_amount money);
------CREATION OF ORDERS TABLE-----

 

create table orders(
order_id int identity(1,1) primary key,
cust_id int foreign key references customers(cust_id),
order_date datetime,
total_amount_after_tax int,
);
-----CREATION OF ORDER-ITEM TABLE---
create table orderitems(
item_id int identity(701,1) primary key,
order_id int foreign key references orders(order_id),
cust_id int foreign key references customers(cust_id),
book_id int foreign key references books(book_id),
order_date datetime,
created_date datetime
);

 

-------------------------------------------------------------------------------------------------------------------
--insert values into author 
insert into author values(101,'valmiki','india',getdate()),(102,'justin','australia',getdate());
insert into author values(103,'Shiv Khera','india',getdate()),(104,'Kishimoto','Japan',getdate());
insert into author values(105,'Oda','Japan',getdate());
select*from author;
----procedures
--creating the admin procedure
create procedure admin_sign_up
(
	@email_id varchar(100),
	@name varchar(50),
	@phone_number bigint,
	@address text,
	@password varchar(20)
)
as insert into admins(email,name,phone_number,address,password,createdAt) values(@email_id,@name,@phone_number,@address,@password,getdate())

 

exec admin_sign_up 'raju@gmail.com','raju' ,1236547890,'Hitech city' ,'Raju@123'
exec admin_sign_up 'himansu@123','himansu' ,8985874922,'Hitech city' ,'himansu@123'

 

select * from admins
-----------------------------------------------------------------------------------------------------------------------------------------------
--creating the insert_into_books procedure				
create procedure insert_into_books(

	@book_id int,
	@title varchar(100),
	@category varchar(100),
	@price money,
	@author_id int,
	@quantity int,
	@imglink text

 

 

)
as

 

	begin
		if(select count(*) from books where book_id = @book_id) = 1
		begin
			update inventory set stock_level_used+=@quantity where book_id=@book_id
			print 'Book already exists and we updated your inventory' 
		end
		else
			begin
				insert into books(book_id,booktitle,category,book_price,auth_id,created_date,imglink) values(@book_id ,@title,@category,@price,@author_id,getdate(),@imglink)
				insert into inventory(Book_id,stock_level_used,stock_level_new,createdat) values(@book_id,0,@quantity,getdate())
			end
	end



 

select * from inventory
select * from books
exec  insert_into_books  201,'The ramayana','epic',1500,101,20,'https://rukminim2.flixcart.com/image/850/1000/kj1r53k0-0/regionalbooks/x/8/0/ramayana-story-book-for-kids-original-imafypden2hzn7ng.jpeg?q=90';
exec  insert_into_books  202,'mahabarata','epic',1200,102,50,'https://th.bing.com/th?id=OPA.%2bPPhgZvUAMqNpg474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  203,'The secrect','thriller',1100,103,50,'https://th.bing.com/th?id=OPA.3%2fy5VTRUqaPMgg474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  204,'Zootopia','animated',1700,103,20,'https://th.bing.com/th?id=OPA.iWuRoK36MC1Eqw474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  205,'Dhasavatar','epic',1000,103,60,'https://th.bing.com/th?id=OPA.xAI34jV7SCw5pQ474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  206,'cata combo','Horror',1350,103,70,'https://th.bing.com/th?id=OPA.5SJfGnN3Y6PYfw474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  207,'Tennali raman stories','Comic',1500,103,20,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3d1WVfUyebbPEXaR7O-QVH8qfXV-kTTfdLw&usqp=CAU';
exec  insert_into_books  208,'Simpsons','animated',1500,103,100,'https://th.bing.com/th?id=OPA.gvw1LCuskyGalQ474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  209,'Mommin','comic',1300,103,120,'https://th.bing.com/th?id=OPA.0xJxh7YZOnpX%2fQ474C474&w=220&h=210&o=5&pid=21.1';
exec  insert_into_books  210,'Spiderman-venom','animated',2000,103,120,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuxqRWygFZASf5wopTOTr0XxI5TOkL0_J0vA&usqp=CAU';

 

exec  insert_into_books  212,'Black forest','Horror',1400,103,20;
exec  insert_into_books  206,'Zootopia','animated',1500,103,20;

 

 

 

insert into books values(201,'ramayana','epic',1500,951478521,101,getdate());
insert into books values(202,'naruto','Manga',500,452222211,104,getdate());
insert into books values(203,'You can win','Motivation',1500,8564676412,103,getdate());
insert into books values(204,'One piece','Manga',500,6488764764,105,getdate());
insert into books values(205,'Rap','Motivation',1500,9654761764,102,getdate());
insert into books values(206,'abc','kjgfn',1500,4846654784,102,getdate());
insert into books values(210,'Life of pie','Motivation',1500,654765417654,102,getdate());
------------------------------------------------------------------------------------
--procedure1
create procedure view_books_by_title( 
@book_title varchar(100)
)
as begin

 

select * from books where booktitle=@book_title

 

end
exec view_books_by_title @book_title='The ramayana'

 

--procedure 2

 

create procedure view_books_by_Author @auth_id int
as begin
select * from books where auth_id=@auth_id
end

 

exec view_books_by_Author @auth_id=101
--procedure 3

 

create procedure view_books_by_category @book_category varchar(100)
as begin
select * from books where category=@book_category

 

end
exec view_books_by_category @book_category='epic'
----Procedure for customers signup-----
create PROCEDURE customer_signup (

 

  @cust_name varchar(100),
  @cust_mobile numeric(10,0),
  @emailId varchar(100),
  @postal_code int,
  @state varchar(100),
  @password varchar(100),
  @createdAt date
  )
as begin

 

    insert into customers

 

  values(
  @cust_name ,
  @cust_mobile,
  @emailId,
  @postal_code,
  @state,
  @password,
  GETDATE()
  )
end
exec customer_signup 'ajay',6301457891,'ajay@gmail.com',535002,'telangana','@123','2023-09-05';
exec customer_signup 'Vijay',8974537363,'Vijay@gmail.com',500083,'Karnataka','@234','2023-09-05';
exec customer_signup 'Sanjay',9345637218,'Sanjay@gmail.com',534728,'Mumbai','@345','2023-09-05';
exec customer_signup 'Bhargav',6389372837,'Bhargav@gmail.com',535056,'Karnataka','@456','2023-09-05';
exec customer_signup 'Ravi',7894927483,'Ravi@gmail.com',535742,'Tamilnadu','@567','2023-09-05';
exec customer_signup 'Rajesh',9865614763,'Rajesh@gmail.com',538981,'Kerala','@678','2023-09-05';
--creating procedure for bucket

 

alter PROCEDURE insertintobucket(
    @book_id INT,
    @cust_id INT,
    @quantity int
)
as begin
declare @price money
select @price=book_price from books where book_id=@book_id
select * from bucket where cust_id=@cust_id
insert into bucket(book_id,cust_id,price,quantity) values (@book_id, @cust_id,@price,@quantity);

end
exec insertintobucket @book_id=201,@cust_id=501,@quantity=20;
exec insertintobucket @book_id=205,@cust_id=502,@quantity=20
exec insertintobucket @book_id=201,@cust_id=503,@quantity=20
exec insertintobucket @book_id=202,@cust_id=504,@quantity=20

 

 

select * from inventory

 

------------procedure for bucket to payment-------------
alter procedure makepayment(@cust_id int)
as begin
declare @total_amount money,@stock_level_used int,@Book_id int
select @total_amount = sum(price)from bucket where cust_id=@cust_id
declare @total_amount_after_tax money
set @total_amount_after_tax=(@total_amount)*0.05 + @total_amount;
if(@total_amount is not null)
insert into payment(cust_id,total_amount,order_date,tax) values(@cust_id,@total_amount_after_tax,GETDATE(),@total_amount*0.05);

end
exec makepayment @cust_id =501

 

--creating trigger to insert into orders
ALTER TRIGGER paymenttrigger ON dbo.payment
FOR INSERT
AS
BEGIN
    DECLARE @cust_id INT, @order_date DATE, @total_amount_after_tax MONEY, @quantity INT, @book_id INT

    SELECT @cust_id = cust_id FROM bucket
    SELECT @order_date = order_date FROM inserted
    SELECT @total_amount_after_tax = total_amount FROM inserted
    SELECT @quantity = quantity FROM bucket WHERE cust_id = @cust_id
    SELECT @book_id = book_id FROM bucket WHERE cust_id = @cust_id

    -- Check if stock_level_new is greater than 0
    IF (SELECT stock_level_new FROM inventory WHERE book_id = @book_id) > 0
    BEGIN
        INSERT INTO orders (cust_id, order_date, total_amount_after_tax)
        VALUES (@cust_id, GETDATE(), @total_amount_after_tax)

        DECLARE @order_id INT
        SELECT @order_id = order_id FROM orders

        INSERT INTO orderitems (created_date, order_id, cust_id, book_id, order_date)
        VALUES (GETDATE(), @order_id, @cust_id, @book_id, GETDATE())

        -- Update inventory
        UPDATE inventory SET stock_level_new -= @quantity WHERE book_id = @book_id
        UPDATE inventory SET stock_level_used += @quantity WHERE book_id = @book_id

        DELETE FROM bucket WHERE cust_id = @cust_id
    END
END

--procedure for customer order history
alter procedure Customerorderhistory(@cust_id int)
as begin
    select o.order_id, o.order_date, p.total_amount,c.cust_id
    from Orders o
     join Payment p on o.cust_id = p.cust_id join customers c on c.cust_id=p.cust_id
    order by o.order_id;
end;


 

exec Customerorderhistory 501
--reading data from tables

 

select * from books
select * from customers
select * from payment
select * from inventory
select * from orders
select * from orderitems
select * from bucket
select * from Author
SELECT * FROM CUSTOMERS
select * from admins
 

select * from books

 

 

exec sp_rename 'dbo.admins.email_id','email';

 

 

update books set imglink='https://th.bing.com/th?id=OIP.KyE8kFf9BoQA7NqeNgcXjwHaJu&w=218&h=286&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2' where book_id=211;

 

 

select * from books

 

exec insertintobucket @book_id=201,@cust_id=501,@quantity=20;

 

select * from bucket where cust_id = 501

select * from bucket


create procedure increasequantity(@bucketid int)
as 
begin
     declare @Quantity int=0;

	 set @Quantity=(select quantity from bucket where bucket_id=@bucketid); 

	 update bucket set quantity=@Quantity+1 where bucket_id=@bucketid;

end


create procedure decreasequantity(@bucketid int)
as 
begin
     declare @Quantity int=0;

	 set @Quantity=(select quantity from bucket where bucket_id=@bucketid); 

	 update bucket set quantity=@Quantity-1 where bucket_id=@bucketid;

end

exec increasequantity 1069;

exec decreasequantity 1069;


delete from books where book_id=201;

select * from inventory
select * from orderitems

update Inventory set stock_level_new=100 where inventory_id=315;