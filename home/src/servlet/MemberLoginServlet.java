package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
@WebServlet(urlPatterns = "/member/login.do")
public class MemberLoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain; charset=utf-8");
		
//		[1] 입력된 데이터 수신
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
//		[2] 데이터베이스에 데이터 전송 및 처리
			MemberDao dao = new MemberDao();
//			dao.login(id, pw);
			boolean result = dao.login(id, pw);
//		[3] 사용자 화면 구현
			if(result){
				resp.sendRedirect(req.getContextPath());
			}
			else {
				resp.sendRedirect("login.jsp?error");				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
		

	}
}
