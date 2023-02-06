<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープから回答データを取得
	String q1answer = (String) session.getAttribute("q1answer");
	String q2answer = (String) session.getAttribute("q2answer");
	String q3answer = (String) session.getAttribute("q3answer");
	String q4answer = (String) session.getAttribute("q4answer");
	String q5answer = (String) session.getAttribute("q5answer");
	//正答率を集計
	String[] answers = {q1answer,q2answer,q3answer,q4answer,q5answer};
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
	<%= q1answer %><br>
	英語:<%= words.get(0).getEnglish() %><br>
	正解:<%= words.get(0).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(0).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=0" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q2answer %><br>
	英語:<%= words.get(1).getEnglish() %><br>
	正解:<%= words.get(1).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(1).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=1" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q3answer %><br>
	英語:<%= words.get(2).getEnglish() %><br>
	正解:<%= words.get(2).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(2).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=2" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q4answer %><br>
	英語:<%= words.get(3).getEnglish() %><br>
	正解:<%= words.get(3).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(3).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=3" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q5answer %><br>
	英語:<%= words.get(4).getEnglish() %><br>
	正解:<%= words.get(4).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(4).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=4" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
	
<ul>
<li><a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a></li>
</ul>

<br><br>

</body>
</html>