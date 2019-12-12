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

//## 회원 로그인 필터 구현
//
//로그인되지 않은 사용자가 회원 기능에 접근할 경우 이를 차단하는 필터를 구현하세요
//
//- 이름 : LoginFilter
//- 판단 기준 : session에 id가 있으면 통과, 없으면 로그인페이지로 강제이동
//- 주의 : 비회원이 접근 가능한 페이지는 검사하면 안됨

//@WebFilter(urlPatterns= {
//		"/member/info.jsp",
//		"/member/change_info.jsp",
//		"/member/change_info.do",
//		"/member/check.do",
//		"/member/check.jsp",
//		"/member/exit.do",
//		"/member/logout.do",
//		"/member/change_pw.jsp",
//		"/member/change_pw.do",
//		"/member/change.pw_result"
//})
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String id = (String) req.getSession().getAttribute("id");
		boolean login = id != null;
		if(login) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/member/login.jsp");
			System.out.println("로그인 필터 작동중!");
		}
	}
}
