<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%
	//セッションスコープから回答データを取得
	String q11answer = (String) session.getAttribute("q11answer");
	String q12answer = (String) session.getAttribute("q12answer");
	String q13answer = (String) session.getAttribute("q13answer");
	String q14answer = (String) session.getAttribute("q14answer");
	String q15answer = (String) session.getAttribute("q15answer");
	//正答率を集計
	String[] answers = {q11answer,q12answer,q13answer,q14answer,q15answer};
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
	<%= q11answer %><br>
	英語:<%= words.get(10).getEnglish() %><br>
	正解:<%= words.get(10).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(10).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=10" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q12answer %><br>
	英語:<%= words.get(11).getEnglish() %><br>
	正解:<%= words.get(11).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(11).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=11" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q13answer %><br>
	英語:<%= words.get(12).getEnglish() %><br>
	正解:<%= words.get(12).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(12).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=12" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q14answer %><br>
	英語:<%= words.get(13).getEnglish() %><br>
	正解:<%= words.get(13).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(13).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=13" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
<p>
	<%= q15answer %><br>
	英語:<%= words.get(14).getEnglish() %><br>
	正解:<%= words.get(14).getJapanese() %><br>
	Javaでどう使うか:<%= words.get(14).getOn_java() %><br>
	<form action="/MyProject/LearnMylistServlet?action=14" method="post">
		<input type="submit" value="この単語をマイリストに登録する">
	</form>
</p>
	
<ul>
<li><a href="/MyProject/LearnMainServlet">英単語学習トップ画面へ</a></li>
</ul>

<br><br>

</body>
</html>