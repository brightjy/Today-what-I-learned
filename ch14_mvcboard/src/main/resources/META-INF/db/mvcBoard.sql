DROP TABLE MVC_BOARD CASCADE CONSTRAINTS;
DROP SEQUENCE MVC_BOARD_SEQ;
CREATE SEQUENCE MVC_BOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;

CREATE TABLE MVC_BOARD(
    bID NUMBER(6) PRIMARY KEY,
    bNAME VARCHAR2(50) NOT NULL,
    bTITLE VARCHAR2(100) NOT NULL,
    bCONTENT VARCHAR2(1000), -- EDITOR 쓸 거면 CLOB로 해야함
    bDATE DATE DEFAULT SYSDATE NOT NULL,
    bHIT NUMBER(6) DEFAULT 0 NOT NULL,
    bGROUP NUMBER(6) NOT NULL,
    bSTEP NUMBER(3) NOT NULL,
    bINDENT NUMBER(3) NOT NULL,
    bIP VARCHAR2(20) NOT NULL
);

-- 글 목록(startRow, endRow)
SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, bSTEP;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY bGROUP DESC, bSTEP)A)
    WHERE RN BETWEEN 2 AND 5;
-- 전체 글 개수
SELECT COUNT(*) TOTCNT FROM MVC_BOARD;
-- 원글 쓰기 
INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'PARK', 'TITLE', 'CONTENT', MVC_BOARD_SEQ.CURRVAL, 0, 0, '192.168.20.23');
-- 상세 글 보기(bID로 dto 호출)
SELECT * FROM MVC_BOARD WHERE BID=1;
-- 조회수 올리기
UPDATE MVC_BOARD SET bHIT = bHIT+1 WHERE bID=1;
-- 답변글 쓰기 
---- 1) stepA
UPDATE MVC_BOARD SET bSTEP = bSTEP+1 WHERE bGROUP = 1 AND bSTEP>0;
---- 2) 답변글 쓰기
INSERT INTO MVC_BOARD (bID, bNAME, bTITLE, bCONTENT, bGROUP, bSTEP, bINDENT, bIP)
    VALUES (MVC_BOARD_SEQ.NEXTVAL, 'REPLYER', '1ST REPLY', 'CONTENT', 1, 1, 1, '121.1.1.1');
-- 글 수정
UPDATE MVC_BOARD
    SET bNAME = 'KIM',
        bTITLE = '수정 후',
        bCONTENT = '수정 후',
        bIP = '111.1.1.1',
        bDATE = SYSDATE
        WHERE bID = 1;
-- 글 삭제
DELETE FROM MVC_BOARD WHERE bID=1;

COMMIT;

