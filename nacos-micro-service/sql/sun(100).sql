
SELECT MAX(S1.id_1) AS ID ,SUM(S1.num) AS 'NUM'
FROM
(SELECT s1.id as 'id_1' , s1.num as 'num',s2.id as 'id_2'
from sum_num s1
JOIN sum_num s2 on s1.id<=s2.id) S1
GROUP BY S1.id_2
