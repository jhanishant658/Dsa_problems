# Write your MySQL query statement below

    SELECT Max(m.num) as num 
FROM MyNumbers m
JOIN (
    SELECT num ,count(num) as cnt
    FROM MyNumbers
    GROUP BY num
    
) AS n ON m.num = n.num and n.cnt = 1 