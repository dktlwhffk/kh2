package home.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns="/admin/out.do")
public class AdminOutServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			
			MemberDao dao = new MemberDao();
			dao.exit(id);
			
			resp.sendRedirect("list.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
