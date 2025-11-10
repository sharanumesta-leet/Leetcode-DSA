# Write your MySQL query statement below
SELECT D.name AS Department, E.name AS Employee, E.salary AS Salary
FROM Employee E
JOIN Department D
ON E.departmentId = D.id
WHERE (D.name, E.salary) IN (
    SELECT D.name, MAX(E.salary)
    FROM Employee E
    JOIN Department D
    ON E.departmentId = D.id
    GROUP BY D.name
);