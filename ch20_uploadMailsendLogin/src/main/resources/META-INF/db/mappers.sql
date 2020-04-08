-- ★ Book.xml
-- 신규 순 list > id=mainList
SELECT*FROM BOOK ORDER BY bRDATE DESC;

-- 전체 도서 이름 순 paging list > id=bookList
SELECT*FROM BOOK ORDER BY bTITLE; -- 기준
SELECT*FROM BOOK WHERE bTITLE LIKE '%'||'S'||'%' OR bWRITER LIKE '%'||'S'||'%' ORDER BY bTITLE; -- 검색 기능이 더해진 기능
SELECT*FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT*FROM BOOK WHERE bTITLE LIKE '%'||'S'||'%' OR bWRITER LIKE '%'||'S'||'%' ORDER BY bTITLE)A) 
        WHERE RN BETWEEN 1 AND 3;

-- 전체 개수 > id=cntBook
SELECT COUNT(*) FROM BOOK;
-- 검색 시 전체 개수
SELECT COUNT(*) FROM BOOK WHERE bTITLE LIKE '%'||'s'||'%' OR bWRITER LIKE '%'||'s'||'%';
SELECT COUNT(*) FROM BOOK WHERE bTITLE LIKE '%'||'S'||'%' OR bWRITER LIKE '%'||'S'||'%';

-- 도서 상세보기(책 번호로 dto 가져오기) > id=getBook
SELECT*FROM BOOK WHERE bNUM=1;

-- 도서 등록 > id=registerBook
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO) VALUES 
    (BOOK_SQ.nextval, 'SPRING', '김스프', SYSDATE, 'sample1.jpg', 'sample2.png', '좋은 스프링 책'); -- 첨부를 둘다 하는 경우
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bINFO) VALUES 
    (BOOK_SQ.nextval, 'SPRING', '김스프', SYSDATE, 'sample1.jpg', '좋은 스프링 책'); -- 첨부를 첫 번째만 하는 경우
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO) VALUES 
    (BOOK_SQ.nextval, 'SPRING', '김스프', SYSDATE, 'sample2.jpg', '좋은 스프링 책'); -- 첨부를 두 번째만 하는 경우
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO) VALUES 
    (BOOK_SQ.nextval, 'SPRING', '김스프', SYSDATE, '좋은 스프링 책'); -- 첨부를 안 하는 경우

-- 도서 수정 > id=modifyBook
UPDATE BOOK SET
    bTITLE = '수정제목',
    bWRITER = '수정작가S',
    bRDATE = SYSDATE,
    bIMG1 = 'sample1.jpg',
    bIMG2 = 'sample2.jpg',
    bINFO = '수정내용'
    WHERE bNUM=1;
    
-- 도서 삭제 > id=deleteBook
DELETE BOOK WHERE bNUM=2;


-- ★ Member.xml
-- 아이디 중복체크(매개변수:id, 해당 id가 몇개인지?) > id=idConfirm
SELECT COUNT(*) FROM MEMBER WHERE mID='test1';

-- 회원가입 > id=joinMember
INSERT INTO MEMBER VALUES ('test1', 'test1', '테스트', 'test1@naver.com', '111-111', 'test address');

-- 아이디로 dto 가져오기(session에 담을용) > id=getMember
SELECT*FROM MEMBER WHERE mID='test';

-- 정보수정 > id=modifyMember
UPDATE MEMBER SET
    mPW = 'testtest',
    mNAME = '테스트테스트',
    mMAIL = 'testtest@naver.com',
    mPOST = '222-222',
    mADDR = '수정한주소'
    WHERE mID='test1';