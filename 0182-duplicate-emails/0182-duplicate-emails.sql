# Write your MySQL query statement below
# select Email from Person Group by Email Having Count(*) > 1 ;
SELECT email FROM Person GROUP BY email HAVING COUNT(EMAIL)>1;