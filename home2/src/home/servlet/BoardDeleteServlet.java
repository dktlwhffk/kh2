package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

@WebServlet(urlPatterns="/board/delete.do")
public class BoardDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			[1] 번호받고 [2] 삭제하고 [3] 이동시키자
			int no = Integer.parseInt(req.getParameter("no"));
			
//			주의: 반드시 관리자이거나 본인글일 경우만 삭제 기능을 실행, 아니면 403오류송출
			BoardDao dao = new BoardDao();
//			(1)글정보를 불러온다
			BoardDto dto = dao.get(no);
//			(2)본인글인지 검사 또는 관리자인지 검사
			String id = (String)req.getSession().getAttribute("id");
			String grade = (String)req.getSession().getAttribute("grade");
			boolean isAdmin = grade.equals("관리자");
			boolean isMine = id.equals(dto.getWriter());
			
			if(isAdmin||isMine) {
				dao.delete(no);
			}
			else {
				resp.sendError(403);
			}
			resp.sendRedirect("list.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
