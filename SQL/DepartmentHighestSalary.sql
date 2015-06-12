SELECT d.Name AS Department, e.Name AS Employee, t.Max_Salary AS Salary
FROM Department AS d, Employee AS e, (
  SELECT MAX(Salary) AS Max_Salary, DepartmentId FROM Employee
  GROUP BY DepartmentId) t
WHERE t.DepartmentId = e.DepartmentId AND e.DepartmentId = d.Id AND t.Max_Salary = e.Salary;