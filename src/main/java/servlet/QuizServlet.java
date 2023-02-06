package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//クイズの回答を送信すると呼ばれる(0→不正解1→正解)
		//リクエストパラメータ(クイズの回答)を取得
		request.setCharacterEncoding("UTF-8");
		String qNum = request.getParameter("action");
		
		if(qNum.equals("q1")) {
			String answer = request.getParameter("q1");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q1answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q1ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q2")) {
			String answer = request.getParameter("q2");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q2answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q2ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q3")) {
			String answer = request.getParameter("q3");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q3answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q3ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q4")) {
			String answer = request.getParameter("q4");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q4answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q4ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q5")) {
			String answer = request.getParameter("q5");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q5answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q5ans.jsp");
		    dispatcher.forward(request, response);
		}else if(qNum.equals("q6")) {
			String answer = request.getParameter("q6");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q6answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q6ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q7")) {
			String answer = request.getParameter("q7");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q7answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q7ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q8")) {
			String answer = request.getParameter("q8");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q8answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q8ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q9")) {
			String answer = request.getParameter("q9");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q9answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q9ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q10")) {
			String answer = request.getParameter("q10");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q10answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q10ans.jsp");
		    dispatcher.forward(request, response);
		}else if(qNum.equals("q11")) {
			String answer = request.getParameter("q11");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q11answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q11ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q12")) {
			String answer = request.getParameter("q12");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q12answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q12ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q13")) {
			String answer = request.getParameter("q13");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q13answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q13ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q14")) {
			String answer = request.getParameter("q14");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q14answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q14ans.jsp");
		    dispatcher.forward(request, response);
		} else if(qNum.equals("q15")) {
			String answer = request.getParameter("q15");
			if(answer.equals("1")) {
				answer = "正解です!";
			} else {
				answer = "不正解です!";
			}
			//セッションスコープに回答を保存
			HttpSession session = request.getSession();
		    session.setAttribute("q15answer",answer);
		    //クイズの回答ページに遷移
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/q15ans.jsp");
		    dispatcher.forward(request, response);
		}
	}

}
