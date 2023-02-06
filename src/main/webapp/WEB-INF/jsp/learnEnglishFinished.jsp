<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープから回答データを取得
	String[] answer = new String[3];
	answer = (String[]) session.getAttribute("answer");
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
<title>タイトル</title>
</head>
<body>

<% for(int i = 0; i < words.size(); i++) { %>
	<p>
	回答:<%= answer[i] %><br>
	英語:<%= words.get(i).getEnglish() %><br>
	正解:<%= words.get(i).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(i).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=<%= i %>" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
	</p>
<% } %>

</body>
</html>