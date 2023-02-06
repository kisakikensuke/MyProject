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

@WebServlet("/AddMylistServlet")
public class AddMylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String english = request.getParameter("english");
		String japanese = request.getParameter("japanese");
		String on_java = request.getParameter("on_java");
		
		Mylist mylist = new Mylist(english,japanese,on_java);
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		MylistLogic bo = new MylistLogic();
		bo.add(mylist,userId);
		
		//MYLISTの再取得
		ArrayList<Mylist> mylists = new ArrayList<>();
	    mylists = bo.acquisition(userId);
	    
	    session.setAttribute("mylists",mylists);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/learnMylist.jsp");
	  	dispatcher.forward(request, response);
	}

}
