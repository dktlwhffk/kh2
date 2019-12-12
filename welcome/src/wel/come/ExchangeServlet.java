package wel.come;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exchange")
public class ExchangeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/plain; charset=UTF-8");
		
		String dollar = req.getParameter("dollar");
		
		double won = 1178.20;
		
//		String from = "dollar";

		int to = Integer.parseInt(dollar);

		System.out.println("환전 결과 = "+to*won);
		
		double result = (to*won);
		
//		String to1 = Integer.toString(result);
		
		resp.getWriter().println("환전 금액 = "+result);
		
	}
}
