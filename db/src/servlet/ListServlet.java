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

//목표: /list라는 주소로 요청이 들어왔을 때 snack 테이블의 모든 데이터를 출력
@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			SnackDao dao = new SnackDao();
			List<SnackDto> list = dao.getList();
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain; charset=UTF-8");
			
			for(SnackDto dto : list) {
				resp.getWriter().println(dto.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}	
	}
}
