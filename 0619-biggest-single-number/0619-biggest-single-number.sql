# Write your MySQL query statement below
select Max(p.num) as num from MyNumbers p 
join(
    SELECT m.num
FROM MyNumbers m
JOIN (
    SELECT num ,count(num) as cnt
    FROM MyNumbers
    GROUP BY num
    
) AS n ON m.num = n.num and n.cnt = 1 ) as t 
  on p.num = t.num ; 
