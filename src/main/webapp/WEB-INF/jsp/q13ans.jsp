<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープから回答データを取得
	String answer;
	answer = (String) session.getAttribute("q13answer");
%>
<%
	//セッションスコープから全英単語データを取得
	ArrayList<Words> words = new ArrayList<>();
	words = (ArrayList<Words>) session.getAttribute("words");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<title>JL Words!</title>
</head>
<body>

<p><br></p>
<p><br></p>
<p><br></p>

<p>
	<%= answer %><br>
	英語:<%= words.get(12).getEnglish() %><br>
	正解:<%= words.get(12).getJapanese() %><br>
	<i class="bi bi-robot"></i><i class="bi bi-chat-text"></i><%= words.get(12).getOn_java() %><br>
</p>
	
<form action="/MyProject/LearnEnglishServlet?action=q14" method="post">
<input type="submit" value="次の問題へ">
</form>
</body>
</html>