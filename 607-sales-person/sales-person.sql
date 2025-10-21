# Write your MySQL query statement below
SELECT name
FROM SalesPerson
WHERE name NOT IN  (
    SELECT S.name
    FROM SalesPerson S
    JOIN Orders O ON O.sales_id = S.sales_id 
    JOIN Company C ON O.com_id = C.com_id
    WHERE C.name = "RED"
);