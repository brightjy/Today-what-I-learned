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
		<form action="${conPath }/book.do?method=register" method="POST" enctype="multipart/form-data">
			<table>
				<caption>책 등록</caption>
				<tr>
					<th>
						책 제목
					</th>
					<td>
						<input type="text" name="bTitle" required="required">
					</td>
				</tr>
				<tr>
					<th>
						저자
					</th>
					<td>
						<input type="text" name="bWriter" required="required">
					</td>
				</tr>
				<tr>
					<th>
						책 이미지1
					</th>
					<td>
						<input type="file" name="file1" required="required">
					</td>
				</tr>
				<tr>
					<th>
						책 이미지2
					</th>
					<td>
						<input type="file" name="file2" required="required">
					</td>
				</tr>
				<tr>
					<th>
						책 정보
					</th>
					<td>
						<input type="text" name="bInfo">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="뒤로가기" onclick="history.back()">
						<input type="submit" value="책 등록">
					</td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>