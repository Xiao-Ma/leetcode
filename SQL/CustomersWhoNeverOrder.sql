#solution1
SELECT c.Name
FROM Customers AS c
WHERE c.Id NOT IN (SELECT CustomerId FROM Orders);

#solution2
SELECT c.Name
FROM Customers AS c LEFT JOIN Orders AS o
ON c.Id = o.CustomerId 
WHERE o.CustomerId IS NULL;

#solution3
SELECT c.Name
FROM Customers AS c
WHERE (SELECT COUNT(*) FROM Orders WHERE c.Id = Orders.CustomerId) = 0;