# Write your MySQL query statement below
Select T1.name, Bonus.bonus from (
SELECT empId ,name from Employee where empId not in(
SELECT Bonus.empId FROM Employee JOIN Bonus ON (Employee.empID = Bonus.empId and Bonus.bonus>=1000))) as T1
LEFT JOIN Bonus ON Bonus.empId= T1.empId;