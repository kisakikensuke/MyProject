package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mylist;
import model.MylistLogic;
import model.Words;

@WebServlet("/LearnMylistServlet")
public class LearnMylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//マイリスト画面を表示しようとするとこのメソッドが呼ばれる
		//まずはユーザーごとのマイリストを取得
		//セッションスコープからユーザーIDを取得
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
	    
	    MylistLogic bo = new MylistLogic();
	    ArrayList<Mylist> mylists = new ArrayList<>();
	    mylists = bo.acquisition(userId);
	    
	    //取得したmylistをセッションスコープに保存
		session.setAttribute("mylists",mylists);
	    //マイリスト画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/learnMylist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//マイリスト登録しようとすると呼ばれるメソッド
		//リクエストパラメータ(どの英単語(ナンバリング)をマイリストに登録するか)の取得
		request.setCharacterEncoding("UTF-8");
	    String action = request.getParameter("action");
	    int number = Integer.parseInt(action);
	    
	    HttpSession session = request.getSession();
	    ArrayList<Words> words = new ArrayList<>();
		words = (ArrayList<Words>) session.getAttribute("words");
		
		Mylist mylist = new Mylist(words.get(number).getEnglish(),words.get(number).getJapanese(),words.get(number).getOn_java());
		
		//ユーザーID(誰が登録してるか)の取得
		String userId = (String)session.getAttribute("userId");
		
		MylistLogic bo = new MylistLogic();
		bo.add(mylist,userId);
		
		//マイリスト完了画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/learnEnglishMylisted.jsp");
		dispatcher.forward(request, response);
	}

}
