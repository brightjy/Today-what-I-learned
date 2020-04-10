---------- MEMBER ----------------------
SELECT*FROM MEMBER;
INSERT INTO MEMBER VALUES('test1', 'test', 'test', 'test', 'test', 'test', 'test', SYSDATE, SYSDATE);
---------- HOST ----------------------
-- 회원가입 id : hostJoin
DROP SEQUENCE HOST_JOIN_SEQ;
CREATE SEQUENCE  HOST_JOIN_SEQ MAXVALUE 999 NOCACHE NOCYCLE;
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hIMG, hPOST, hADDRESS)
    VALUES ('test'||HOST_JOIN_SEQ.NEXTVAL, 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', 'sehoon.jpg', '02215', '서울시');
COMMIT;