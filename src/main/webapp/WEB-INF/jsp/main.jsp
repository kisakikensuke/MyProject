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
<h1>JL Words<span>!</span></h1>
<h2>～Java初学者向け英単語学習サイト～</h2>
<p>このページはホーム画面(ログイン後)です</p>
<p>ようこそ<c:out value="${userId}" />さん</p>
<ul>
<li><a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a></li>
<li><a href="/MyProject/UserUpdateServlet">ユーザー情報管理画面へ</a></li>
<li><a href="/MyProject/WelcomeServlet">トップへ(ログアウト)</a></li>
</ul>
</body>
</html>
