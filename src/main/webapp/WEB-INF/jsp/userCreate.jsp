<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>JL Words!</title>
</head>
<body>
<p>このページは会員登録ページです</p>
<form action="/MyProject/UserCreateServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
メールアドレス:<input type="email" name="mail"><br>
お名前:<input type="text" name="name"><br>
<input type="submit" value="新規会員登録">
</form>
</body>
</html>
