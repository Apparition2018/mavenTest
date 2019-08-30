-- CURRENT_TIMESTAMP
SELECT CURRENT_TIMESTAMP -- 2018-12-10 15:13:46.023
GO


/********** SQL Server **********/
-- DATEADD
SELECT DATEADD(YEAR, 1, '2018-08-15')	-- 2019-08-15 00:00:00.000
SELECT DATEADD(yyyy, -1, '2018-08-15')	-- 2017-08-15 00:00:00.000
SELECT DATEADD(WEEK, 1, '2018-08-15')	-- 2018-08-22 00:00:00.000

-- DATEDIFF
SELECT DATEDIFF(MONTH, '2017-01-01', '2018-08-15')	-- 19
SELECT DATEDIFF(DAY, '2017-01-01', '2018-08-15')	-- 591
SELECT DATEDIFF(dd, '2017-12-31', '2018-08-15')		-- 227

-- DATENAME
SELECT DATENAME(QUARTER, CURRENT_TIMESTAMP) -- 4
SELECT DATENAME(SECOND, CURRENT_TIMESTAMP)	-- 44

-- DATEPART
SELECT DATEPART(QUARTER, CURRENT_TIMESTAMP) -- 4
SELECT DATEPART(SECOND, CURRENT_TIMESTAMP)	-- 44

-- DAY
SELECT DAY('2018-08-15')	-- 15

-- MONTH
SELECT MONTH('2018-08-15')	-- 8

-- YEAR
SELECT YEAR('2018-08-15')	-- 2018

-- GETDATE
SELECT GETDATE() -- 2018-12-10 15:21:13.880

-- ISDATE
SELECT ISDATE('2018-08-15') -- 1
SELECT ISDATE('2018-08-32') -- 0
GO


/********** Oracle **********/
/*
-- ADD_MONTHS
SELECT ADD_MONTHS(SYSDATE, 1)

-- EXTRACT
SELECT EXTRACT(YEAR FROM DATE '2018-08-15') -- 2018
SELECT EXTRACT(DAY FROM DATE '2018-08-15') -- 15

-- LAST_DAY，返回日期所在月的最后一天的日期
SELECT LAST_DAY('2018-08-15') - 2018-08-31

-- MONTHS_BETWEEN，返回两个日期相隔多少个月
SELECT MONTHS_BETWEEN (TO_DATE ('2003/07/01', 'yyyy/mm/dd'), TO_DATE ('2003/03/14', 'yyyy/mm/dd'))

-- NEXT_DAY
SELECT NEXT_DAY(SYSDATE, 5) -- 返回下周4的日期

-- SYSDATE
SELECT SYSDATE -- 2006-08-03 10:01:31

-- SYSTIMESTAMP
SELECT SYSTIMESTAMP -- 03-AUG-06 10.02.21.093000 AM +08:00
*/
GO


/********** MySQL **********/
/*
-- ADDDATE
SELECT ADDDATE('2018-08-15', 10)				-- 2018-08-25
SELECT ADDDATE('2018-08-15', INTERVAL -1 MONTH) -- 2018-07-15

-- DATEDIFF
SELECT DATEDIFF('2017-01-01', '2018-08-15')	-- 591
SELECT DATEDIFF('2017-12-31', '2018-08-15')	-- 227

-- DAY
SELECT DAY('2018-08-15')	-- 15

-- MONTH
SELECT MONTH('2018-08-15')	-- 8

-- YEAR
SELECT YEAR('2018-08-15')	-- 2018

-- EXTRACT
SELECT EXTRACT(YEAR FROM '2018-08-15') -- 2018
SELECT EXTRACT(DAY FROM '2018-08-15') -- 15

-- LAST_DAY，返回日期所在月的最后一天的日期
SELECT LAST_DAY('2018-08-15') - 2018-08-31

-- SYSDATE
SELECT SYSDATE() -- 2018-12-10 15:21:13.880

-- DATE_FORMAT

-- TO_DAYS
*/
GO