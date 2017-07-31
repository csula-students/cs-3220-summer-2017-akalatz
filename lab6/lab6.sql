use food;
 create table  FoodItem (
     ID int AUTO_INCREMENT PRIMARY KEY,
     FoodName varchar(255),
     Description varchar(255),
     Price float
    
 );
 insert into FoodItem(ID, FoodName, Description,Price)
VALUES (1, 'Hamburger', 'A Hamburger', 9.99 ),
(2, 'Fries', 'Some Fries', 4.99 ),
(3, 'Coke', 'Coke Cola', 2.99 );


select * FROM FoodItem;