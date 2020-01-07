package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/plus.do")
public class PlusServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			
			req.setAttribute("a", a);
			req.setAttribute("b", b);	
//			req.setAttribute("a+b", a+b);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/plus.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e){
			resp.sendError(500);
			e.printStackTrace();
		}
		
		
	}
}
