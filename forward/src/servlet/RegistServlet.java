package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import home.beans.MemberDao;
import home.beans.MemberDto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/regist.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String post = req.getParameter("post");
			String basic_addr = req.getParameter("basic_addr");
			String extra_addr = req.getParameter("extra_addr");
			String phone = req.getParameter("phone");
			
			MemberDto dto = new MemberDto();
			MemberDao dao = new MemberDao();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPost(post);
			dto.setBasic_addr(basic_addr);
			dto.setExtra_addr(extra_addr);
			dto.setPhone(phone);
			dao.regist(dto);
			
			resp.sendRedirect(req.getContextPath()+"/login.do");//절대경로
//			resp.sendRedirect("login.do"); //상대경로
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
