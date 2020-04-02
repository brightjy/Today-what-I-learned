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
<link href="${conPath}/css/emp.css" rel="stylesheet">
<style></style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
	<div id="wrap">
		<form action="${conPath }/emp.do">
			사원명 <input type="text" name="ename" value="${emp.ename }" size="3">
			직책 <input type="text" name="job" value="${emp.job }" size="3">
			부서번호 <select name="deptno">
				<option value="0">모든부서</option>
				<c:forEach items="${deptList }" var="dept">
					<option value="${dept.deptno }"
						<c:if test="${dept.deptno==emp.deptno }">selected="selected"</c:if>
					>${dept.dname }</option>
				</c:forEach>
			</select>
			<input type="submit" value="검색">
		</form>
	</div>
	<table>
		<tr>
			<th>
				사원번호
			</th>
			<th>
				이름
			</th>
			<th>
				직책
			</th>
			<th>
				MGR
			</th>
			<th>
				입사일
			</th>
			<th>
				급여
			</th>
			<th>
				상여
			</th>
			<th>
				부서번호
			</th>
		</tr>
		<c:forEach items="${empList }" var="emp">
			<tr>
				<td>
					${emp.empno }
				</td>
				<td>
					${emp.ename }
				</td>
				<td>
					${emp.job }
				</td>
				<td>
					${emp.mgr }
				</td>
				<td>
					${emp.hiredate }
				</td>
				<td>
					${emp.sal }
				</td>
				<td>
					${emp.comm }
				</td>
				<td>
					${emp.deptno }
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>