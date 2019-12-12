package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KHMemberDao;
import beans.KHMemberDto;

@WebServlet(urlPatterns = "/kh_login")
public class KHLoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");

		KHMemberDao dao = new KHMemberDao();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		try {
			boolean login = dao.login(id, pw);
			if (login) {
				resp.getWriter().println("로그인 성공");
			} else {
				resp.getWriter().println("아이디 또는 비밀번호가 잘못되었습니다");
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
