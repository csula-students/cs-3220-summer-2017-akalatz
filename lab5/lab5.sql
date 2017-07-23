#Lab5
#Kalatzis Apostolos CIN 305835379
 
 #Create restaurant food item table
 create table  FoodItem (
    ID int,
    FoodName varchar(255),
    Description varchar(255),
    Price float
    
);


#Create restaurant order statuses table

CREATE TABLE Orders (
    ID int,
    CustomerName varchar(255),
    Created datetime
);



#Create order foods table 

CREATE TABLE OrderFoods (
    OrderID int,
    FoodId int,
    Quantity int
    
);



#create shopping cart table 

CREATE TABLE Shopping_cart (
    ID int,
    CustomerName varchar(255),
    FoodID int,
    Quantity int
    
);


#insert values to food items
insert into FoodItem(ID, FoodName, Description,Price)
VALUES (1, 'Hamburger', 'A Hamburger', 9.99 ),
(2, 'Fries', 'Some Fries', 4.99 ),
(3, 'Coke', 'Coke Cola', 2.99 );

select * from FoodItem;
# insert values into order statuses
INSERT INTO Orders(ID, CustomerName, Created)
VALUES (1, 'Eric', now()),
(2, 'John', now()),
(3, 'Jane', now()),
(4, 'Alice', now());

select * from Orders;

# insert values into order foods
INSERT INTO OrderFoods(OrderID, FoodId, Quantity)
VALUES (1, 1, 1),
(1, 2, 2),
(2, 2,2),
(2,3,1),
(3, 3, 1),
(4, 2, 1),
(4, 3, 2);

select * from OrderFoods;

 #insert values into shopping cart
 INSERT INTO Shopping_cart(ID, CustomerName, FoodID,Quantity)
VALUES (1, 'Anonymous', 1, 2 ),
(1, 'Anonymous', 2, 1 ),
(1, 'Anonymous', 2, 1 ),
(2, 'Mike', 1, 1 ),
(2, 'Mike', 2, 1 ),
(3, 'Bob', 3, 1 );
 
select * from Shopping_cart;

# Update food item name from "Hamburger" to "Salad"
SET SQL_SAFE_UPDATES = 0;
update FoodItem set FoodName='salad' where FoodName='Hamburger';
select * from FoodItem;

# Update customer name from "Jane" to "Doe"
update Orders set CustomerName='Doe' where CustomerName='Jane';
select * from Orders;

# Find out which food item has the most orders
select  FoodItem.FoodName, 
count(OrderFoods.OrderID) as 'most ordered'
from OrderFoods
inner join FoodItem
on OrderFoods.FoodID=FoodItem.ID
group by FoodName
order by count(FoodID)  desc limit 2;

#Find out which food item in least shopping carts
select FoodItem.FoodName,
count(Shopping_cart.FoodID) as 'least in shopping cart'
from Shopping_cart
inner join FoodItem
on Shopping_cart.FoodID=FoodItem.ID
group by FoodName
order by count(FoodID) limit 1;

# Find out all restaurant food items using SELECT query
select * from FoodItem;

#Find out all restaurant order statuses using SELECT query
select * from Orders;

#Find out the order statuses that is created today
select * from Orders
where date(Created) = date(now());

# DELETE restaurant food items table
drop table FoodItem;

#Delete restaurant order statuses table
drop table Orders;

# Delete restaurant cart table
drop table Shopping_cart;