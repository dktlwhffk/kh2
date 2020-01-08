package home.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.bean.MemberDao;
import home.bean.MemberDto;

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
			if(uri.equals("/index.do")) {
				destination = "/WEB-INF/view/index.jsp";
			}
			//로그인
			else if(uri.equals("/member/login.do")) {
				if(method.equalsIgnoreCase("get")) {
					destination = "/WEB-INF/view/member/login.jsp";
				}
				else if(method.equalsIgnoreCase("post")) {
//						준비
					req.setCharacterEncoding("UTF-8");
					String id = req.getParameter("id");
					String pw = req.getParameter("pw");
					
//						처리
					MemberDao dao = new MemberDao();
					boolean result = dao.login(id, pw);
					
//						출력
					if(result) {//로그인 성공 시
						
//							session에 아이디와 권한을 저장
//							session.setAttribute("id", id);
						req.getSession().setAttribute("id", id);
						MemberDto dto = dao.get(id);//id를 이용하여 전체 회원정보를 불러온다.
						req.getSession().setAttribute("grade", dto.getGrade());
						
//							추가 : 사용자의 최종 로그인 시각을 수정
						dao.updateLastLogin(id);
						
						destination = "redirect:/index.do";
					}
					else {//로그인 실패 시
//							error 메시지가 표시되는 로그인 화면으로 이동해라
						destination = "redirect:login.do?error";
					}
				}
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












