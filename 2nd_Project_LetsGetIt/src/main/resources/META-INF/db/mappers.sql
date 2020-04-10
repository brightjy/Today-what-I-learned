----------------------------------------
---              멤버 관련            ---
SELECT*FROM MEMBER;
----------------------------------------
-- 회원가입 id : memberJoin

-- 로그인 id : memberLogin

-- 비밀번호 찾기 id : memberSearchPw

-- 비밀번호 랜덤변경 id : memberRandomPw

-- 정보 수정 id : memberModify

-- 회원 리스트 id : memberList

----------------------------------------
---              호스트 관련           ---
SELECT*FROM HOST;
SELECT*FROM LIKE_HOST;
----------------------------------------

-- 호스트 좋아하기 id : memberLikeHost
INSERT INTO LIKE_HOST (lhID, mID, hID) VALUES (LIKE_HOST_SEQ.NEXTVAL, 'test', 'test');
UPDATE HOST SET 
    hCNTLIKE=1+1 -- 원래개수+1 
    WHERE hID='test';

-- (멤버별) 호스트 좋아요 리스트 id : memberLikeHostList
SELECT H.* FROM LIKE_HOST LH, HOST H WHERE LH.hID=H.hID AND mID='test'; -- 기준
SELECT*FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT hName, hPhone, hEmail FROM LIKE_HOST LH, HOST H WHERE LH.hID=H.hID AND mID='test')A) 
        WHERE RN BETWEEN 1 AND 3;

-- 나를 좋아한 멤버 id : hostLikedMemberList
SELECT M.* FROM LIKE_HOST LH, MEMBER M WHERE LH.mID=M.mID AND hID='test'; -- 기준
SELECT*FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT mName, mPhone, mEmail FROM LIKE_HOST LH, MEMBER M WHERE LH.mID=M.mID AND hID='test')A) 
        WHERE RN BETWEEN 1 AND 3;

-- 아이디 중복체크 id = idConfirm
SELECT COUNT(*) FROM HOST WHERE hID='test1';

-- 회원가입 id : hostJoin
INSERT INTO HOST (hID, hPW, hNAME, hPHONE, hEMAIL, hBANK, hPOST, hADDRESS)
    VALUES ('test1', 'test', 'test', '010-1111-1111', 'test@test.com', '2001-346-644316 우리', '02215', '서울시');
 
-- 로그인 id : getHost
SELECT*FROM HOST WHERE hID='test';

-- 정보수정 id : hostModify
UPDATE HOST SET
    hPW='modify',
    hNAME='modify',
    hPHONE='010-3333-3333',
    hEMAIL='modify@modify.com',
    hBANK='3333-333-333333 국민',
    hIMG='modify.jpg',
    hPOST='33333',
    hADDRESS='수정수정'
    WHERE hID='test';

-- (관리자가 보려구 함+검색도 하게 할 것임) 호스트 리스트 id : hostList
SELECT*FROM HOST WHERE hNAME LIKE '%'||'t'||'%' OR hID LIKE '%'||'t'||'%' ORDER BY hRDATE DESC; -- 기준
SELECT*FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT*FROM HOST WHERE hNAME LIKE '%'||'t'||'%' OR hID LIKE '%'||'t'||'%' ORDER BY hRDATE DESC)A) 
        WHERE RN BETWEEN 1 AND 3; -- 페이징

-- 좋아요가 높은 순으로 정렬한 호스트 리스트 id : hostBestList
SELECT*FROM HOST ORDER BY hCNTLIKE DESC; -- 기준
SELECT*FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT*FROM HOST ORDER BY hCNTLIKE DESC)A) 
        WHERE RN BETWEEN 1 AND 3;

-- 호스트 마이페이지 id : hostMain

commit;

----------------------------------------
---              액티비티 관련          ---
----------------------------------------
-- 기획전 리스트 id : activityPlanList

-- 카테고리 리스트 id : activityCategoriList

-- 액티비티 좋아요 리스트 id : activityLikeList

-- 액티비티 생성 id : activityWrite

-- 내가만든 액티비티 리스트 id : hostActivityList

----------------------------------------
---              후기 관련             ---
----------------------------------------
-- 후기 리스트 id : reviewList

-- 후기 작성 id : reviewWrite

-- 후기 수정 id : reviewModfy

-- 후기 삭제 id : reviewDelete

-- 후기 도움 클릭 id : reviewLike

----------------------------------------
---              공지 관련             ---
----------------------------------------
-- 전체 리스트 id : noticeAllList

-- 공지 리스트 id : noticeList

-- 이벤트 리스트 id : eventList

-- 발표 리스트 id : AnnouncementList

-- 공지 작성 : noticeWrite

-- 공지 수정 : noticeModify

-- 공지 삭제 : noticeDelete

----------------------------------------
---              Q&A 관련(관리자)      ---
----------------------------------------
-- Q&A 리스트 id : adminQnaList

-- Q&A 상세보기 id : adminQnaDetail

-- Q&A 작성 id : adminQnaWrite

-- Q&A 수정 id : adminQnaModify

-- Q&A 삭제 id : adminQnaDelete

----------------------------------------
---              Q&A 관련(호스트)      ---
----------------------------------------
-- Q&A 리스트 id : QnaList

-- Q&A 상세보기 id : QnaDetail

-- Q&A 작성 id : QnaWrite

-- Q&A 수정 id : QnaModify

-- Q&A 삭제 id : QnaDelete

----------------------------------------
---              쿠폰 관련             ---
----------------------------------------
-- 전체 쿠폰 리스트 id : couponAllList

-- 쿠폰 지금 id : couponWrite

-- 사용가능 쿠폰 리스트(MEMBER) : couponList

----------------------------------------
---              관리자 관련           ---
----------------------------------------
-- 블랙리스트 처리