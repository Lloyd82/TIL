select job, ename, sal,
    rank() over (order by sal desc)all_rank,
    rank() over (partition by job order by sal desc)job_rank
from emp; 

SELECT JOB, ENAME, SAL,
       RANK() OVER (PARTITION BY JOB ORDER BY SAL DESC) JOB_RANK
  FROM EMP;

select job, ename, sal,
    rank() over (order by sal desc) as rk,
    dense_rank() over (order by sal desc) as dk
  from emp;    

--[예제] 같은 매니저를 두고 있는 사원들의 SALARY 합을 구한다.
-- PARTITION BY MGR 구문을 통해 매니저별로 데이터를 파티션화 한다.

select mgr, ename, sal, 
    sum(sal) over (partition by mgr)mgr_sum
  from emp;

SELECT MGR, ENAME, SAL,
    SUM(SAL) OVER (PARTITION BY MGR ORDER BY SAL
                   RANGE UNBOUNDED PRECEDING) AS MGR_SUM
  FROM EMP;

select mgr, ename, sal,
       max (sal) over (partition by mgr) as mgr_max
  from emp;

select mgr, ename, sal  
  from(select mgr, ename, sal,
       max (sal)over(partition by mgr) as max_sal
       from emp)
 where sal = max_sal;

--[예제] 파티션별 최대값을 가진 행만 추출할 때,  순위 함수를 사용해도 된다. 
select mgr, ename, sal
  from (SELECT MGR, ENAME, SAL, 
        RANK () OVER (PARTITION BY MGR ORDER BY SAL DESC) AS
        SAL_RK FROM EMP)
where sal_rk = 1;

-- MIN 함수를 이용해 파티션별 윈도우의 최소값을 구할 수 있다.
--[예제] 같은 매니저를 두고 있는 사원들을 입사일자를 기준 정렬,
--      SALARY 최소값을 같이 구한다.

SELECT MGR, ENAME, HIREDATE, SAL,
       MIN(SAL) OVER(PARTITION BY MGR) AS MGR_MIN
  FROM EMP;

--[예제] EMP 테이블에서 같은 매니저를 두고 있는 사원들의 평균 SALARY를
--      구하는데, 조건은 같은 매니저 내에서 자기 바로 앞의 사번과 바로 뒤의 
--      사번인 직원만을 대상으로 한다.

select mgr, ename, hiredate, sal,
    round(avg(sal) over(partition by mgr order by hiredate
                        rows between 1 preceding and 1 following)) as mgr_avg
from emp;

SELECT  ENAME, SAL,
    COUNT(*) OVER (ORDER BY SAL
                   RANGE BETWEEN 50 PRECEDING
                   AND 150 FOLLOWING) AS EMP_CNT
 FROM  EMP;

SELECT DEPTNO, ENAME, SAL,
          FIRST_VALUE(ENAME) 
		   OVER(PARTITION BY DEPTNO ORDER BY SAL DESC
			   ROWS UNBOUNDED PRECEDING) AS ENAME_FV
 FROM  EMP;

SELECT DEPTNO, ENAME, SAL,
          FIRST_VALUE(ENAME) 
		   OVER(PARTITION BY DEPTNO ORDER BY SAL DESC
			   ROWS UNBOUNDED PRECEDING) AS ENAME_FV
 FROM EMP;

SELECT DEPTNO, ENAME, SAL, 
          FIRST_VALUE(ENAME) 
          OVER (PARTITION BY DEPTNO ORDER BY SAL DESC , ENAME
                ROWS UNBOUNDED PRECEDING) AS ENAME_FV
 FROM EMP; 

select deptno, ename, sal,
    last_value(ename) over (partition by deptno order by sal desc
                            rows between current row and unbounded following)
                            as ename_lv
  from emp; 

select ename, hiredate, sal, 
       lag(sal) over (order by hiredate) as lag_sal
  from emp
 where job = 'SALESMAN';

SELECT ENAME, HIREDATE, SAL,
       LAG(SAL) OVER (ORDER BY HIREDATE)  AS LAG_SAL
  FROM EMP
 WHERE JOB = 'SALESMAN' ;

select ename, hiredate, sal,
   lag(sal, 2, 0) over (order by hiredate) as lag_sal
  from emp
 where job = 'SALESMAN';

SELECT ENAME, HIREDATE,
       LEAD(HIREDATE,1) OVER (ORDER BY HIREDATE)
       AS LEAD_HIREDATE
  FROM EMP
 WHERE JOB = 'SALESMAN'; 

SELECT DEPTNO, ENAME, SAL,
       PERCENT_RANK() 
	   OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS PR
  FROM EMP;

SELECT DEPTNO, ENAME, SAL,
       CUME_DIST() 
 	   OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS CD
  FROM EMP;

SELECT ENAME, SAL
  FROM EMP
WHERE ROWNUM < 4
ORDER BY SAL DESC;

SELECT ENAME, SAL
  FROM (select ename, sal from emp order by sal desc)
 WHERE ROWNUM < 4 ;

select empno, sal
  from emp
 order by sal, empno
 fetch first 5 rows only;

select empno, sal
  from emp
 order by sal, empno
offset 5 rows; 

SELECT W.EMPNO 사원번호, W.ENAME 사원명, M.ENAME 관리자명
  FROM EMP W, EMP M
 WHERE W.MGR = M.EMPNO; 

select b.empno, b.ename, b.mgr
  from emp a, emp b
 where a.ename = 'JONES'
   and b.mgr = a.empno;

SELECT C.EMPNO, C.ENAME, C.MGR
  FROM EMP A, EMP B, EMP C
 WHERE A.ENAME = 'JONES'
   AND B.MGR = A.EMPNO
   AND C.MGR = B.EMPNO;

SELECT B.EMPNO, B.ENAME, B.MGR   
  FROM EMP A, EMP B
 WHERE A.ENAME = 'SMITH'
   AND B.EMPNO = A.MGR;

SELECT  LEVEL AS LV, LPAD(' ', (LEVEL-1) * 2) ||
	    EMPNO AS EMPNO, MGR , CONNECT_BY_ISLEAF ISLEAF
  FROM  EMP
 START WITH MGR IS NULL
CONNECT BY PRIOR EMPNO = MGR;

SELECT LEVEL, LPAD(' ', 2 * (LEVEL-1)) || EMPNO AS EMPNO, MGR,
              CONNECT_BY_ISLEAF ISLEAF
  FROM EMP
START WITH EMPNO= '7876'
CONNECT BY EMPNO = PRIOR MGR;

SELECT CONNECT_BY_ROOT(EMPNO) AS ROOT_EMPNO,
       SYS_CONNECT_BY_PATH(EMPNO, ',') AS PATH,
       EMPNO ,  MGR 
  FROM EMP
 START WITH MGR IS NULL
CONNECT BY MGR = PRIOR EMPNO;

SELECT * 
  FROM (SELECT JOB, DEPTNO, SAL FROM EMP)
 PIVOT (SUM(SAL) FOR DEPTNO IN (10, 20, 30))
 ORDER BY 1;

SELECT * 
  FROM (SELECT  TO_CHAR(HIREDATE, 'YYYY') AS YYYY, JOB, DEPTNO,SAL FROM EMP)
 PIVOT (SUM(SAL) FOR DEPTNO IN (10, 20, 30))
 ORDER BY 1,2;

SELECT * 
   FROM (SELECT JOB, DEPTNO, SAL FROM EMP)
   PIVOT (SUM (SAL) AS SAL FOR DEPTNO IN 
	    (10 AS D10, 20 AS D20, 30 AS D30) )
ORDER BY 1;

SELECT JOB, D20_SAL
  FROM (SELECT JOB, DEPTNO, SAL FROM EMP)
 PIVOT (SUM(SAL)AS SAL FOR DEPTNO IN(10 AS D10,20 AS D20, 30 AS D30))
 WHERE D20_SAL > 2500
 ORDER BY 1; 

SELECT  * 
  FROM (SELECT JOB, DEPTNO, SAL FROM EMP)
 PIVOT ( SUM(SAL) AS SAL, COUNT(*) AS CNT
              FOR DEPTNO IN (10 AS D10, 20 AS D20))
 ORDER BY 1;

SELECT  *
   FROM (SELECT  TO_CHAR(HIREDATE, 'YYYY') AS YYYY, JOB, DEPTNO, SAL FROM  EMP)
  PIVOT (SUM(SAL) AS SAL, COUNT(*) AS CNT 
         FOR (DEPTNO, JOB) IN ((10,'ANALYST') AS D10A,
	    (10,'CLERK') AS D10C, (20, 'ANALYST') AS D20A,
	    (20,'CLERK') AS D20C))
ORDER BY  1;

SELECT JOB,
       SUM (CASE DEPTNO WHEN 10 THEN SAL END) AS D10_SAL ,
       SUM (CASE DEPTNO WHEN 20 THEN SAL END) AS D20_SAL ,
       SUM (CASE DEPTNO WHEN 30 THEN SAL END) AS D30_SAL 
  FROM EMP
 GROUP BY JOB
 ORDER BY JOB;

CREATE TABLE T1 AS
SELECT JOB, D10_SAL, D20_SAL, D10_CNT, D20_CNT
  FROM (SELECT JOB, DEPTNO, SAL FROM EMP WHERE JOB IN ('ANALYST','CLERK'))
 PIVOT (SUM(SAL) AS SAL, COUNT(*) AS CNT FOR DEPTNO IN (10 AS D10, 20 AS D20)); 

SELECT * FROM T1;

 SELECT JOB, DEPTNO, SAL
   FROM T1
UNPIVOT (SAL FOR DEPTNO IN (D10_SAL, D20_SAL))
  ORDER BY 1, 2;

 SELECT JOB, DEPTNO, SAL
   FROM T1
UNPIVOT (SAL FOR DEPTNO IN (D10_SAL AS 10, D20_SAL AS 20))
  ORDER BY 1,2;

 SELECT JOB, DEPTNO, SAL
   FROM T1
UNPIVOT INCLUDE NULLS (SAL FOR DEPTNO IN (D10_SAL AS 10, D20_SAL AS 20))
  ORDER BY 1, 2;

 SELECT  *
   FROM  T1
UNPIVOT ((SAL,CNT) FOR DEPTNO IN ((D10_SAL, D10_CNT)
        AS 10 , (D20_SAL, D20_CNT) AS 20))
  ORDER BY 1, 2;

 SELECT *
   FROM T1
UNPIVOT ((SAL,CNT)FOR (DEPTNO, DNAME) IN ((D10_SAL, D10_CNT) 
		AS (10 , 'ACCOUNTING'), (D20_SAL, D20_CNT)
        AS (20, 'RESEARCH' )))
  ORDER BY 1, 2;

SELECT  ENAME, SYS_CONNECT_BY_PATH(ENAME, ',') AS PT
  FROM EMP
START WITH MGR IS NULL
CONNECT BY MGR = PRIOR EMPNO;

SELECT REGEXP_COUNT('123123123123123', '123', 1) AS C1
  FROM DUAL;

SELECT  *
  FROM (SELECT TO_CHAR(HIREDATE, 'YYYY') AS YYYY, JOB, DEPTNO, SAL FROM EMP)
 PIVOT (SUM(SAL) FOR DEPTNO IN(10, 20, 30) COUNT JOB)
ORDER BY 1,2;

SELECT 

  FROM   



  





 