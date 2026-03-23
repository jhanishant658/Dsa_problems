# Write your MySQL query statement below
 Select score ,
 Dense_Rank() over (order by score Desc) as "rank" from Scores ; 