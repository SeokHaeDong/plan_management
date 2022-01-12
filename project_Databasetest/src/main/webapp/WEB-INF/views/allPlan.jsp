<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- List 데이터가 있는지 없는지 확인하기 위해서 List의 길이를 확인하기 위해서
 태그 라이브러리 설정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Spring MVC</title>
	<!--  이 파일은 webapp 디렉토리의 css 디렉토리에 style.css
	이런 이유로 외부 자원의 링크는 절대경로로 설정하는 경우가 많다 -->
	<!-- <link rel="stylesheet" href="./css/style.css"/> -->
</head>
<body>
<div align="center" class="body">
	<h2>일정 목록</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">plan_number</th>
			<th align="center" width="80">plan_title</th>
			<th align="center" width="80">plan_deadline</th>		
		</tr>
		
		<!--  list 에 데이터가 없는 경우 -->
		<c:if test="${fn:length(list) == 0  }">
			<tr>
				<td colspan="3">데이터 없음</td>
			</tr>
		</c:if>
		
		<c:if test="${fn:length(list) != null }">
		<c:forEach var="plan" items="${list }">
			<tr class="record">
				<td align="center">${plan.plan_number}</td>
				<td align="left"><!-- <a href="/detail.html?itemid=${item.itemid }">${item.itemname} 파라미터를 이용해서 데이터를 전달하는 방식</a> -->
				<!-- URL 을 이용해서 데이터를 전달하는 방식  -->
				<a href="/detail/${plan.plan_number }">${plan.plan_title}</a>
				</td>
				<td align="right">${plan.plan_deadline}</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
	<form action="/" method="get">
		<button>return</button>
	</form>
</div>

</body>
</html>
	