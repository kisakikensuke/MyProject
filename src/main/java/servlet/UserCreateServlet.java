package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.UserCreateLogic;

@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//会員登録画面(userCreate.jsp)でフォームを送信するとこのメソッドが呼ばれる
	    // リクエストパラメータ(会員登録情報)の取得
	    request.setCharacterEncoding("UTF-8");
	    String userId = request.getParameter("userId");
	    String pass = request.getParameter("pass");
	    String mail = request.getParameter("mail");
	    String name = request.getParameter("name");
	    
	    //nullチェック
	    if(userId == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserCreateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else if(pass == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserCreateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else if(mail == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserCreateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else if(name == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserCreateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else {
	    	//アカウントの作成
		    Account account = new Account(userId,pass,mail,name);//フォームから入力された値をaccountへ代入
		    UserCreateLogic bo = new UserCreateLogic();
		    boolean result = bo.execute(account);
		    if(result) {//INSERT文が成功したとき
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreateOK.jsp");
		        dispatcher.forward(request, response);//会員登録成功画面に遷移
		    } else {
		    	// リダイレクト
		        response.sendRedirect("/MyProject/UserCreateServlet");//doGetメソッドへ移る(もう一度入力させる)
		    }
	    }
	}

}
