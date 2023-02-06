<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープからマイリストデータを取得
	ArrayList<Words> words = new ArrayList<>();
	words = (ArrayList<Words>) session.getAttribute("words");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>JL Words!</title>
<style>
li {
	display: inline-block;
	border: 2px solid green;
	border-radius: 8px;
	padding: 6px;
}
</style>
</head>
<body>

<p><br></p>
<p><br></p>

<p>英単語一覧</p>


<ul>
<% for(Words word : words) {%>
	<li>
	英語:<%= word.getEnglish() %><br>
	日本語:<%= word.getJapanese() %><br>
	Javaでどう使うか:<%= word.getOn_java() %><br>
	</li>
<% } %>
</ul>

<ul>
<a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a>
</ul>

<p><br></p>

</body>
</html>