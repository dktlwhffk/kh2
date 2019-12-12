package wel.come;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/subway")
public class SubwayServlet extends HttpServlet{
//	사용자가 다음 주소로 접속할 경우 year 라는 이름의 파라미터를 받아 아래 내용을 처리
//	단, year는 4자리의 숫자로 입력한다고 가정합니다.
//	http://localhost:8080/welcome/subway?year=1999
//	분류	나이	금액(원)
//	성인		20~64	1250
//	청소년	14 ~ 19	720
//	어린이	8 ~ 13	450
//	노약자	65~		0
//	유아		~7		0
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/plain; charset=UTF-8");
		
		String year = req.getParameter("year");
		
		int currentyear = Calendar.getInstance().get(Calendar.YEAR);
		
		int age = Integer.parseInt(year);
		
		int result = ((currentyear-age)+1);
		
		if (result<=7) {
			resp.getWriter().println("금액: "+0+"원");
		} else if (result>=8 && result<=13) {
			resp.getWriter().println("금액: "+450+"원");
		} else if (result>=14 && result<=19) {
			resp.getWriter().println("금액: "+720+"원");
		} else if (result>=20 && result <=64) {
			resp.getWriter().println("금액: "+1250+"원");
		} else {
			resp.getWriter().println("금액: "+0+"원");
		}
	}
}
