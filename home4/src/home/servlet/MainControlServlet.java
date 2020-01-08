package home.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.controller.Controller;
import home.controller.ControllerFactory;
import home.controller.IndexController;
import home.controller.member.MemberLoginController;

/**
 * 중앙 제어 서블릿
 *	- 우리 서버에 접속하는 모든 요청을 제어하기 위한 서블릿
 *	- 주소는 패턴으로 부여해야함
 */

@WebServlet(urlPatterns = "*.do")
public class MainControlServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			[1] 무슨 주소로 들어왔는지 분석
			String uri = req.getRequestURI();
//			System.out.println("uri = "+uri);
			
			//[2] 프로젝트명 제거
			uri = uri.substring(req.getContextPath().length());
//			System.out.println("uri = "+uri);
			
			//[3] 전송방식을 분석
			String method = req.getMethod();
//			System.out.println("method = "+method);
			
			//[4] uri와 method를 이용하여 조건을 설정해서 처리를 수행
			
			String destination = null;
			
			//메인
			
			//컨트롤러 선택
			Controller controller = ControllerFactory.create(uri);
			if(controller == null) {
				resp.sendError(404);
				return;
			}
			
			//선택된 컨트롤러에 일을 시킨다
			if(method.equalsIgnoreCase("get")) {
				destination = controller.doGet(req, resp);
			}
			else if(method.equalsIgnoreCase("post")) {
				destination = controller.doPost(req, resp);
			}
			
//			[5] 위에서 무슨짓을 해도 상관이 없으니까 문자열 하나만 얻어와서 처리
//			 - forward : 메인작업
//			 - redirect : 서브작업(특별한 표시가 필요)
//			 - null : 404
//			System.out.println(destination);
			if(destination == null) {
				resp.sendError(404);
			}
			else if(destination.startsWith("redirect:")) {
				destination = destination.substring("redirect:".length());
				resp.sendRedirect(req.getContextPath()+destination);
			}
			else {
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher(destination);
				dispatcher.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}












