package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/dice.do")
public class DiceServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//주사위 값 생성 및 첨부(request)
		Random r = new Random();
		int data = r.nextInt(6)+1;
		
		req.setAttribute("data", data);//data란 이름으로 data의 값을 전달
	
		//포워딩 코드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/dice.jsp");
		dispatcher.forward(req, resp);
	}
}
