<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>JL Words!</title>
</head>
<body>
<br><br>
<a href="/MyProject/MainServlet">ホームへ戻る</a>
<p>このページはユーザー情報更新ページです</p>
<p>新しいパスワード、メールアドレス、お名前を再入力していただきます</p>
<p>あなたのユーザーID:<c:out value="${userId}" /></p>
<form action="/MyProject/UserUpdateServlet" method="post">
新しいパスワード:<input type="password" name="pass"><br>
新しいメールアドレス:<input type="email" name="mail"><br>
新しいお名前:<input type="text" name="name"><br>
<input type="submit" value="ユーザー情報更新">
</form>
</body>
</html>