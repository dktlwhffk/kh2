package home.servlet;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;
@WebServlet(urlPatterns="/member/regist.do")
public class MemberRegistServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain; charset=utf-8");
		
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String post = req.getParameter("post");
			String basic_addr = req.getParameter("basic_addr");
			String extra_addr = req.getParameter("extra_addr");
			String phone = req.getParameter("phone");
			
			MemberDao dao = new MemberDao();
			MemberDto dto = new MemberDto();
			
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setPost(post);
			dto.setBasic_addr(basic_addr);
			dto.setExtra_addr(extra_addr);
			dto.setPhone(phone);
			dao.regist(dto);
			
			
			resp.sendRedirect("regist_success.jsp");
		}
		catch(SQLIntegrityConstraintViolationException e){
			resp.sendRedirect("regist_fail.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
