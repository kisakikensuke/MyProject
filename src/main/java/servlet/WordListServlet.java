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

@WebServlet("/WordListServlet")
public class WordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//英単語データの取得
		LearnEnglishLogic bo = new LearnEnglishLogic();
		ArrayList<Words> words = new ArrayList<>();
		words = bo.acquisitionWords();
		
		HttpSession session = request.getSession();
		session.setAttribute("words",words);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/wordList.jsp");
		dispatcher.forward(request, response);
	}

}
