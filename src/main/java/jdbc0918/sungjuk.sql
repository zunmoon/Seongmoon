-- sungjuk.sql

※ 참조 d:\java202307\database\section0818\06_성적테이블.sql

-- sqlplus 사용자 추천
-- 오라클 콘솔창 예브게 출력
set linesize 1000;
col uname for a10; -- col 컬럼명 for 20자
col addr  for a10;

-- sungjuk 테이블 삭제
drop table sungjuk;

-- sungjuk 테이블 생성
CREATE TABLE SUNGJUK (
    SNO   INT         NOT NULL
  , UNAME VARCHAR(50) NOT NULL
  , KOR   INT         NOT NULL
  , ENG   INT         NOT NULL
  , MAT   INT         NOT NULL
  , TOT   INT
  , AVER  INT
  , ADDR  VARCHAR(20)
  , WDATE DATE
);

-- 전체 행 개수
SELECT COUNT(*) FROM SUNGJUK;

SELECT COUNT(*) AS CNT FROM SUNGJUK;