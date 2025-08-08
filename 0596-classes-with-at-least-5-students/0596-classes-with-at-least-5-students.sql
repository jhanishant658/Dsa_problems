# Write your MySQL query statement below
select distinct s.class
  from Courses s
  join (
     select t.class ,count(t.student) as cnt
     from Courses t 
     group by t.class
  ) As all_course 
  on s.class =all_course.class and all_course.cnt>=5 ;