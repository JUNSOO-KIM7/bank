<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	8번째 화면 / 출금 결과 
	<p>
	<%
		String result = (String)request.getAttribute("result");
	if (result == null)
	{
	
	%>
		
	ID			:${id } <br>
	지금 입금한 돈	:${money } <br>
	총 소유한 돈	:${tMoney }	<br>
		
	<% }else{
		out.print(result);
	}	
	%>
	<p>
	<%@ include file="homeMenu.jsp" %>

</body>
</html>