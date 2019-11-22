package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SnackDao;

@WebServlet(urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		목표: snack 테이블에 데이터를 추가

//		1.사용자가 요청한 데이터를 추출 (name, price, stock)
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		int stock = Integer.parseInt(req.getParameter("stock"));

//		2.DB 처리
		try {
			SnackDao dao = new SnackDao();

			dao.insert(name, price, stock);

//		3.메세지 출력
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/plain; charset=UTF-8");
			resp.getWriter().println("완료");
		} catch (Exception e) {
//			오류가 발생하면 개발자가 볼 수 있도록 화면에 출력
			e.printStackTrace();
//			사용자에게 500이라는 상태값을 전달(내부 서버 오류)
			resp.sendError(500);
		}
	}
}
