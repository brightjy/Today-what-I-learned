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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
 $(document).ready(function(){
	 $("form").submit(function(){
		 if($("#name").val().length<1){
			 alert("이름은 반드시 한 글자 이상 입력해주세요.");
			 return false;
		 }else if($(".score").val()<1 || $(".score").val()>100){
			 alert("점수는 1점 이상, 100점 이하로 입력해주세요.");
			 return false;
		 }
	 });
 });
</script>
</head>
<body>
<form action="${conPath }/input.do" method="get">
	<table>
		<tr>
			<td colspan="2">
				<h3>"${cnt }"</h3>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="colspan">
				개인 정보 입력
			</td>
		</tr>
		<tr>
			<th>
				이름 : 
			</th>
			<td>
				<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<th>
				국어 : 
			</th>
			<td>
				<input type="number" name="kor" class="score">
			</td>
		</tr>
		<tr>
			<th>
				영어 : 
			</th>
			<td>
				<input type="number" name="eng" class="score">
			</td>
		</tr>
		<tr>
			<th>
				수학 : 
			</th>
			<td>
				<input type="number" name="mat" class="score">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="colspan">
				<input type="submit" value="입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>