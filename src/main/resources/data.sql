DROP TABLE IF EXISTS cart;
 
CREATE TABLE cart (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price DECIMAL(20, 2) NOT NULL
);
 
INSERT INTO cart (name, price) VALUES
  ('IPhone 11 Pro', 999),
  ('MacBook Pro', 2799),
  ('Apple Watch Series 5', 399);