package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns = "/admin/alter.do")
public class AdminAlterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//수신
			req.setCharacterEncoding("utf-8");
			
			MemberDto dto = new MemberDto();
			dto.setId(req.getParameter("id"));
			System.out.println(req.getParameter("id"));
			dto.setPhone(req.getParameter("phone"));
			dto.setPost(req.getParameter("post"));
			dto.setBasic_addr(req.getParameter("basic_addr"));
			dto.setExtra_addr(req.getParameter("extra_addr"));		
			

			//처리
			MemberDao dao = new MemberDao();
			dao.changeInfo(dto);
			
			//출력
			
			resp.sendRedirect("detail.jsp?id="+dto.getId());
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
