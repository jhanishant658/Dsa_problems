# Write your MySQL query statement below
SELECT 
  s.query_name,
  ROUND(AVG(s.rating / s.position), 2) AS quality,
  ROUND(
    AVG(
      CASE 
        WHEN s.rating < 3 THEN 1.0 
        ELSE 0 
      END
    ) * 100, 2
  ) AS poor_query_percentage
FROM Queries s
GROUP BY s.query_name;
