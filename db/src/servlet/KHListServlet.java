package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.KHMemberDao;
import beans.KHMemberDto;

@WebServlet(urlPatterns="/kh_list")
public class KHListServlet extends HttpServlet{
//	사용자의 요청을 받으면 kh_member 테이블 목록을 번호순으로 구하여 출력하도록 구현
//	처리 주소: /kh_list
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain; charset=UTF-8");
			
			KHMemberDao dao = new KHMemberDao();
			List<KHMemberDto> list = dao.getList();
			
			for(KHMemberDto dto : list) {
				resp.getWriter().println(dto.toString());
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
