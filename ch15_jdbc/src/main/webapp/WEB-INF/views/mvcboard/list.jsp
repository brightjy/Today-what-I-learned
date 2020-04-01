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
/* 	$('tr').click(function(){
		var bId = Number($(this).children(0).eq(2).html());
		if(!isNaN(bId)){ // 제목행을 클릭한 경우 - $(this).children(0).eq(2)가 숫자가 아님 - 를 제외하기 위해
			location.href='${conPath}/content_view.do?bId='+bId+'&pageNum=${pageNum}';
		}
	}); */
});
function trClicked(bId){
	location.href='${conPath}/content_view.do?bId='+bId+'&pageNum=${pageNum}';
}
</script>
</head>
<body>
<c:set var="SUCCESS" value="1"/>
<c:set var="FAIL" value="0"/>
<c:if test="${writeResult==SUCCESS }">
	<script>
		alert('글 쓰기 성공');
	</script>
</c:if>
<c:if test="${writeResult==FAIL }">
	<script>
		alert('글 쓰기 실패');
	</script>
</c:if>
<c:if test="${modifyResul==SUCCESS }">
	<script>
		alert('글 수정 성공');
	</script>
</c:if>
<c:if test="${modifyResul==FAIL }">
	<script>
		alert('글 수정 실패');
	</script>
</c:if>
<c:if test="${replyResult==SUCCESS }">
	<script>
		alert('답변 글 쓰기 성공');
	</script>
</c:if>
<c:if test="${replyResult==FAIL }">
	<script>
		alert('답변 글 쓰기 실패');
	</script>
</c:if>
<c:if test="${deleteResult==SUCCESS }">
	<script>
		alert('글 삭제 성공');
	</script>
</c:if>
<c:if test="${deleteResult==FAIL }">
	<script>
		alert('글 삭제 실패');
	</script>
</c:if>
	<table>
		<caption>List</caption>
		<tr>
			<td class="writebtn">
				<a href="${conPath }/write_view.do">
					글쓰기
				</a>
			</td>
		</tr>
	</table>
	<c:set var="oNum" value="${orderNum }"/>
	<c:set var="iNum" value="${inverseNum }"/>
	<table>
		<tr>
			<th>
				순번
			</th>
			<th>
				역순
			</th>
			<th>
				글 번호
			</th>
			<th>
				작성자
			</th>
			<th>
				제목
			</th>
			<th>
				작성일
			</th>
			<th>
				조회수
			</th>
		</tr>
		<c:if test="${totCnt==0 }">
			<tr>
				<td colspan="7">
					작성된 글이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:if test="${totCnt!=0 }">
			<c:forEach items="${list }" var="dto">
				<tr onclick="trClicked(${dto.bId})">
					<td>
						${oNum }
					</td>
					<td>
						${iNum }
					</td>
					<td>
						${dto.bId }
					</td>
					<td>
						${dto.bName }
					</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${dto.bIndent }">
							<c:if test="${i==dto.bIndent }">
								&nbsp;└─
							</c:if>
							<c:if test="${i!=dto.bIndent }">
								&nbsp;&nbsp;&nbsp;
							</c:if>
						</c:forEach>
						${dto.bTitle }
					</td>
					<td>
						<fmt:formatDate value="${dto.bDate }" pattern="YY/MM/dd(E)"/>
					</td>
					<td>
						<fmt:formatNumber value="${dto.bHit }" groupingUsed="ture"/>
					</td>
				</tr>
				<c:set var="oNum" value="${oNum+1 }"/>
				<c:set var="iNum" value="${iNum-1 }"/>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/list.do?pageNum=${startPage-1 }">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt}">
			[ <a href="${conPath}/list.do?pageNum=${endPage+1 }">다음</a> ]
		</c:if>
	</div>
</body>
</html>