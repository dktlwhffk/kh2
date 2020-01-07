package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//단순하게 로그인 화면 연동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//1.수신
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			//2.처리
			MemberDao dao = new MemberDao();
			boolean result = dao.login(id, pw);
			//3.이동
			if(result) {
				resp.sendRedirect(req.getContextPath());
			}
			else {
				resp.sendRedirect("login.do?error");//로그인 페이지로
			}
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
