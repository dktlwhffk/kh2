package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/member/change_pw.do")
public class MemberChangePwServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			[1] 수신
			req.setCharacterEncoding("UTF-8");
			String pw = req.getParameter("pw");
			
			String id = (String) req.getSession().getAttribute("id");
			
//			[2] 처리
			MemberDao dao = new MemberDao();
			dao.changePassword(id, pw);
			
//			[3] 이동
			resp.sendRedirect("change_pw_result.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}








