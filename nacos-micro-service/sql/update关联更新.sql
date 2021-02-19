

select * from student where is_exist =1 ORDER BY teacher_id,id;
select * from temp ORDER BY teacher_id,id;

-- 关联表更新操作1
-- update test1 
-- set name=(select name from test2 where test2.id=test1.id) where test1.`name` is null || test1.`name`=''
-- age=(select age from test2 where test2.id=test1.id)
 
 
-- 关联表更新操作2
-- update student s ,temp t
-- set s.is_exist = 1
-- where t.name is not null and  s.`name`= t.`name`

 
-- 关联表更新操作3
 UPDATE test1 t1 
 left join test2 t2 on t1.id = t2.id
 set t1.age = t2.age
 
 
 
--  UPDATE test1 t1 ,test2 t2
--  set t1.age = t2.age
-- WHERE t1.`name` = t2.`name`;
 
 
 
 UPDATE test1 t1
 LEFT JOIN  test2 t2 on t1.name = t2.name
 set t1.age = t2.age;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 