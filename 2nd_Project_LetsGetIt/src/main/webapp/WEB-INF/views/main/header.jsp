<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/main.css" rel="stylesheet"/>
</head>
<body>
<header>
	<div id="top">
		<div class="left">
			<a href="${conPath }/main.do"><span>¡</span>Let's get it!</a>			
		</div>
		<div class="center">
			<form action="" class="form">
				<input type="text" name="searchTxt" placeholder="인기검색어 : 마카롱 만들기">
				<input type="submit" value="">
			</form>
		</div>
		<div class="right">
			<ul class="topMenu">
				<li>
					<c:if test="${empty member }">
						<a href="${conPath }/memberLogin.do">로그인</a>
					</c:if>
					<c:if test="${not empty member }">
						<a href="">${member.mName }님</a>
					</c:if>						
					<c:if test="${not empty member }">
						<ul class="dropDown">	
							<li>
								<a href="${conPath }/likeactivityList.do">내 좋아요</a>
							</li>
							<li>
								<a href="${conPath }/myActivityList.do">내 액티비티</a>
							</li>
							<li>
								<a href="${conPath }/myCouponList.do">쿠폰/마일리지</a>
							</li>
							<li>
								<a href="${conPath }/myReviewList.do">내 후기</a>
							</li>
							<li>
								<a href="${conPath }/memberModify.do">프로필수정</a>
							</li>
						</ul>
					</c:if>
				</li>
				<li>
					<a href="${conPath }/hostLoginForm.do">호스트 센터</a> <!-- 여기에 회원가입 버튼 만들 예정  -->
				</li>
				<li>
					<a href="${conPath }/noticeAllList.do">고객센터</a>
					<ul  class="dropDown">
						<li>
							<a href="${conPath }/noticeList.do">공지사항 </a>
						</li>
						<li>
							<a href="${conPath }/eventList.do">이벤트 </a>
						</li>
						<li>
							<a href="${conPath }/adminQnaList.do">QnA</a>
						</li>
					</ul>
				</li>
				<li>
					<c:if test="${not empty member }">
						<a href="${conPath }/memberLogout.do">로그아웃</a>
					</c:if>
				</li>
			</ul>
		</div>	
	</div>
</header>
</body>
</html>