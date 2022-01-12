<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan insert Test</title>
</head>
<body>
<form action="inserttest" method="post">
	일정 생성 한 유저 : <input type="text" name="plan_user"/><br/>
	일정 번호 : <input type="text" name="plan_number"/><br/>
	중요도 : <input type="text" name="plan_priority"/><br/>
	제목 : <input type="text" name="plan_title"/><br/>
	위치 : <input type="text" name="plan_location"/><br/>
	마감날짜 : <input type="text" name="plan_deadline"/><br/>
	설명 : <input type="text" name="plan_description"/><br/>
	카테고리 : <input type="text" name="plan_category"/><br/>
	공개여부 : <input type="text" name="plan_share"/><br/>
	<input type="submit" value="insert"/>
</form>	
</body>
</html>