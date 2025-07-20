SELECT E.name, B.bonus
FROM Employee E
Left JOIN Bonus B
  ON E.empId = B.empId
WHERE B.bonus < 1000 or B.bonus is null;
