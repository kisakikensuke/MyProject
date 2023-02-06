package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet { //トップ画面のリクエストを処理するコントローラー
  private static final long serialVersionUID = 1L;

//このサーブレットクラスはエントリーポイント(ここから始まる)
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    dispatcher.forward(request, response);
  }
}
