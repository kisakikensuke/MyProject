<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Mylist" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープからマイリストデータを取得
	ArrayList<Mylist> mylists = new ArrayList<>();
	mylists = (ArrayList<Mylist>) session.getAttribute("mylists");
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

<p>このページはマイリスト確認&編集画面です</p>

<p>ご自身で英単語を登録していただくことも可能です</p>
<form action="/MyProject/AddMylistServlet" method="post">
英語:<input type="text" name="english"><br>
日本語:<input type="text" name="japanese"><br>
Javaでどう使うか:<input type="text" name="on_java"><br>
<input type="submit" value="英単語を登録する">
</form>

<ul>
<% for(Mylist mylist : mylists) {%>
	<li>
	英語:<%= mylist.getEnglish() %><br>
	日本語:<%= mylist.getJapanese() %><br>
	Javaでどう使うか:<%= mylist.getOn_java() %><br>
	<form action="/MyProject/DeleteMylistServlet?action=<%= mylist.getEnglish() %>" method="post">
		<input type="submit" value="この単語をマイリストから削除する">
	</form>
	</li>
<% } %>
</ul>

<ul>
<a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a>
</ul>

<p><br></p>

</body>
</html>