package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.ReplyDao;
import home.beans.ReplyDto;

@WebServlet(urlPatterns="/board/reply_insert.do")
public class ReplyInsertServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		try {
			
			int no = Integer.parseInt(req.getParameter("no"));
			String id = (String) req.getSession().getAttribute("id");
			String rcontent = req.getParameter("rcontent");
			
			String rwriter = id;
			
			ReplyDao dao = new ReplyDao();
			ReplyDto dto = new ReplyDto();
			dto.setNo(no);
			dto.setRwriter(rwriter);
			dto.setRcontent(rcontent);
			
			dao.replyInsert(dto);
			
			BoardDao bdao = new BoardDao();
			bdao.calculate(no);
			
			resp.sendRedirect(req.getContextPath()+"/board/content.jsp?no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
