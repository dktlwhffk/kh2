package home.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter(urlPatterns= {
//			"/member/info.jsp",
//			"/member/change_info.jsp",
//			"/member/change_info.do",
//			"/member/check.do",
//			"/member/check.jsp",
//			"/member/exit.do",
//			"/member/logout.do",
//			"/member/change_pw.jsp",
//			"/member/change_pw.do",
//			"/member/change.pw_result",
//			"/admin/*"
//	})
public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String grade = (String) req.getSession().getAttribute("grade");
		String id = (String) req.getSession().getAttribute("id");
		boolean admin = grade.equals("관리자");
//		boolean login = id !=null;
		if(admin) {
			chain.doFilter(request, response);
		} 
		else {
			resp.sendError(403);
			System.out.println("어드민 필터 작동중!");
		}
	}
}
