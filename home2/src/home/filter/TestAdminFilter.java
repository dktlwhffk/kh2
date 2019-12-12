package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//개발용 관리자 로그인 필터
public class TestAdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
//		목표: 세션에 id = admin, grade = 관리자를 추가하는 것(관리자 로그인)
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpSession session = req.getSession();
		
		session.setAttribute("id", "admin");
		session.setAttribute("grade", "관리자");
		
		arg2.doFilter(arg0, arg1);
	}

}
