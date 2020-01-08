package home.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.ReplyDao;

@WebServlet(urlPatterns="/board/reply_delete.do")
public class ReplyDeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			int rno = Integer.parseInt(req.getParameter("rno")); 
			ReplyDao dao = new ReplyDao();
			dao.replyDelete(rno);
			
			BoardDao bdao = new BoardDao();
			bdao.calculate(no);
			
			resp.sendRedirect(req.getContextPath()+"/board/content.do?no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
