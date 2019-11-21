
package wel.come;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class WelcomeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		사용자가 요청했을 때 처리할 내용을 코드로 작성
//		System.out.println("hello!");
		
//		화면에 출력하려면 resp라는 객체를 사용해야 한다(응답정보)
		resp.setCharacterEncoding("UTF-8"); //문서 제작 인코딩 방식
		resp.setContentType("text/plain; charset=UTF-8"); //문서 유형+해석 방식
		resp.getWriter().println("hello!");
		resp.getWriter().println("안녕하세요!");
		resp.getWriter().println("반갑습니다!");
		
	}	
}
