# Write your MySQL query statement below
select 
    p.project_id , avg(e.experience_years) as average_years 
    from 
       Project p 
       join 
        Employee e
        on 
        p.employee_id = e.employee_id 
    group by 
p.project_id ;