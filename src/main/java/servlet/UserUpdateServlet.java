package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.UserUpdateLogic;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー情報更新画面(userUpdate.jsp)でフォームを送信するとこのメソッドが呼ばれる
	    // リクエストパラメータ(ユーザー更新情報)の取得
	    request.setCharacterEncoding("UTF-8");
	    String pass = request.getParameter("pass");
	    String mail = request.getParameter("mail");
	    String name = request.getParameter("name");
	    
	    //セッションスコープからユーザーIDを取得
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
	    
	    //nullチェック
	    if(pass == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserUpdateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else if(mail =="") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserUpdateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else if(name == "") {
	    	// リダイレクト
	        response.sendRedirect("/MyProject/UserUpdateServlet");//doGetメソッドへ移る(もう一度入力させる)
	    }else {
	    	//更新後のアカウント作成
		    Account account = new Account(userId,pass,mail,name);
		    UserUpdateLogic bo = new UserUpdateLogic();
		    boolean result = bo.execute(account);
		    
		    if(result) {//UPDATE文が成功したとき
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdateOK.jsp");
		        dispatcher.forward(request, response);//会員情報更新成功画面に遷移
		    } else {
		    	// リダイレクト
		        response.sendRedirect("/MyProject/UserUpdateServlet");//doGetメソッドへ移る(もう一度入力させる)
		    }
	    }
	}

}
