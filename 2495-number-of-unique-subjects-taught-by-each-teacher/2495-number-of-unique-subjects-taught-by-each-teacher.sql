Select 
    s.teacher_id , 
      count(distinct s.subject_id)
       as cnt 
    From 
Teacher s 
 Group by s.teacher_id;
      