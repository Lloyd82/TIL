[010  TCL(TRANSACTION CONTROL LANGUAGE)

1. 트랜잭션 개요
- 트랜잭션은 데이터베이스의 논리적 연산단위다.
- 트랜잭션(TRANSACTION)이란 밀접히 관련돼 분리될 수 없는 한 개 이상의 데이터베이스 조작을 가리킨다.
- 하나의 트랜잭션에는 하나 이상의 SQL 문장이 포함된다.
- 트랜잭션은 분할할 수 없는 최소의 단위이다. 그러므로 전부 적용하거나
  전부 취소한다.
- 은행에서의 계좌이체 상황을 연상하면 트랜잭션을 이해하는데 도움이 된다.
- 계좌이체는 최소한 두 가지 이상의 작업으로 이루어져 있다. 

■ 계좌이체 사례
STEP1. 100번 계좌의 잔액에서 10,000원을 뺀다.  
STEP2. 200번 계좌의 잔액에 10,000원을 더한다.

- 계좌이체라는 작업 단위는 이런 두 개의 업데이트가 모두 성공적으로
  완료되었을 때 종료된다.
- 둘 중 하나라도 실패할 경우 계좌이체는 원래의 금액을 유지하고 있어야만 한다.
- 만약 어떠한 장애에 의해 어느 쪽이든 한 쪽만 실행했을 경우, 이체금액은 어디로
  증발해 버렸거나 마음대로 증가하게 된다.
- 이런 경우 수정을 취소하여 원 상태로 되돌려야 한다. 
- 계좌이체와 같은 하나의 논리적인 작업 단위를 구성하는 세부적인 연산들의
  집합을 트랜잭션이라 한다.

■ 트랜잭션을 제어 명령어 TCL(TRANSACTION CONTROL LANGUAGE) 

|

 1) 커밋(COMMIT) : 올바르게 반영된 데이터를 데이터베이스에 반영시키는 것을 말한다.
 2) 롤백(ROLLBACK) : 트랜잭션 시작 이전의 상태로 되돌리는 것이다.
 3) 저장점(SAVEPOINT) : 트랜잭션의 일부만 취소할 수 있게 만드는 명령어이다.  


- 트랜잭션의 대상은 UPDATE, INSERT, DELETE 등 데이터를 변경하는 DML 문이다.

■ 트랜잭션의 특성

|  특성  |                             설명                             |
| :----: | :----------------------------------------------------------: |
| 원자성 | 트렌잭션에서 정의된 연산들은 모두 성공적으로 실행되던지 아니면 전혀 실행되지 않은 상태로 남아  있어야 한다 (all or nothing) |
|        |                                                              |
|        |                                                              |
|        |                                                              |






- 이체가 결정되기 전까지는 다른 사람이 이 계좌의 정보를 변경할 수 없다.
  이것을 잠금(LOCKING)이라고 표현한다.
- 잠금은 기본적으로 트랜잭션이 수행하는 동안 특정 데이터에 대해서 다른 트랜잭션이
  동시에 접근하지 못하도록 제한하는 기법이다.
- 잠금이 걸린 데이터는 잠금을 실행한 트랜잭션만 독점적으로 접근할 수 있고
  다른 트랜잭션으로부터 간섭이나 방해를 받지 않는 것이 보장된다.
- 잠금이 걸린 데이터는 잠금을 수행한 트랜잭션만이 해제할 수 있다.


2.  COMMIT
- 입력,수정,삭제한 자료에 대해 전혀 문제가 없다고 판단됐을 경우
  COMMIT 명령어를 통해서 트랜잭션을 완료할 수 있다.

■ COMMIT이나 ROLLBACK 이전의 데이터 상태는 다음과 같다.  
 - 데이터의 변경을 취소해 이전 상태로 복구 가능하다.
 - 현재 사용자는 SELECT 문장으로 결과를 확인 가능하다.
 - 다른 사용자는 현재 사용자가 수행한 명령의 결과를 볼 수 없다.
 - 변경된 행은 잠금(LOCKING)이 설정되어서 다른 사용자가 변경할 수 없다.

[예제] PLAYER 테이블에 데이터를 입력하고 COMMIT을 실행한다. 
   - SQLDEVELOPER의 환경설정에서 AUTOCOMMIT설정을 취소하고 실습한다.   

  INSERT
       INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
    VALUES ('1997035', 'K02', '이운재', 'GK', 182, 82, 1);

  COMMIT;  

  SELECT * FROM PLAYER;


[예제] PLAYER 테이블에 있는 데이터를 수정하고 COMMIT을 실행한다.

 UPDATE PLAYER SET HEIGHT = 100;
 COMMIT; 

 SELECT * FROM PLAYER;

[예제] PLAYER 테이블에 있는 데이터를 삭제하고 COMMIT을 실행한다.

DELETE FROM PLAYER;

COMMIT; 

SELECT * FROM PLAYER;

  

※ COMMIT 이후의 데이터 상태는 다음과 같다.
  - 데이터에 대한 변경 사항이 데이터베이스에 반영된다.
  - 이전 데이터는 영원히 잃어버리게 된다.
  - 모든 사용자는 결과를 볼 수 있다.
  - 관련된 행에 대한 잠금(LOCKING)이 풀리고, 다른 사용자들이 행을
    조작할 수 있게 된다.



3. ROLLBACK

- 테이블 내 입력한 데이터나, 수정한 데이터, 삭제한 데이터에 대하여
  COMMIT 이전에는 변경 사항을 취소할 수 있는데 데이터베이스에서는
  롤백(ROLLBACK) 기능을 사용한다.
- 롤백(ROLLBACK)은 데이터 변경 사항이 취소돼 데이터가 이전 상태로 복구되며,
  관련된 행에 대한 잠금(LOCKING)이 풀리고 다른 사용자들이 데이터 변경을
  할 수 있게 된다.


[예제]PLAYER 테이블에 데이터를 입력하고 ROLLBACK을 실행한다.

 INSERT
      INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
   VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1);

ROLLBACK; 

 SELECT * FROM PLAYER WHERE PLAYER_ID = '1999035';


[예제] PLAYER 테이블에 있는 데이터를 수정하고 ROLLBACK을 실행한다.

UPDATE PLAYER SET HEIGHT = 200;
ROLLBACK; 

SELECT HEIGHT  FROM PLAYER;


[예제] PLAYER 테이블에 있는 데이터를 삭제하고 ROLLBACK을 실행한다.

 

DELETE FROM PLAYER;

ROLLBACK; 

SELECT COUNT(*) FROM PLAYER;

■ COMMIT , ROLLBACK사용으로 다음과 같은 효과를 볼 수 있다.
- 데이터 무결성 보장
- 영구적인 변경을 하기 전에 데이터의 변경 사항 확인 가능
- 논리적으로 연관된 작업을 그룹핑해 처리 가능


4. SAVEPOINT

- 저장점(SAVEPOINT)을 정의하면 롤백(ROLLBACK)할 때 트랜잭션에 포함된
  전체 작업을 롤백하는 것이 아니라 현 시점에서 SAVEPOINT까지 트랜잭션의
  일부만 롤백할 수 있다.
- 복잡한 대규모 트랜잭션에서 에러가 발생했을 때 SAVEPOINT까지의 트랜잭션만
  롤백하고 실패한 부분에 대해서만 다시 실행할 수 있다.
- 복수의 저장점을 정의할 수 있으며, 동일이름으로 저장점을 정의했을 때는
  나중에 정의한 저장점이 유효하다.

- 다음의 SQL문은 SVPT1이라는 저장점을 정의하고 있다.
SAVEPOINT SVPT1;

- 저장점까지 롤백할 때는 ROLLBACK 뒤에 저장점 명을 지정한다.
ROLLBACK TO SVPT1;

- 위와 같이 롤백(ROLLBACK)에 SAVEPOINT 명을 부여하여 실행하면 저장점
  설정 이후에 있었던 데이터 변경에 대해서만 원래 데이터 상태로 되돌아간다.


[예제]SAVEPOINT를 지정하고, PLAYER 테이블에 데이터를 입력한 다음 롤백(ROLLBACK)을
       이전에 설정한 저장점까지 실행한다.


DELETE FROM PLAYER
 WHERE PLAYER_NAME = '이운재';

SAVEPOINT SVPT1;

INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID, POSITION, HEIGHT, WEIGHT, BACK_NO) 
VALUES 
('1999035', '이운재', 'K02', 'GF', 182, 82, 1);

ROLLBACK TO SVPT1;

SELECT * FROM PLAYER
WHERE PLAYER_NAME='이운재';

[예제] 먼저 SAVEPOINT를 지정하고 PLAYER테이블에 있는 데이터를 수정한 다음 롤백을
         이전에 설정한 저장점까지 실행한다.
 - HEIGHT값을 확인하고 예제를 실행한다.

SELECT HEIGHT FROM PLAYER; 

SAVEPOINT SVPT2; -- 저장점이 생성되었다.

UPDATE PLAYER SET HEIGHT = 200;

SELECT HEIGHT  FROM PLAYER;

ROLLBACK TO SVPT2; --롤백이 완료되었다.

SELECT HEIGHT  FROM PLAYER;


[예제] SAVEPOINT를 지정하고, PLAYER 테이블에 있는 데이터를 삭제한 다음
        롤백(ROLLBACK)을 이전에 설정한 저장점까지 실행한다.

SAVEPOINT SVPT3; --저장점이 생성되었다.

DELETE FROM PLAYER;

SELECT * FROM PLAYER;

ROLLBACK TO SVPT3; --롤백이 완료되었다.

ROLLBACK; -- DELETE에 대한 저장점 롤백이 안될수 있다.

SELECT * FROM PLAYER;



※ 여러개의 SAVEPOINT 설정 후 ROLLBACK 이루어지는 범위에 대해 표현



[예제] 새로운 트랜잭션을 시작하고 SAVEPOINT A와 SAVEPONT B를 지정한다.
 - 미리 이운재 데이터가 있는지 확인하고, WEIGHT 값도 확인한다.

SELECT * FROM PLAYER
WHERE PLAYER_NAME='이운재';

DELETE FROM PLAYER
WHERE PLAYER_NAME ='이운재';

SELECT WEIGHT FROM PLAYER;


-------------------------------------------------------------------------------------

INSERT INTO PLAYER (PLAYER_ID, TEAM_ID, PLAYER_NAME, POSITION, HEIGHT, WEIGHT, BACK_NO)
VALUES ('1999035', 'K02', '이운재', 'GK', 182, 82, 1); --1개의 행이 만들어졌다.

SAVEPOINT SVPT_A;-- 저장점이 생성되었다.

UPDATE PLAYER SET WEIGHT = 100;

SAVEPOINT SVPT_B; -- 저장점이 생성되었다

DELETE FROM PLAYER;

[예제] CASE1. SAVEPOINT B 저장점까지 롤백(ROLLBACK)을 수행하고 롤백 전후
       데이터를 확인해본다.

SELECT COUNT(*) FROM PLAYER;

ROLLBACK TO SVPT_B;

SELECT COUNT(*) FROM PLAYER; 



[예제] CASE2. SAVEPOINT A 저장점까지 롤백(ROLLBACK)을 수행하고
        롤백 전후 데이터를 확인해본다.

SELECT COUNT(*) FROM PLAYER WHERE WEIGHT = 100;

ROLLBACK TO SVPT_A;

SELECT COUNT(*) FROM PLAYER WHERE WEIGHT = 100; 


[예제] CASE3. 트랜잭션 최초 시점까지 롤백(ROLLBACK)을 수행하고
        롤백 전후 데이터를 확인해본다.

SELECT COUNT(*) FROM PLAYER;

ROLLBACK;

SELECT COUNT(*) FROM PLAYER; 