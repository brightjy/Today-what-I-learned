<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${conPath }/input.do" method="get">
		<p> 
			이름 : <input type="text" name="name" value="${student.name }">
		</p>
		<p>
			나이 : <input type="number" name="age" placeholder="나이는 자연수"
					value='<c:if test="${student.age!=0 }">${student.age}</c:if>'>
		</p>
		<input type="submit">
	</form>
	<h4>${nameError }</h4>
	<h4>${ageError }</h4>
</body>
</html>