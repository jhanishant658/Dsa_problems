SELECT 
    s1.user_id, 
   Ifnull( Round( IFNULL(SUM(s2.action = 'confirmed'), 0) /
     COUNT(s2.action),2 ),0)AS confirmation_rate
FROM 
    Signups s1
LEFT JOIN 
    Confirmations s2 
    ON s1.user_id = s2.user_id
GROUP BY 
    s1.user_id;