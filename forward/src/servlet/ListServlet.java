package servlet;

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
@WebServlet(urlPatterns="/list.do")
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//해야할 일
		//-db에서 member 목록을 불러온다
		//-jsp와 연동하여 불러온 목록을 출력할 수 있도록 데이터를 전달한다
		try {
			MemberDao dao = new MemberDao();
			List<MemberDto> list = dao.search("id", null);
			
			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/list.jsp");
			dispatcher.forward(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
