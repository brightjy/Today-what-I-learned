-- BOOK
SELECT*FROM BOOK;
INSERT INTO BOOK VALUES (BOOK_SQ.nextval, 'SPRING', '김스프', SYSDATE, 'noImg.png', 'noImg.png', '좋은 스프링 책');

-- MEMBER
SELECT*FROM MEMBER;
INSERT INTO MEMBER VALUES ('test', 'test', '테스트', 'test@naver.com', '111-111', 'test address');

COMMIT;