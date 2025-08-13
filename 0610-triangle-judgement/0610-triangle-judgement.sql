-- a+b>c a+c>b b+c>a
select x ,y , z ,
 case 
    when x+y>z and x+z>y and y+z>x 
       then 'Yes'
       else 'No'
       end as triangle 
From Triangle ;