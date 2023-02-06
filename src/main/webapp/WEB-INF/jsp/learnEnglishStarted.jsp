<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
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
<form action="/MyProject/QuizServlet" method="post">

<% for(int i = 0; i < words.size(); i++) { %>
	<p>
	英語(問題<%= i + 1 %>):<%= words.get(i).getEnglish() %><br>
	選択肢1(正解):<%= words.get(i).getJapanese() %><input type="radio" name="<%= i %>" value="1"><br>
	選択肢2(不正解):<%= words.get(i).getWrong_1() %><input type="radio" name="<%= i %>" value="0"><br>
	選択肢3(不正解):<%= words.get(i).getWrong_2() %><input type="radio" name="<%= i %>" value="0"><br>
	選択肢3(不正解):<%= words.get(i).getWrong_3() %><input type="radio" name="<%= i %>" value="0"><br>
	</p>
<% } %>

<input type="submit" value="答えを送信する">
</form>
</body>
</html>