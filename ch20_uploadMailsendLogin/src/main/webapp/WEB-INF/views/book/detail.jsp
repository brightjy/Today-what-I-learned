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
<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<table>
		<caption>${book.bNum }번 책 상세보기</caption>
		<tr>
			<th>
				책 이름
			</th>
			<td>
				${book.bTitle }
			</td>
		</tr>
		<tr>
			<th>
				책 이미지
			</th>
			<td>
				<img src="${conPath }/upload/${book.bImg1}">
				<img src="${conPath }/upload/${book.bImg2}">
			</td>
		</tr>
		<tr>
			<th>
				책 정보
			</th>
			<td>
				${book.bInfo }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/book.do?method=list&pageNum=${param.pageNum }'">목록으로</button>
				<button onclick="location.href='${conPath }/book.do?method=modifyForm&bNum=${book.bNum}&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath }/book.do?method=delete&bNum=${book.bNum}'">삭제</button>
			</td>
		</tr>
	</table>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>