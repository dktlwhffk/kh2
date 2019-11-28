package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;
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
			
			MemberDto dto = dao.get(id);
			dto.setId(id);
//			dto.setGrade(grade);
			boolean result = dao.login(id, pw);
//		[3] 사용자 화면 구현
			if(result){//로그인 성공시
				
//				session에 아이디와 권한을 저장
//				session.setAttribute("id", id);
				req.getSession().setAttribute("id",id);
				req.getSession().setAttribute("grade", dto.getGrade());
				
				
				resp.sendRedirect(req.getContextPath());
			}
			else {//로그인 실패시
				resp.sendRedirect("login.jsp?error");				
			}
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
		

	}
}
