<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	7번째 화면 ~ 출금 ~
	<p>
	현재 총 잔고 : ${money}
	<p>
	<form action="withdrawal.do" method="post">
	출금 할 금액 : <input type="text" name="money" required/><br>
	<input type="submit" value="WITHDRAWAL" />
	</form>
	
</body>
</html>