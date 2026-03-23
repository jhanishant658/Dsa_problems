SELECT 
    request_at AS Day, 
    ROUND(
        SUM(CASE WHEN status != 'completed' THEN 1 ELSE 0 END) * 1.0 / COUNT(*), 
        2
    ) AS "Cancellation Rate"
FROM Trips 
WHERE client_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes' AND users_id IS NOT NULL)
  AND driver_id NOT IN (SELECT users_id FROM Users WHERE banned = 'Yes' AND users_id IS NOT NULL)
  AND request_at >= '2013-10-01' AND request_at <= '2013-10-03' -- Quotes added
GROUP BY request_at;