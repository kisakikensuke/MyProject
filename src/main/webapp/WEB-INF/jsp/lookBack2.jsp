<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープから回答データを取得
	String q6answer = (String) session.getAttribute("q6answer");
	String q7answer = (String) session.getAttribute("q7answer");
	String q8answer = (String) session.getAttribute("q8answer");
	String q9answer = (String) session.getAttribute("q9answer");
	String q10answer = (String) session.getAttribute("q10answer");
	//正答率を集計
	String[] answers = {q6answer,q7answer,q8answer,q9answer,q10answer};
	String searchElement = "正解です!";
	int cnt = 0;
	for(String ans : answers) {
		if(ans.equals(searchElement)) {
			cnt++;
		}
	}
	double ansRate = cnt / 5.00 * 100;
	int intansRate = (int) ansRate;
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
<title>JL Words!</title>
</head>
<body>

<p><br></p>
<p><br></p>

<p>あなたの正答率は<%= intansRate %>%です!</p>

<p>
	<%= q6answer %><br>
	英語:<%= words.get(5).getEnglish() %><br>
	正解:<%= words.get(5).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(5).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=5" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q7answer %><br>
	英語:<%= words.get(6).getEnglish() %><br>
	正解:<%= words.get(6).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(6).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=6" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q8answer %><br>
	英語:<%= words.get(7).getEnglish() %><br>
	正解:<%= words.get(7).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(7).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=7" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q9answer %><br>
	英語:<%= words.get(8).getEnglish() %><br>
	正解:<%= words.get(8).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(8).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=8" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q10answer %><br>
	英語:<%= words.get(9).getEnglish() %><br>
	正解:<%= words.get(9).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(9).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=9" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
	
<ul>
<li><a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a></li>
</ul>

<br><br>

</body>
</html>