<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- pageContext.request.contextPath 를 이용하면 절대 경로를 기준으로 설정 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/user/join.css">
<script src="${pageContext.request.contextPath}/resources/js/user/join.js"></script>
<title>회원가입</title>
</head>

<body>
	<form id="joinform" action="userJoin">
		<h2>회원가입</h2>
		<div align="center" id="msg"></div>
		<ul>
			<li><label for="email">이메일</label> 
			<input type="text" id="email"
				name="user_email" class="textinput" placeholder="이메일 주소를 입력하세요" /></li>
			<div id="emailmsg"></div>
			
			<li><label for="pw">비밀번호</label> 
			<input type="password" id="pw"
				name="user_pw" class="textinput" placeholder="비밀번호는 8-15자로 만들어야 합니다." />
			</li>
			<div id="pwmsg"></div>
			
			<li><label for="pw1">비밀번호확인</label> 
			<input type="password"
				id="pw1" class="textinput"
				placeholder="영문 대소문자와 특수문자와 숫자 1개 이상으로 만들어야 합니다." /></li>
			
			<li><label for="nickname">별명</label> 
			<input type="text"
				id="nickname" name="user_nick" class="textinput" placeholder="사용할 닉네임을 입력 해 주세요" /></li>
			<div id="nicknamemsg"></div>
			
			<li><label for="birthday">생년월일</label> 
			<input type="date"
				id="birthday" name="user_birthday" class="textinput" /></li>
			
			<li><label for="gender">성별</label> 
			<input type="radio" id="gender" name="user_gender" value="여성" checked="checked"/>여성
			<input type="radio" id="gender" name="user_gender" value="남성" />남성
			</li>
			
			
			<div align="center">
				<li class="buttons"><input type="button" value="회원가입"
					id="joinbtn" /> <input type="button" value="메인" id="mainbtn" /> <input
					type="button" value="로그인" id="loginbtn" /></li>
			</div>
		</ul>
	</form>

</body>
</html>

