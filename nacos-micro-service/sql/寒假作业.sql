INSERT INTO user VALUES('2','李四','男',21,'2012-02-12',1);
UPDATE user SET age = 2 WHERE `name` = '李四';



SELECT u1.name as '姓名',u1.sex as '性别', u1.age as '年龄',r1.`name` as '工种' from 
`user` u1
LEFT JOIN userrole u2 on u1.id=u2.userId
LEFT JOIN role r1 on u2.roleId = r1.id
WHERE r1.`name` = '技术人员' AND u1.sex = '女'
-- ===================================================
SELECT u1.name as '姓名',u1.sex as '性别', u1.age as '年龄',r1.`name` as '工种' from 
`user` u1,userrole u2 ,role r1
WHERE 
u1.id = u2.userId AND u2.roleId = r1.idand
r1.`name` = '技术人员' AND u1.sex = '女'

-- =============================================================
DELETE u1 FROM user as u1
LEFT JOIN userrole u2 on u1.id=u2.userId
LEFT JOIN role r1 on u2.roleId = r1.id
where u1.`name`= '张三'
-- ================================================================

SELECT u1.name as '姓名',u1.sex as '性别', u1.age as '年龄',r1.`name` as '工种' from 
`user` u1
LEFT JOIN userrole u2 on u1.id=u2.userId
LEFT JOIN role r1 on u2.roleId = r1.id
WHERE u1.age BETWEEN 18 and 29 AND u1.sex = '男'

-- =========================================================================
SELECT 
res2.age as '年龄',SUM(res2.boys) as '男',SUM(res2.girls) as '女'
from
(SELECT
res1.age ,
case res1.sex
when '男' then res1.he 
when '女' then 0
end as boys,
case res1.sex  
when '女' then res1.he 
when '男' then 0
end as girls
from
(select res.sex,res.age,sum(res.num) as he
FROM
(SELECT u1.sex, u1.age , 1 as num from 
`user` u1) res
GROUP BY res.sex,res.age) res1
GROUP BY
res1.age,
case res1.sex
when '男' then res1.he end,
case res1.sex  
when '女' then res1.he end) res2
GROUP BY res2.age
-- =====================================================================

SELECT u1.name as '姓名',u1.sex as '性别', u1.age as '年龄' from 
`user` u1
where u1.name like '张%' and u1.sex='男'LIMIT 0,50

-- ============================================================================

SELECT
res1.age ,
SUM(case res1.sex
when '男' then res1.he 
when '女' then 0
end) as boys,
SUM(case res1.sex  
when '女' then res1.he 
when '男' then 0
end) as girls
from
(select res.sex,res.age,sum(res.num) as he
FROM
(SELECT u1.sex, u1.age , 1 as num from 
`user` u1) res
GROUP BY res.sex,res.age) res1
GROUP BY
res1.age
=======================================================



























