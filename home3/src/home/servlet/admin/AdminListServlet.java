package home.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.MemberDao;
import home.beans.MemberDto;

@WebServlet(urlPatterns="/admin/list.do")
public class AdminListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String type = req.getParameter("type");
			String keyword = req.getParameter("keyword");
			
			boolean isSearch = type != null && keyword != null;
			
			MemberDao dao = new MemberDao();
			List<MemberDto> list;
			if(isSearch){
				list = dao.search(type, keyword);
			}
			else{
				list = null;
			}
			//이어지는 작업
			//-list.jsp로 포워딩 + 데이터 첨부(list)
			req.setAttribute("list", list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/list.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
