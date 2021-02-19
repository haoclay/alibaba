
SELECT S2.`大洲`,sum(S2.`男`) AS '男',sum(S2.`女`) AS '女'
From
(SELECT 
S.continent AS '大洲',
 CASE S.gender
      WHEN '男' then S.population
			end as '男',
CASE S.gender
      WHEN '女' then S.population
			end as '女'

FROM
(SELECT  
case t1.country
		WHEN  '中国' THEN '亚洲'
		WHEN  '日本' THEN '亚洲'
		WHEN  '韩国' THEN '亚洲'
		WHEN  '法国' THEN '欧洲'
		WHEN  '德国' THEN '欧洲'
		WHEN  '意大利' THEN '欧洲'
		WHEN  '肯尼亚' THEN '非洲'
		WHEN  '埃及' THEN '非洲'
		WHEN  '美国' THEN '北美洲'
		WHEN  '加拿大' THEN '北美洲'
		WHEN  '墨西哥' THEN '北美洲'
		WHEN  '巴西' THEN '南美洲'
		WHEN  '阿根廷' THEN '南美洲'
		WHEN  '委内瑞拉' THEN '南美洲'
		WHEN  '澳大利亚' THEN '大洋洲'
		WHEN  '新西兰' THEN '大洋洲'
		else '其他' 
		end as 'continent',

case t1.gender
		when '1'  THEN '男'
		when '2'  THEN '女'
		END as gender,

sum(t1.population) as population

from _table_country t1

GROUP BY 
	case t1.country
		WHEN  '中国' THEN '亚洲'
		WHEN  '日本' THEN '亚洲'
		WHEN  '韩国' THEN '亚洲'
		WHEN  '法国' THEN '欧洲'
		WHEN  '德国' THEN '欧洲'
		WHEN  '意大利' THEN '欧洲'
		WHEN  '肯尼亚' THEN '非洲'
		WHEN  '埃及' THEN '非洲'
		WHEN  '美国' THEN '北美洲'
		WHEN  '加拿大' THEN '北美洲'
		WHEN  '墨西哥' THEN '北美洲'
		WHEN  '巴西' THEN '南美洲'
		WHEN  '阿根廷' THEN '南美洲'
		WHEN  '委内瑞拉' THEN '南美洲'
		WHEN  '澳大利亚' THEN '大洋洲'
		WHEN  '新西兰' THEN '大洋洲'
		else '其他' 
		end,

case t1.gender
		when '1'  THEN '男'
		when '2'  THEN '女'
		END ) S
GROUP BY
    CASE S.gender
      WHEN '男' then S.population
			end ,
CASE S.gender
      WHEN '女' then S.population
			end ) S2
			GROUP BY S2.`大洲`


		


