package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SnackDao;
import beans.SnackDto;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet{
//	SearchServlet.java
//	주소를 통해 데이터를 전달받아 snack 테이블에 이름을 검색하는 서블릿 구현
//	필요한 데이터를 파라미터로 전달받고
//	데이터베이스 처리는 SnackDao, SnackDto를 이용하여 처리하세요
//	오류가 발생하면 서버에 로그를 남기고 사용자에게 500 에러를 전송하세요
//	처리 주소는 http://localhost:8080/db/search
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");
		
		String keyword = req.getParameter("keyword");
		
		SnackDao dao = new SnackDao();
		try {
			
			List<SnackDto> list = dao.search(keyword);
			for(SnackDto dto : list) {
				resp.getWriter().println(dto.toString());
			}
			
		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}
}
