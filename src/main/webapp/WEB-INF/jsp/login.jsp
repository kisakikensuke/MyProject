<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>JL Words!</title>
</head>
<body>

<p><br></p>
<p><br></p>
<p><br></p>

<form action="/MyProject/LoginServlet" method="post">
	ユーザーID:<input type="text" name="userId"><br>
	パスワード:<input type="password" name="pass"><br>
	<input type="submit" value="ログイン">
</form>

</body>
</html>
