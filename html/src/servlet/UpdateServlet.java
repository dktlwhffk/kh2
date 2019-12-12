package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KHMemberDao;

@WebServlet(urlPatterns = "/member/update.do")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			KHMemberDao dao = new KHMemberDao();
			dao.changePassword(req.getParameter("id"), req.getParameter("pw"), req.getParameter("newpw"));
			
			boolean result = dao.changePassword("id", "pw", "newpw");
			
			if(result) {
				resp.sendRedirect("update_success.jsp");
			} else {
				resp.sendRedirect("update_fail.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
