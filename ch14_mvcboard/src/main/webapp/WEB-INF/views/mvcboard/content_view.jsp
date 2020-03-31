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
</head>
<body>
	<table>
		<caption>
			${content_view.bId }번 글 상세보기
		</caption>
		<tr>
			<th>
				글 번호
			</th>
			<td>
				${content_view.bId }
			</td>
		</tr>
		<tr>
			<th>
				제목
			</th>
			<td>
				${content_view.bTitle }
			</td>
		</tr>
		<tr>
			<th>
				작성자
			</th>
			<td>
				${content_view.bName }
			</td>
		</tr>
		<tr>
			<th>
				본문
			</th>
			<td>
				<pre>${content_view.bContent }</pre>
			</td>
		</tr>
		<tr>
			<th>
				작성일
			</th>
			<td>
				<fmt:formatDate value="${content_view.bDate }" pattern="yy/MM/dd(E)"/>
			</td>
		</tr>
		<tr>
			<th>
				조회수
			</th>
			<td>
				${content_view.bHit }
			</td>
		</tr>
		<tr>
			<th>
				ID
			</th>
			<td>
				${content_view.bIp }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath }/modify_view.do?bId=${content_view.bId }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='${conPath }/delete.do?bId=${content_view.bId }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location.href='${conPath }/reply_view.do?bId=${content_view.bId }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location.href='${conPath }/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>