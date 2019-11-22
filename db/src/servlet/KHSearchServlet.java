package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KHMemberDao;
import beans.KHMemberDto;

@WebServlet(urlPatterns="/kh_search")
public class KHSearchServlet extends HttpServlet{
//	사용자의 요청을 받으면 kh_member 테이블 목록을 검색하여 번호순으로 정렬하여 출력하도록 구현
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");
		
		
		try {
			String name = req.getParameter("name");
			KHMemberDao dao = new KHMemberDao();
			List<KHMemberDto> list = dao.search(name);
			if(list.size()!=0) {
				for(KHMemberDto dto : list) {
					resp.getWriter().println(dto.toString());
				}
				resp.getWriter().println("출력 완료");
			} else {
				resp.getWriter().println("잘못된 검색어");
			}
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}	
//		System.out.println("입력완료");
	}
}
