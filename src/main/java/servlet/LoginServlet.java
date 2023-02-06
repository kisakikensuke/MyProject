package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //このサーブレットはindex.jsp(トップページ)でログイン画面に遷移しようとするとdoGetが呼ばれる
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // フォワード
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
	  dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//ログイン画面(login.jsp)でフォームを送信するとこのメソッドが呼ばれる
    // リクエストパラメータ(ユーザーidとパス)の取得
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String pass = request.getParameter("pass");

    // ログイン処理の実行
    Login login = new Login(userId, pass);//フォームから入力された値をloginへ代入
    LoginLogic bo = new LoginLogic();
    boolean result = bo.execute(login);

    // ログイン処理の成否によって処理を分岐
    if (result) {//resultがtrue→DBに一致するレコードがあったとき
      // セッションスコープにユーザーIDを保存
      HttpSession session = request.getSession();
      session.setAttribute("userId", userId);

      // フォワード
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
      dispatcher.forward(request, response);//ログイン成功画面に遷移
    } else { //resultがfalse→DBに一致するレコードがなかった時
    // リダイレクト
      response.sendRedirect("/MyProject/LoginServlet");//doGetメソッドへ移る
      //もう一度ユーザーIDとパスを入力させる
    }
  }
}
