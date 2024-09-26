# Write your MySQL query statement below
SELECT name AS Customers FROM Customers WHERE id NOT IN(SELECT Customers.id FROM Customers INNER JOIN Orders ON Customers.id = Orders.customerId);