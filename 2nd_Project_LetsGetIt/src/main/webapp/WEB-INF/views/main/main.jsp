<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/main.css" rel="stylesheet"/>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function (){

	$('#body').ready(function realTime(){
		var date = new Date();
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var seconds = date.getSeconds();
		
		hours=addZero(hours);
		minutes=addZero(minutes);
		seconds=addZero(seconds);
		
		$('#clock').html(hours+":"+minutes+":"+seconds);
		$('#clock').css('float','right');
		
		setTimeout(function(){
			realTime();
		},500);
		
		function addZero(i){
			if(i<10){
				i="0"+i;
			}
			return i;
		}
	});	
});
</script>
</head>
<body id="body">
<jsp:include page="header.jsp"/>
<section>
	<div id="main">
		<div class="left">
			<div class="title">
				실시간 <span>BEST</span>
				<span id="clock"> </span>
			</div>
			<div class="content">
				<table>
					<c:set var="i" value="1"/>
					<c:forEach begin="1" end="10">
						<tr>
							<th>
								${i}
							</th>
							<td>
								<a href=""> 액티비티 이름 </a> <!-- 임시방편  -->
								<c:forEach items="${activityList }" var="dto">
									<a href="">${dto.aName }</a>
								</c:forEach>
							</td>
						</tr>				
					<c:set var="i" value="${i+1 }"/>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="right">
			<div class="nav">
			 	인기 카테고리
			 	<span><a href="${conPath }/activityList.do">전체보기</a></span>
			</div>
			<div class="category">
				<table>
					<tr>
						<td>
							<a href="${conPath }/cate1.do">
			 					<img src="${conPath }/img/cate1.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate2.do">
			 					<img src="${conPath }/img/cate2.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate3.do">
			 					<img src="${conPath }/img/cate3.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate4.do">
			 					<img src="${conPath }/img/cate4.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate5.do">
			 					<img src="${conPath }/img/cate5.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate6.do">
			 					<img src="${conPath }/img/cate6.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate7.do">
			 					<img src="${conPath }/img/cate7.png">
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate8.do">
			 					<img src="${conPath }/img/cate8.png">
			 				</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${conPath }/cate1.do">
			 					소셜클럽
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate2.do">
			 					베이킹
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate3.do">
			 					아웃도어
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate4.do">
			 					DIY
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate5.do">
			 					운동
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate6.do">
			 					친목
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate7.do">
			 					제주
			 				</a>
						</td>
						<td>
							<a href="${conPath }/cate8.do">
			 					IT
			 				</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="listwrap">
				<div class="list">
					<div class="nav">
				 		NEW 신규 액티비티	
				 		<span><a href="${conPath }/activityList.do">전체보기</a></span>			
					</div>
					<div class="content">
						<table>
							<tr>
								<c:forEach var="activity" items="${activityList }" begin="0" end="3">
									<td>
										<a href="${conPath }/activityDetail.do?actId=${activity.actId}">
											<img src="${conPath }/upload/${activity.actImg}">
										</a>
										<br>
										<a href="${conPath }/activityDetail.do?actId=${activity.actId}">
											${activity.Name }
										</a>
										<br>
										<a href="${conPath }/activityDetail.do?actId=${activity.actId}">
											<fmt:formatNumber pattern="###,###" value="${activity.price }"/>원
										</a>
									</td>
								</c:forEach>
							</tr>
						</table>
					</div>
				</div>
				<div class="list">
				 	<div class="nav">
				 		BEST 호스트 액티비티
				 		<span><a href="${conPath }/activityList.do">전체보기</a></span>
					</div>
					<div class="content">
						<div id="">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="footer.jsp"/>
</body>
</html>