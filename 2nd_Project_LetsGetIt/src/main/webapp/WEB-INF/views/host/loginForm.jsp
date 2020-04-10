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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<section>
	<div id="loginFormWrap">
		<div class="loginForm">
			<div class="box">
				<form action="${conPath }/hostLogin.do" method="post">
					<table>
						<tr>
							<td colspan="2" class="title">
								호스트 로그인
							</td>			
						</tr>
						<tr>
							<td class="content">
								<input type="text" name="hId" placeholder="아이디" value="${host.hId }">
							</td>
						</tr>
						<tr>
							<td class="content">
								<input type="password" name="hId" placeholder="비밀번호">
							</td>
						</tr>
						<tr>
							<td class="btn">
								<input type="submit" value="로그인하기">
							</td>
						</tr>
						<tr>
							<td class="span">
								<span>
									<a href="${conPath }/hostjoinForm.do">
										회원가입
									</a>
								</span>
								&nbsp; &nbsp;|&nbsp; &nbsp;
								<span>
									<a href="${conPath }/hostSearchPw.do">
										비밀번호 재설정
									</a>
								</span>
							</td>
						</tr>
						<tr><td class="span"></td></tr>
						<tr>
							<td class="span">
								<span>
									SNS 계정으로 로그인하기
								</span>
							</td>
						</tr>
						<tr>
							<td class="btn">
								<input type="button" value="네이버로 로그인하기"
									onclick="">
							</td>
						</tr>
						<tr>
							<td class="btn">
								<input type="button" value="카카오로 로그인하기"
									onclick="">
							</td>
						</tr>
						<tr>
							<td class="btn">
								<input type="button" value="페이스북으로 로그인하기"
									onclick="">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>