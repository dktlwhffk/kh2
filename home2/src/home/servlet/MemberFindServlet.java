package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;

@WebServlet(urlPatterns = "/member/find.do")
public class MemberFindServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain; charset=utf-8");

		try {
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
//			String id = req.getParameter("id");
			
			MemberDao dao = new MemberDao();

			String result = dao.findid(name, phone);
			
			if(result !=null) {
			resp.sendRedirect("find_result.jsp?id="+result);	
			}
			else {
				resp.sendRedirect("find_result.jsp");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}