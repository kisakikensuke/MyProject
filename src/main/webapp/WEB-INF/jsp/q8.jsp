<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Words" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%
	//セッションスコープから全英単語データを取得
	ArrayList<Words> words = new ArrayList<>();
	words = (ArrayList<Words>) session.getAttribute("words");
	
	//選択肢ランダム表示のための処理
	ArrayList<String> list = new ArrayList<>();
	list.add(words.get(7).getJapanese());
	list.add(words.get(7).getWrong_1());
	list.add(words.get(7).getWrong_2());
	list.add(words.get(7).getWrong_3());
	
	Collections.shuffle(list);
	
	//正解の選択肢が何番目にあるか確認する(0~3)
	int ans = 0;
	for(int i=0;i<list.size();i++) {
		String choise = list.get(i);
		if(choise.equals(words.get(7).getJapanese())){
			ans = i;
			break;
		}
	}
	//正解の選択肢のvalueだけ1にする
	String[] answers = {"0","0","0","0"};
	answers[ans] = "1";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>JL Words!</title>
<style>

fieldset {
  border: none;
  padding: 0;
  margin: 0;
  text-align: center;
}

.radio-inline__input {
    clip: rect(1px, 1px, 1px, 1px);
    position: absolute !important;
}

.radio-inline__label {
    display: inline-block;
    padding: 0.5rem 1rem;
    margin-right: 18px;
    border: 1px solid black;
    border-radius: 3px;
    transition: all .2s;
}

.radio-inline__input:checked + .radio-inline__label {
    background: #B54A4A;
    color: #fff;
    text-shadow: 0 0 1px rgba(0,0,0,.7);
}

.radio-inline__input:focus + .radio-inline__label {
    outline-offset: -2px;
    outline-style: auto;
    outline-width: 5px;
}

</style>
</head>
<body>

<p><br></p>
<p><br></p>
<p><br></p>

<form action="/MyProject/QuizServlet?action=q8" method="post">
<p>
	<h3>問題8:<%= words.get(7).getEnglish() %></h3>
	<br>
	
	<input type="radio" name="q8" value="<%= answers[0] %>" id="0" class="radio-inline__input">
	<label for="0" class="radio-inline__label"><%= list.get(0) %></label>
	
	<input type="radio" name="q8" value="<%= answers[1] %>" id="1" class="radio-inline__input">
	<label for="1" class="radio-inline__label"><%= list.get(1) %></label>
	
	<input type="radio" name="q8" value="<%= answers[2] %>" id="2" class="radio-inline__input">
	<label for="2" class="radio-inline__label"><%= list.get(2) %></label>
	
	<input type="radio" name="q8" value="<%= answers[3] %>" id="3" class="radio-inline__input">
	<label for="3" class="radio-inline__label"><%= list.get(3) %></label>
	
	<input type="radio" name="q8" value="0" checked="checked" style="display:none;">
	<br>
</p>
<input type="submit" value="答えを送信する">
</form>
</body>
</html>