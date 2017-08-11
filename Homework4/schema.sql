
 create table FoodItem (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    foodName VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);
INSERT INTO FoodItem (id, foodName, description, price)VALUES 
(1, 'Cheeseburger', 'Patty beef letuce tomato cheese', 7.89),(2, 'Chilifries', 'chili,cheese,french fries', 9.99),
(3, 'Avocado Burger', 'beef,cheese,avocado,patty,letuce', 8.99);



CREATE TABLE orders (
	order_id INTEGER AUTO_INCREMENT PRIMARY KEY,
	customer_name VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL
);

INSERT INTO orders (order_id, customer_name, status) VALUES
(1, 'APOSTOLOS', 'IN PROGRESS'),
(2, 'DIMITRI', 'IN QUEUE');

