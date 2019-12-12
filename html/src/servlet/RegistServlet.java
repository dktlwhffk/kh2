package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SnackDao;

//사용자에게 보이지 않기 때문에 굳이 프로젝트 명을 언급할 필요가 없다
@WebServlet(urlPatterns="/insert/regist.do")
public class RegistServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
//			[1]입력페이지에서 전달한 데이터를 수신
				req.setCharacterEncoding("UTF-8");
				String name = req.getParameter("name");
				int price = Integer.parseInt(req.getParameter("price"));
				int stock = Integer.parseInt(req.getParameter("stock"));
//			[2]수신한 정보를 데이터베이스 등록
			SnackDao dao = new SnackDao();
			dao.insert(name, price, stock);
			
//			[3]준비된 결과 페이지로 강제 이동(출력 안함)
			resp.sendRedirect("regist_result.jsp");
			}
			catch(Exception e) {
				e.printStackTrace();
				resp.sendError(500);
			}
		}
	}
	

