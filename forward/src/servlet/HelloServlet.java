package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hello.do")
public class HelloServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//포워딩(forwarding)
		//-현재 연결을 유지하며 다른 대상을 호출하여 실행하는 것
		
		//[1]도구 획득
//		RequestDispatcher dispatcher = req.getRequestDispatcher("hello.jsp"); 상대경로
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/hello.jsp"); //절대경로
		
		
		//[2]포워딩
		dispatcher.forward(req, resp);
		
		
	}
	
}
