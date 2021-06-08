<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	송금화면 !!!!!
	<p>
	
	<form action = "search.do" method="post">
		받는사람 / Receiver ID : <input type="text" name="id" /><br>
		<input type="submit" value="조회 SEARCH" /><br>
	</form>
	
	<%
		String result = (String)request.getAttribute("msg");
		if(result != null && result.equals("true"))
		{
	%>
		<form action = "transfer.do" method="post">
			받는사람 / Receiver ID	: <input type="text" name="rId" value="${rId }" readonly /><br>
			보내는 금액			: <input type="text" name="money" /><br>
		<input type="submit" value="송금 ~ Transfer" />
	</form>
	
	<% } else if(result != null && result.equals("false")){
		out.print("받는사람 없음. No receiver ID");
	}
	
	%>
</body>
</html>