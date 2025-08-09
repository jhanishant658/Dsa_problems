# Write your MySQL query statement below
 select e.employee_id , e.department_id 
  from Employee e 
  join (
    select employee_id ,department_id ,primary_flag ,count(employee_id)as cnt
    from Employee 
    group by employee_id
  ) as t 
  on e.employee_id = t.employee_id and(t.cnt = 1 or e.primary_flag = 'Y')
  group by e.employee_id ; 