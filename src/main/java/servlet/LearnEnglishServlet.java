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

import model.LearnEnglishLogic;
import model.Words;

@WebServlet("/LearnEnglishServlet")
public class LearnEnglishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/learnEnglish.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//英単語学習スタートボタン&次の問題へで呼ばれるメソッド
		request.setCharacterEncoding("UTF-8");
		String qNum = request.getParameter("action");
		
		//英単語データの取得
		LearnEnglishLogic bo = new LearnEnglishLogic();
		ArrayList<Words> words = new ArrayList<>();
		words = bo.findWords();
		
		//セッションスコープにWordsインスタンス(全レコード)を保存
		HttpSession session = request.getSession();
		session.setAttribute("words",words);
		
		//実際の四択クイズページに遷移
		if(qNum.equals("q1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q1.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q2.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q3.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q4")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q4.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q5")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q5.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("LookBack1")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lookBack1.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q6")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q6.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q7")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q7.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q8")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q8.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q9")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q9.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q10")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q10.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("LookBack2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lookBack2.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q11")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q11.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q12")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q12.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q13")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q13.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q14")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q14.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("q15")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q15.jsp");
			dispatcher.forward(request, response);
		} else if(qNum.equals("LookBack3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/lookBack3.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
