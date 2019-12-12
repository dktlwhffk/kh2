package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KHMemberDao;
import beans.KHMemberDto;

@WebServlet(urlPatterns = "/insert2/regist.do")
public class RegistServlet2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			int point = Integer.parseInt(req.getParameter("point"));
			
			KHMemberDao dao = new KHMemberDao();
			KHMemberDto dto = new KHMemberDto();
			
			dto.setName(name);
			dto.setId(id);
			dto.setPw(pw);
			dto.setPoint(point);
			dao.regist(dto);
			
			resp.sendRedirect("regist_result.jsp");
			
		} catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
