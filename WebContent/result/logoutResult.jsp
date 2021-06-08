<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	아이디 :	${id } 는 로그아웃 되었습니다 ~!~! 
	<%
		session.invalidate();
	%>
	<p>
	<%@ include file="home.jsp" %>

</body>
</html>