SELECT s.Name
FROM Employee AS s INNER JOIN Employee AS t
ON s.ManagerId = t.Id 
WHERE s.Salary > t.Salary;