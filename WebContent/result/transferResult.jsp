<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String result = (String)request.getAttribute("result");
		if (result == null)
		{
	%>
		송금한 ID : ${id } -------> 받는 ID : ${rId } <br>
		송금한 돈 : ${money }<br>
		남은 현재 잔고 : ${tMoney }<br>
		
	<% 
		} else {
			out.print(result);
		}
	%>
		<p>
		<%@ include file="homeMenu.jsp" %>


</body>
</html>