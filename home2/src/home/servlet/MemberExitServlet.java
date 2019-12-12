package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/member/exit.do")
public class MemberExitServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			[1] 누구를 탈퇴시켜야 하는지 필요한 정보를 얻어낸다
//			 - id는 session에서 구한다
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("id");
			
//			[2] 탈퇴와 로그아웃 처리를 수행
			session.removeAttribute("id");//id 항목 삭제
			session.removeAttribute("grade");//grade 항목 삭제

			MemberDao dao = new MemberDao();
			dao.exit(id);
			
//			[3] 특정 페이지로 이동
			resp.sendRedirect("exit_result.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}





