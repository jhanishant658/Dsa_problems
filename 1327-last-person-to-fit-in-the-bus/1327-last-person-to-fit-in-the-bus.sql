select p.person_name 
 from Queue p 
 join 
   (SELECT 
    person_id,
    person_name,
    weight,
    turn,
    SUM(weight) OVER (ORDER BY turn) AS total
FROM Queue
ORDER BY turn
) as q
on 
   p.person_id = q.person_id and q.total<=1000
   order by p.turn desc 
   Limit 1 ; 