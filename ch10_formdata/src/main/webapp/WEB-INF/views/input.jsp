<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>ModelAttribute를 통해 cnt, list</h1>
	<h2>cnt : ${cnt }</h2>
	<h2>list : ${list }</h2>
	<hr>
	<%-- <form action="${conPath }/member/join01" method="post"> --%>
	<%-- <form action="${conPath }/member/join02" method="post"> --%>
	<%-- <form action="${conPath }/member/join03" method="post"> --%>
	<%-- <form action="${conPath }/member/join04" method="post"> --%>
	<%-- <form action="${conPath }/member/join05" method="post"> --%>
	<form action="${conPath }/member/join06" method="post">
		<table>
			<caption>개인정보 입력</caption>
			<tr>
				<th>
					이름
				</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<th>
					ID
				</th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>
					PW
				</th>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<th>
					나이
				</th>
				<td>
					<input type="number" name="age">
				</td>
			</tr>
			<tr>
				<th>
					메일
				</th>
				<td>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<th>
					주소
				</th>
				<td>
					<input type="text" name="address">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="${conPath }/studentId/aaa">
		studentId를 aaa로 전송
	</a>
</body>
</html>