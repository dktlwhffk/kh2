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

@WebServlet(urlPatterns = "/kh_insert")
public class KHInsertServlet extends HttpServlet{
//	주소를 통해 데이터를 전달받아 kh_member 테이블에 insert를 수행하는 서블릿 구현
//	- 필요한 데이터들을 파라미터로 전달 받으세요
//	- 데이터베이스 처리는 KHMemberDao, KHMemberDto를 이용하여 처리하세요
//	- 오류가 발생하면 서버에 로그를 남기고 사용자에게 500 에러를 전송하세요
//	- 처리 주소는 http://localhost:8080/db/kh_insert
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain; charset=UTF-8");
//		사용자가 요청한 데이터 추출
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
//		db처리
//		List<KHMemberDto> list = new ArrayList<>();
		KHMemberDao dao = new KHMemberDao();
		KHMemberDto dto = new KHMemberDto();
		dto.setName(name);
		dto.setId(id);
		dto.setPw(pw);
		
		dao.regist(dto);
		resp.getWriter().println("완료");
		} catch (Exception e) {
			
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
