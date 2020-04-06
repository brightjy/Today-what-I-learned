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
			<caption>전체 도서 보기(책 이름 순)</caption>
			<tr>
			<c:forEach var="book" items="${bookList }" begin="0" end="2">
				<td>
					${book.bTitle }<br>
					<a href="${conPath }/book.do?method=detail&bNum=${book.bNum}&pageNum=1">
					<img src="${conPath }/upload/${book.bImg1}"></a><br>
					${book.bWriter } 著 <br>
					출판일 : ${book.bRdate }
				</td>
			</c:forEach>
			</tr>
		</table>
		<div id="paging">
			<br>
			<br>
		<c:if test="${paging.startPage>paging.blockSize }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }"
			end="${paging.endPage }">
			<c:if test="${paging.currentPage==i }">
				[ <b> ${i }</b> ]
			</c:if>
			<c:if test="${paging.currentPage!=i }">
				[ <a href="${conPath }/book.do?method=list&pageNum=${i}"> ${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage<paging.pageCnt }">
			[ <a href="${conPath }/book.do?method=list&pageNum=${paging.endPage+1}">다음</a> ]
		</c:if>
		</div>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>