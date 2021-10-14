# [Maria DB] qurey

1. DB 내보내기
   mysqldump -u[계정] -p[비번] [db 이름] > [저장할 파일명]

2. DB 가져오기
   mysql -u[계정] -p <[임포트할 파일명]

3. 로그인하기
   mysql -u[계정] -p -h[호스트]

4. DB생성
   CREATE DATABASE [DB명]

5. DB 조작

   - [SELECT](https://mariadb.com/kb/en/select/) 는 데이터를 읽고(혹은 조회하고) 싶을 때 사용한다.
   - [INSERT](https://mariadb.com/kb/en/insert/) 는 데이터를 추가(혹은 삽입)하려할 때 사용한다.
   - [UPDATE](https://mariadb.com/kb/en/update/) 는 데이터를 변경(혹은 갱신)하려할 때 사용한다.
   - [DELETE](https://mariadb.com/kb/en/delete/) 는 존재하는 데이터를 제거(혹은 삭제)하려할 때 사용한다.
   - [REPLACE](https://mariadb.com/kb/en/replace/) 는 새로운 데이터를 추가하거나 존재하는 데이터를 변경(혹은 대체)하려할 때 사용한다.
   - [TRUNCATE](https://mariadb.com/kb/en/truncate-table/) 는 테이블 내 모든 데이터를 비우려(혹은 삭제하려)할 때 사용한다.

6. 

    

   ```
   CREATE DATABASE mydb; -- mydb 데이터베이스 생성
   USE mydb; -- 기본 데이터베이스로 mydb를 지정
   CREATE TABLE mytable ( id INT PRIMARY KEY, name VARCHAR(20) ); -- mytable 테이블 생성
   INSERT INTO mytable VALUES ( 1, 'Will' ); -- 데이터 입력
   INSERT INTO mytable VALUES ( 2, 'Marry' ); 
   INSERT INTO mytable VALUES ( 3, 'Dean' );
   SELECT id, name FROM mytable WHERE id = 1;
   UPDATE mytable SET name = 'Willy' WHERE id = 1;
   SELECT id, name FROM mytable;
   DELETE FROM mytable WHERE id = 1;
   SELECT id, name FROM mytable;
   DROP DATABASE mydb;
   SELECT count(1) from mytable; gives the number of records in the table
   ```

   - 

     --

     
     