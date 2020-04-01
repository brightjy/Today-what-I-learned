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
</head>
<body>
	<h2>업로드 결과 : ${fileResult }</h2>
	<p>
		파일1: ${fileNames[0] }
	</p>
	<p>
		파일2: ${fileNames[1] }
	</p>
	<p>
		파일3: ${fileNames[2] }
	</p>
	<img src="${conPath }/upload/${fileNames[0] }">
	<img src="${conPath }/upload/${fileNames[1] }">
	<img src="${conPath }/upload/${fileNames[2] }">
</body>
</html>