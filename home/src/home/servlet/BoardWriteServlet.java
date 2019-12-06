package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.BoardDao;
import home.beans.BoardDto;

@WebServlet(urlPatterns = "/board/write.do")
public class BoardWriteServlet extends HttpServlet{
	@Override
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		
		try {
//			[1]수신->[2]등록->[3]이동
			BoardDao dao = new BoardDao();
			BoardDto dto = new BoardDto();
			
//			추가되는 내용
//			답글일 경우에는 파라미터에 no가 추가된다
//			no가 있다면 받아서 해당글의 정보를 불러온 뒤 dto에 설정한다
			
			if(req.getParameter("superno") !=null) {
				int no = Integer.parseInt(req.getParameter("superno"));
				BoardDto target = dao.get(no);
				dto.setSuperno(target.getNo());	//no복사
				dto.setGroupno(target.getGroupno());	//groupno 복사
				dto.setDepth(target.getDepth());	//depth 복사
			}
			
			String id = (String) req.getSession().getAttribute("id");
			String head = req.getParameter("head");
			String title = req.getParameter("title");
			String writer = id;
			String content = req.getParameter("content");
			
			
			int no = dao.getSequence(); 
			dto.setNo(no);
			
			
			dto.setHead(head);
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			dao.write(dto);
			
			
			resp.sendRedirect("content.jsp?no="+no);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
