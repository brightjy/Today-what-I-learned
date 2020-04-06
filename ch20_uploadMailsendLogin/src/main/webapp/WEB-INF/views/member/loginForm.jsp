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
<link href="${conPath}/css/style.css" rel="stylesheet">
<style></style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<c:if test="${not empty result }">
	alert('${result }');
</c:if>
<jsp:include page="../main/header.jsp"/>
<div id="content">
<form action="${conPath }/member.do?method=login" method="post">
	<table>
		<caption>로그인</caption>
		<tr>
			<th>
				아이디
			</th>
			<td>
				<input type="text" name="mId" value="${mId }">
			</td>
		</tr>
		<tr>
			<th>
				비밀번호
			</th>
			<td>
				<input type="password" name="mPw">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>