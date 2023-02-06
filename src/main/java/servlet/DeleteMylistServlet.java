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

@WebServlet("/DeleteMylistServlet")
public class DeleteMylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//マイリストを削除するためのメソッド
		request.setCharacterEncoding("UTF-8");
		String english = request.getParameter("action");
		
		//セッションスコープからユーザーIDを取得
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("userId");
	    
	    MylistLogic bo = new MylistLogic();
	    bo.delete(english, userId);
	    
	    //MYLISTの再取得
	    ArrayList<Mylist> mylists = new ArrayList<>();
	    mylists = bo.acquisition(userId);
	    
	    session.setAttribute("mylists",mylists);
	    
	    //マイリスト画面に遷移
	  	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/learnMylist.jsp");
	  	dispatcher.forward(request, response);
	}

}
