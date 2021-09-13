### DML(DATA MANIPULATION LANGUAGE)

1. INSERT

(1) 단일 행 INSERT문

\- 단일 행 INSERT문은 VALUES절을 포함하며, 한 번에 한 건만 입력된다.



 INSERT INTO 테이블명 [(컬럼1, 칼럼2, .......)] VALUES (값1, 값2, ....)
  

\- 칼럼명과 VALUES 절의 값을 서로 1:1로 매핑해 기술한다.
\- PRIMARY KEY 제약 또는 NOT NULL 제약이 지정된 칼럼은 NULL값 입력울 허용하지 않으므로 오류가 발생한다.
\- 해당 칼럼의 데이터유형이 CHAR, VARCHAR 일 경우 '' 함께 값을 입력한다.

[예제] 선수 테이블에 박지성 선수의 데이터를 일부 칼럼만 입력한다.

INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION,
               HEIGHT, WEIGHT, BACK_NO)
VALUES
('2002007', '박지성', 'K07', 'MF', 178, 73, 7);


SELECT *
FROM PLAYER
WHERE PLAYER_NAME='박지성';

\- INTO 절의 칼럼명은 생략 할 수 있다. INTO절 칼럼명을 지정하지 않는 경우, 테이블에  정의된 칼럼순서 대로 VLUES 절에 모든값을 빠짐없이 기술해야 한다.
\- INTO 절의 칼럼명을 지정하는 편이 쿼리의 안정성 측면에서 바람직하다.

[예제] 해당 테이블에 이청용 선수의 데이터를 입력한다.

INSERT INTO PLAYER
VALUES
('2002010','이청용','K07','','BlueDragon','2002','MF',17,NULL, NULL,'1',180,69); 


SELECT * 
FROM PLAYER
WHERE PLAYER_NAME='이청용'; 


[예제] 홍길동 선수를 INSERT하려고 할때 PLAYER_ID값은 기존값에 + 1을 더한 값으로 넣고자 한다. 다음과 같이 VALUES절에 서브쿼리를 사용해 SQL을 작성할 수 있다.


 INSERT
    INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
  VALUES ((SELECT TO_CHAR(MAX(TO_NUMBER(PLAYER_ID)) + 1)
         FROM PLAYER), '홍길동', 'K06');



(2) 서브쿼리를 이용한 다중 행 INSERT
\- INSERT 문에 서브쿼리 사용하면 서브쿼리의 결과를 테이블에 입력할 수 있다.
\- 서브쿼리의 결과가 다중행이면 한 번에 여러 건이 입력된다.
\- INTO 절의 칼럼명 개수와 서브쿼리의 SELECT 절 칼럼 개수가 일치해야 한다.

[예제] 서브쿼리를 사용해 TEAM 테이블에 데이터 입력하기



INSERT 

   INTO TEAM (TEAM_ID, REGION_NAME, TEAM_NAME, ORIG_YYYY, STADIUM_ID)

 SELECT REPLACE(TEAM_ID, 'K','A') AS TEAM_ID,

​       REGION_NAME, REGION_NAME || ' 올스타' AS TEAM_NAME,

​       2019 AS ORIG_YYYY, STADIUM_ID

  FROM TEAM

 WHERE REGION_NAME IN ('성남','인천');



[예제] 서브쿼리를 사용해 PLAYER 테이블에 데이터 입력하기



 INSERT 

   INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION)

 SELECT 'A' || SUBSTR(PLAYER_ID, 2) AS PLAYER_ID , PLAYER_NAME,

​       REPLACE(TEAM_ID, 'K', 'A') AS TEAM_ID, POSITION

  FROM PLAYER

 WHERE TEAM_ID IN ('K04','K08');

\- 결과 확인하기

SELECT *

FROM TEAM 

-- WHERE TEAM_ID LIKE 'A%';

WHERE REGION_NAME IN ('성남','인천');

 



2. UPDATE


 UPDATE 다음에 수정되어야 할 칼럼이 존재하는 테이블명을 입력하고 SET 다음에
 수정되어야 할 칼럼명과 해당 칼럼에 수정되는 값으로 수정이 이루어진다.



 **UPDATE 테이블명
 SET 수정할 칼럼명1 = 수정될 새로운 값1
[ ,  수정할 칼럼명2 = 수정될 새로운 값2]
[ ,  ............                   ]
 [WHERE 수정 대상 식별 조건식 ];**

[예제] 선수 테이블의 백넘버를 일괄적으로 99로 수정한다.
 \- 모든 행이 수정된다.

 UPDATE PLAYER
    SET BACK_NO = 99;  

 

[예제] 선수 테이블의 포지션이 NULL인 선수들의 포지션을 ‘MF’로 수정한다.
\- 원하는 레코드만 수정할 경우에는 WHERE 절을 사용한다.

 UPDATE PLAYER
    SET POSITION = 'MF' 
 WHERE POSITION IS NULL;

■ UPDATE 문의 SET 절에 서브쿼리 사용하기
\- 서브쿼리의 결과로 값이 수정된다.
\- 서브쿼리의 결과가 NULL을 반환할 경우 수정해야 할 칼럼의 값이 NULL이
   될 수 있기 때문에 주의한다.

[예제] 팀 테이블에서 창단년도가 2000년 이후인 팀의 주소를 홈팀 경기장의
    주소로 수정한다.

 UPDATE TEAM A

​    SET A.ADDRESS = ( SELECT X.ADDRESS

​                 						 FROM STADIUM X

​                						 WHERE X.HOMETEAM_ID = A.TEAM_ID)            

 WHERE A.ORIG_YYYY > 2000;




[예제] 모든 경기장의 지역번호와 전화번호를 홈팀의 지역번호와 전화번호로 수정한다.
 

 UPDATE STADIUM A

  SET (A.DDD, A.TEL) = (SELECT X.DDD, X.TEL

​                 FROM TEAM X

​                WHERE X.TEAM_ID = A.HOMETEAM_ID);

■ UPDATE 문의 WHERE 절에 서브쿼리 사용하기
\- 수정될 행을 식별함으로써 불필요한 수정을 방지한다.

[예제] 홈팀의 정보가 존재하는 경기장의 지역번호와 전화번호를 홈팀의 지역번호와  전화번호로 수정한다.



 UPDATE STADIUM A

​    SET (A.DDD, A.TEL) = (SELECT X.DDD, X.TEL

​                   FROM TEAM X

​                   WHERE X.TEAM_ID = A.HOMETEAM_ID)

 WHERE EXISTS (SELECT 1

​             FROM TEAM X

​            WHERE X.TEAM_ID = A.HOMETEAM_ID) ;

\- 앞의 UPDATE문 TEAM 테이블을 2번 조회하는 비효율이 있다.
 MERGE문을 사용하면 TEAM 테이블을 1번 조회하여 데이터를 수정할 수 있다.



MERGE

  INTO STADIUM T

 USING TEAM S

   ON (T.HOMETEAM_ID = S.TEAM_ID )

 WHEN MATCHED THEN

   UPDATE

​      SET T.DDD = S.DDD,

​         T.TEL = S.TEL;




\3. DELETE 
 
\- 테이블의 정보가 필요 없게 되었을 경우 데이터 삭제를 수행한다.
\- DELETE FROM 테이블명을 입력하고 실행한다.
\- WHERE 절을 사용하지 않는다면 테이블의 전체 데이터가 삭제된다.



 **DELETE [FROM] 테이블명
 [WHERE 삭제 대상 식별 조건식];**


[예제]선수 테이블의 데이터를 전부 삭제한다.
 \- 모든 행이 삭제된다.

 DELETE FROM PLAYER; 

[예제]선수 테이블에서 포지션이 'DF'이고, 입단년도가 2010년 이전인 선수의
    데이터를 삭제 한다.

 DELETE PLAYER

 WHERE POSITION = 'DF'

   AND JOIN_YYYY < 2010;

 
■DELETE 문의 WHERE 절에 서브쿼리를 사용
\- 다른 테이블을 참조해 삭제할 행을 식별할 수 있다.

[예제] 선수 테이블에서 창단년도가 1980년 이전인 팀에 소속된 선수의 데이터를
    삭제한다.

 DELETE PLAYER A
 WHERE EXISTS (SELECT 1
             FROM TEAM X
            WHERE X.TEAM_ID = A.TEAM_ID
              AND X.ORIG_YYYY < 1980);


[예제] 선수 테이블에서 소속 선수가 10명 이하인 팀에 소속된 선수의 데이터를
    삭제한다.

 DELETE PLAYER 
 WHERE TEAM_ID IN (SELECT TEAM_ID
                FROM PLAYER
             GROUP BY TEAM_ID
               HAVING COUNT(*) <= 10);  



\4. MERGE
\- 새로운 행을 입력하거나, 기존 행을 수정하는 작업을 한 번에 할 수 있다.
\- MERGE 다음에 입력/수정돼야 할 타겟 테이블을 입력하고, 
 USING 절에 입력/수정에 사용할 소스 테이블을 입력한다.
 ON 절에는 타겟 테이블과 소스테이블간의 조인 조건식을 기술해, 입력/수정할
    대상을 결정한다.
\- ON 절의 조인 조건에 따라 조인에 성공한 행들에 대해서는 WHEN MATHCED THEN 아래 UPDATE구문을 수행하고, 조인에 실패한 행들에 대해 WHEN NOT MATHCED THEN 아래 INSERT구문을 수행한다.

  MERGE
   INTO 타겟 테이블명 
  USING 소스 테이블명

​    ON (조인 조건식)
  WHEN MATCHED THEN
​    UPDATE
​       SET 수정할 칼럼명1 = 수정될 새로운 값1
​      [ ,   수정할 칼럼명2 = 수정될 새로운 값2, ....]
  WHEN NOT MATCHED THEN
​     INSERT [(칼럼1, 칼럼2, .....)]
​     VALUES (값1, 값2, .....,)
   ;

[예제]MERGE 문을 자세히 설명하기 위해 TEAM_TMP 테이블을 임시로 만든다.
NVL2 함수는 null이 아닌경우 지정값1을 출력하고, null인 경우 지정값2을 출력 한다.
\- 함수 : **NVL2(**"값", "지정값1", "지정값2"**)**

CREATE TABLE TEAM_TMP AS

SELECT NVL(B.TEAM_ID, 'K' ||

​      ROW_NUMBER() OVER (ORDER BY B.TEAM_ID, A.STADIUM_ID)) AS TEAM_ID

​    , SUBSTR(A.STADIUM_NAME, 1, 2) AS REGION_NAME

​    , SUBSTR(A.STADIUM_NAME, 1, 2) || NVL2(B.TEAM_NAME, 'FC', '시티즌') AS TEAM_NAME

​    , A.STADIUM_ID, A.DDD, A.TEL

 FROM STADIUM A, TEAM B

 WHERE B.STADIUM_ID(+) = A.STADIUM_ID;

 

 SELECT * FROM TEAM_TMP;



[예제]TEAM_TMP 테이블을 이용해 TEAM 테이블에 데이터를 입력/수정한다.

 MERGE 
  INTO TEAM T

 USING TEAM_TMP S

   ON (T.TEAM_ID = S.TEAM_ID)

 WHEN MATCHED THEN

  UPDATE

​    SET T.REGION_NAME = S.REGION_NAME

​    ,  T.TEAM_NAME = S.TEAM_NAME

​    ,  T.DDD = S.DDD

​    ,  T.TEL = S.TEL

 WHEN NOT MATCHED THEN

  INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)

  VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);
 


[예제]서브쿼리를 이용해 TEAM테이블에 데이터를 입력/수정한다.
\- MERGE 문 USING절에 서브쿼리 사용

MERGE 
  INTO TEAM T

 USING (SELECT * FROM TEAM_TMP WHERE REGION_NAME IN ('성남','부산','대구','전주')) S

   ON (T.TEAM_ID = S.TEAM_ID)

 WHEN MATCHED THEN

  UPDATE

​    SET T.REGION_NAME = S.REGION_NAME

​    ,  T.TEAM_NAME = S.TEAM_NAME

​    ,  T.DDD = S.DDD

​    ,  T.TEL = S.TEL

 WHEN NOT MATCHED THEN

  INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)

  VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);
 

[예제]TEAM_TMP 테이블을 이용해 TEAM 테이블의 기존 데이터를 수정한다.

MERGE 
  INTO TEAM T

 USING TEAM_TMP S

   ON (T.TEAM_ID = S.TEAM_ID)

 WHEN MATCHED THEN

  UPDATE

​    SET T.REGION_NAME = S.REGION_NAME

​    ,  T.TEAM_NAME = S.TEAM_NAME

​    ,  T.DDD = S.DDD

​    ,  T.TEL = S.TEL ;
 

[예제]TEAM_TMP 테이블을 이용해 TEAM 테이블에 없는 데이터를 입력한다.

MERGE 
  INTO TEAM T

 USING TEAM_TMP S

   ON (T.TEAM_ID = S.TEAM_ID)

 WHEN NOT MATCHED THEN

  INSERT (T.TEAM_ID, T.REGION_NAME, T.TEAM_NAME, T.STADIUM_ID, T.DDD, T.TEL)

  VALUES (S.TEAM_ID, S.REGION_NAME, S.TEAM_NAME, S.STADIUM_ID, S.DDD, S.TEL);

 

■ DDL과 DML 처리 방식
\- DDL(CREATE, ALTER, RENAME, DROP) 명령어의 경우,데이터 구조 변경이 
  DDL 명령어 수행이 완료됨과 동시에 즉시 반영된다.

\- DML(INSERT, UPDATE, DELETE, SELECT) 명령어 사용 시 데이터 변경 사항을 테이블에 영구적으로 저장하기 위해서는 COMMIT 명령어를 수행해 TRANSACTION을 종료해야 한다

