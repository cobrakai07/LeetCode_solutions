SELECT  employee_id
FROM Employees 
WHERE manager_id IS NOT NULL AND salary < 30000  and manager_id not in (select employee_id from Employees)
ORDER BY employee_id asc;
