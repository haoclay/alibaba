 SET @a=CONCAT('select * from _table_country limit ',(4-1)*5,',',5,'');
 PREPARE texts FROM @a;
 EXECUTE texts; 