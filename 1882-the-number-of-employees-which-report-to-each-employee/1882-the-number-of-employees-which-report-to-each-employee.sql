select e.employee_id ,e.name ,count(t.reports_to)
   as reports_count
     , Round(avg(t.age)) as average_age
     From Employees e 
      join 
       Employees t 
     on e.employee_id = t.reports_to 
    group by e.employee_id 
 order by e.employee_id asc ;
