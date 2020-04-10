<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/host.css" rel="stylesheet">
<style></style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${conPath }/js/address.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<section>
	<div id="joinWrap">
		<form action="${conPath }/hostJoin.do" method="post">
			<table>
				<tr>
					<td colspan="2" class="title">
						호스트 회원가입
					</td>			
				</tr>
				<tr>
					<td class="content">
						<p>아이디</p>
						<input type="text" name="hId" placeholder="아이디를 입력하세요">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p>비밀번호</p>
						<input type="password" name="hPw" placeholder="비밀번호를 입력하세요">
					</td>
				</tr>
				<tr>
					<td class="hPwhChk">
						<input type="password" name="hPwChk" id="hPwChk" placeholder="비밀번호를 확인해주세요">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p>이름</p>
						<input type="text" name="hName" placeholder="예시) 공유">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p>핸드폰 번호</p>
						<input type="text" name="hPhone" placeholder="예시) 010-1234-5678">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p>이메일</p>
						<input type="text" name="hEmail" placeholder="예시) example@example.com">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p class="postSearch" >
							우편번호
						</p>
						<input onclick="sample4_execDaumPostcode()" type="text" id="sample4_postcode" name="hPost" placeholder="우편번호(클릭!)">
					</td>
				</tr>
				<tr>
					<td class="content">
						<p>주소</p>
						<input type="text" id="sample4_roadAddress" name="hAddress" placeholder="도로명주소">
						<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소">
						<span id="guide"></span>
					</td>
				</tr>
				<tr>
					<td class="btn">
						<input type="submit" value="가입하기">
					</td>
				</tr>
				<tr><td class="span"></td></tr>
				<tr>
					<td class="span">
						<span>
							SNS 계정으로 가입하기
						</span>
					</td>
				</tr>
				<tr>
					<td class="btn">
						<input type="button" value="네이버로 가입하기"
							onclick="">
					</td>
				</tr>
				<tr>
					<td class="btn">
						<input type="button" value="카카오로 가입하기"
							onclick="">
					</td>
				</tr>
				<tr>
					<td class="btn">
						<input type="button" value="구글로 가입하기"
							onclick="">
					</td>
				</tr>
			</table>
		</form>
	</div>
</section>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>