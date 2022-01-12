<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/UserJoin">User Join</a><br/>
<a href="/UserLogin">User Login</a><br/>
<c:if test="${LOGIN != null }">
<a href="/inserttest">data insert test</a><br/>
<a href="/getPlan">all plan get</a><br/>
<a href="/UserLogout">LOGOUT</a>
</c:if>
</body>
</html>
