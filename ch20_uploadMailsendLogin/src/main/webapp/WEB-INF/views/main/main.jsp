<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 50px auto;
	}
	img{width: 100px;}
</style>
</head>
<body>
	<c:if test="${not empty modifyResult }">
		<script> alert("정보수정 성공");</script>
	</c:if>
	<c:if test="${not empty result }">
		<script> alert('${result}');</script>
	</c:if>
	<jsp:include page="header.jsp"/>
	<div id="content">
		<table>
			<caption>신규 도서 BEST 5</caption>
			<tr><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th></tr>
			<tr>
			<c:forEach var="book" items="${main }" begin="0" end="4">
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
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>