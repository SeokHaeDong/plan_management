<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan update Test</title>
</head>
<body>
<form action="/update" method="POST">
	일정 생성 한 유저 : <input type="text" name="plan_user" value="${update.plan_user}" readonly/><br/>
	일정 번호 : <input type="text" name="plan_number" value="${update.plan_number}" readonly/><br/>
	중요도 : <input type="text" name="plan_priority" value="${update.plan_priority}"/><br/>
	제목 : <input type="text" name="plan_title" value="${update.plan_title}"/><br/>
	위치 : <input type="text" name="plan_location" value="${update.plan_location}"/><br/>
	마감날짜 : <input type="text" name="plan_deadline" value="${update.plan_deadline}"/><br/>
	설명 : <input type="text" name="plan_description" value="${update.plan_description}"/><br/>
	카테고리 : <input type="text" name="plan_category" value="${update.plan_category}"/><br/>
	공개여부 : <input type="text" name="plan_share" value="${update.plan_share}"/><br/>
	<input type="submit" value="update"/>
</form>	
</body>
</html>