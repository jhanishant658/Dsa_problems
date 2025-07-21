SELECT 
  DATE_FORMAT(s.trans_date, '%Y-%m') AS month,
  s.country AS country, 
  COUNT(s.state) AS trans_count,
  COUNT(CASE WHEN s.state = 'approved' THEN 1 END) AS approved_count,
  SUM(s.amount) AS trans_total_amount,
  ifnull(SUM(CASE WHEN s.state = 'approved' THEN s.amount END) ,0)AS approved_total_amount
FROM Transactions s
GROUP BY month, s.country;

