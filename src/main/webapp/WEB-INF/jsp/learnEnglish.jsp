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

<p>このページは英単語学習(四択クイズ)画面です</p>

<br><br>

<form action="/MyProject/LearnEnglishServlet?action=q1" method="post">
<h3>難易度:簡単</h3>
<input type="submit" value="英単語学習スタート!">
</form>

<br>

<form action="/MyProject/LearnEnglishServlet?action=q6" method="post">
<h3>難易度:普通</h3>
<input type="submit" value="英単語学習スタート!">
</form>

<br>

<form action="/MyProject/LearnEnglishServlet?action=q11" method="post">
<h3>難易度:難しい</h3>
<input type="submit" value="英単語学習スタート!">
</form>

<br>

<ul>
<li><a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a></li>
</ul>

<br><br>

</body>
</html>